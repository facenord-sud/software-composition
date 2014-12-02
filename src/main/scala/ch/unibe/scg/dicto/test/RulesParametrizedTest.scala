package ch.unibe.scg.dicto.test

import java.net.URL
import java.util
import ch.unibe.scg.dicto.builder.{Rules, RulesDefinition, Assignments}
import ch.unibe.scg.dicto.test.exceptions.{RulesNotCreatedException, SuiteNotCreatedException}
import com.mashape.unirest.http.{HttpResponse, Unirest}
import com.mashape.unirest.request.body.RequestBodyEntity
import org.junit.Test
import org.junit.Assert._
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

import scala.reflect.runtime.{universe => ru}

import scala.xml.{XML, Elem}

import ch.unibe.scg.dicto.definition.Subrule
import collection.mutable._

import collection.JavaConversions._


@RunWith(value = classOf[Parameterized])
class RulesParametrizedTest(subRule: Subrule) {

  @Test
  def dictoTest() = {
    val errorMessage = s"Subrule ${subRule.value} (id: ${subRule.id}) has failed:\n"  + subRule.error
    assertFalse(errorMessage, subRule.isFailed)
  }
}

object RulesParametrizedTest {

  val host = ProjectDefinition.serverAddress
  val DICTO = "$DICTO"

  @Parameters(name = "subrule {index}: {0}")
  def parameters: util.Collection[Array[Subrule]] = {
    val list = new util.ArrayList[Array[Subrule]]()
    createSuiteIfNotExists
    createRules
    generateRule
    import java.nio.file.{Paths, Files}
    import java.nio.charset.StandardCharsets
    Files.write(Paths.get("/Users/leo/Desktop/results.txt"), getResults.getBytes(StandardCharsets.UTF_8))
    val results: Elem = XML.loadString(getResults)
    (results \ "rules" \ "rule").foreach { rule =>
      (rule \ "subrule").foreach { subruleElem =>
        list.add(Array(new Subrule(subruleElem)))
      }
    }
    list
  }

  def createSuiteIfNotExists = {
    val response = Unirest.get(host + "/suites").asString().getBody
    if(!response.contains(ProjectDefinition.suiteId)) {
      val request = post("suite", s"""{
            |"$DICTO.SUITEID": "${ProjectDefinition.suiteId}",
            |	"$DICTO.PROJECT-ROOT": "${ProjectDefinition.projectRoot}",
            |	"$DICTO.PROJECT-SRC": "src/",
            |	"$DICTO.PROJECT-BIN": "bin/"
            }""".stripMargin)
      if(!checkResult(request)) {
        throw new SuiteNotCreatedException("The suite can be created")
      }
    }
  }

  def createRules = {
    //println(s"""{"rules": "${escape(Rules.code)}"}""")
    if(!checkResult(post(ProjectDefinition.suiteId + "/rules", s"""{"rules": "${escape(Rules.code)}"}"""))) {
      throw new RulesNotCreatedException("The rules:\n" + Rules.code + "have not been created")
    }
  }


  def generateRule = {
    Unirest.setTimeouts(2000000, 6000000)
    Unirest.post(s"$host/${ProjectDefinition.suiteId}/run")
      .header("accept", "application/json")
      .header("Content-Type", "application/json; charset=UTF-8")
      .asString()
  }

  def getResults :String = {
    val response = Unirest.get(s"$host/${ProjectDefinition.suiteId}/resultsXML").asString()
    response.getBody
  }

  def escape(raw: String): String = {
    raw.replaceAll("\"", "\\\\" + "\"")
  }

  def post(path :String, body: String) = {
    Unirest.post(host + "/" + path)
      .header("accept", "application/json")
      .header("Content-Type", "application/json; charset=UTF-8")
      .body(body)
  }

  def checkResult(request :RequestBodyEntity) :Boolean = {
    val response = request.asJson()
    val body = response.getBody
    response.getCode == 200 && !body.isArray && body.getObject.has("result") && body.getObject.get("result") == "success"
  }

}
