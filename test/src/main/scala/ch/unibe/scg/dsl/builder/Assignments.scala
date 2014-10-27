package ch.unibe.scg.dsl.builder

import ch.unibe.scg.dsl.entities._
import ch.unibe.scg.dsl.definition.DSL._

object Assignments {
  var variables = Map[Symbol, Entity]()

  def add(key:Symbol, value:Entity) = {
    variables = variables + (key -> value)
  }

  def text():String = {
    var result:List[String] = List[String]()
    for((key, value) <- variables) {
      result = result :+ (key.text() + ":" + value.text())
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
