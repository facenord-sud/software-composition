package crawler

import java.io.{InputStreamReader, BufferedReader}
import java.net.{HttpURLConnection, URL}

/**
 * Created by leo on 17.10.14.
 */
class Request(var host:String, var _http:Boolean = true, var port:Integer = 3000) {
  var url:URL = null
  var verb:String = null
  var http:Boolean = _http
  var hashedParams:Map[String, String] = Map()

  def get(uri:String):String = {
    verb = "GET"
    url = constructUrl(uri)
    println(url)
    doIt()
  }

  def params(key:String, value:String):Request = {
    hashedParams += (key -> value)
    return this
  }

  def params(paramsArray:Array[Map[Symbol, String]]):Request = {
    for (param <- paramsArray) {
      params(param('key), param('value))
    }
    return this
  }

  def resetParams():Request = {hashedParams = Map(); return this}

 private def doIt():String = {
    val connection:HttpURLConnection = url.openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod(verb)
    connection.setDoInput(true)
    connection.setDoOutput(true)
    val responseStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    return Stream.continually(responseStream.readLine()).takeWhile(_ != null).mkString("\n")
  }

  private def constructUrl(uri:String):URL = {
    var protocol = "https"
    if(http == true) {
      protocol = "http"
    }
    var file = uri
    if(!uri.startsWith("/")) {
      file = "/" + uri
    }

    if(!hashedParams.isEmpty) {
      val stringParams = hashedParams.foldLeft("") {(s: String, pair: (String, String)) =>
        s + "&" + pair._1 + "=" + pair._2
      }
      file = file + "?" + stringParams.substring(1, stringParams.size )

//      val params:List[String] = List()
//      for((key, value) <- hashedParams) {
//        params :+ (key + "=" + value)
//      }
//      println(params(0))
//      println(params(1))
//      file = file + "?" + params.mkString("&")
    }

    if(host.startsWith("/") && !host.equals("/")) {
      host = host.substring(1, host.length - 1)
    }
    return new URL(protocol, host, port, file)
  }
}
