package ch.unibe.scg.dsl.entities

import ch.unibe.scg.dsl.rules.Rule

/**
* Created by leo on 22.10.14.
*/

class Entity(val name:String) extends AbstractEntity{

  var symbol: Symbol = null

    override def text():String = ???
    override def nameInstance(): String = symbol.name

  def parameters(parameters:Map[Symbol, String]): String = {
    var result:List[String] = List[String]()
    for((name, value) <- parameters) {
      if(!Option(value).isEmpty) {
        result = result :+ (name.name  + "=\"" + value + "\"")
      }
    }
    if(result.length == 0) {
      return ""
    } else {
      "with " + result.mkString(", ")
    }
  }

  def typeEntity():String = {
    this.getClass.getSimpleName
  }

  def generateCode(parametersToEncode:Map[Symbol, String]):String = {
    typeEntity() + " " + parameters(parametersToEncode)
  }


}
