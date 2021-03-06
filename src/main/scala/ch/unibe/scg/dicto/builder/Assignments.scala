package ch.unibe.scg.dicto.builder

import ch.unibe.scg.dicto.entities._
import ch.unibe.scg.dicto.definition.DSL._
import scala.collection.mutable
import scala.collection.mutable.Map

object Assignments {
  var variables = Map[Symbol, Entity]()

  def add(key:Symbol, value:Entity) = {
    variables = variables + (key -> value)
  }

  def text():String = {
    var result:List[String] = List[String]()
    for((key, value) <- variables) {
      result = result :+ (key.text() + "=" + value.text())
    }
    result.mkString("\n")
  }

  def clear() = {
    variables = Map[Symbol, Entity]()
  }

  def get(symbol:Symbol):Entity = {
    variables(symbol)
  }
 }
