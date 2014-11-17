package ch.unibe.scg.dicto.definition

import ch.unibe.scg.dicto.builder.{RulesDefinition, Assignments}
import ch.unibe.scg.dicto.entities.{ArrayEntity, Method, Class, Package, Entity}
import ch.unibe.scg.dicto.modifiers.{Only, Modifier}
import ch.unibe.scg.dicto.rules.Rule
import ch.unibe.scg.dicto.statements.{DependOn, Access, Statement}
import ch.unibe.scg.dicto.wrapper.SymbolWrapper

import scala.xml._
import org.junit.Assert._

object DSL {
  implicit def symbolWrapper(symbol :Symbol) = { new SymbolWrapper(symbol) }

  def Package(name:String):Package = {
    new Package(name)
  }

  def Klass(name:String = null, parentClass:String = null):Class = {
    new Class(name, parentClass)
  }

  def Method(name:String):Method = {
    new Method(name)
  }

  def access(symbol:Symbol):Statement = {
    new Access(Assignments get symbol)
  }

  def dependOn(symbol:Symbol):Statement = {
    new DependOn(Assignments get symbol)
  }
  def dependOn(symbol:ArrayEntity):Statement = {
    new DependOn(symbol)
  }

  def only(rule: Rule):Unit = {
    rule.modifier = new Only(isFirst=true)
  }

  def assertDicto(code: => Unit):Unit = {
    val file: String = this.getClass.getResource("/results.xml").getPath
    val xml:Elem = XML.loadFile(file)
    (xml \ "rules" \ "rule").foreach { rule =>
    if((rule \ "@failed").text == "true") {
        (rule \ "subrule").foreach { subruleElem =>
          var subRule = new Subrule(subruleElem)
        if(subRule.isFailed) {
            var errorMessage = s"Subrule ${subRule.value} (id: ${subRule.id}) has failed:" + "\n" + subRule.error
          assertTrue(errorMessage, false)
          }
        }
      }
    }
  }

  def dicto(code: => Unit): String =  {
    Assignments.clear()
    RulesDefinition.clear()
    code
    Assignments.text() + "\n\n" + RulesDefinition.text()
  }
}
