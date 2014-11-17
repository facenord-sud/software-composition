package ch.unibe.scg.dicto.definition

import scala.xml.{XML, Node, Elem}

class DictoResult(file: String) {
  val xml = XML.loadFile(file)

}
