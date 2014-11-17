package ch.unibe.scg.dicto.definition

import scala.xml._

class Subrule(elem: Node) {
  val failed: String = (elem \ "@failed").text
  val error: String = (elem \ "error").text
  val id: String = (elem \ "@id").text
  val value: String = (elem \ "@value").text
  val isFailed: Boolean = failed == "true"
}
