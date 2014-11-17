package ch.unibe.scg.dicto.definition

import scala.xml.{XML, Node, Elem}

class Rule(rule: Node) {
  val isFailed: Boolean = (rule \ "@failed").text == true
  def subRules():Unit = {}

}
