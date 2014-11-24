package ch.unibe.scg.dicto.builder

import ch.unibe.scg.dicto.rules.Rule
import scala.collection.mutable.Map

/**
* Created by leo on 27.10.14.
*/
object RulesDefinition {
  var rules = List[Rule]()

  def clear(): Unit = {
    rules = List[Rule]()
  }

    def text(): String = {
    return rules.map { _.text() }.mkString("\n")
  }

  def add(rule: Rule) = {
    rules = rules :+ rule
  }
}
