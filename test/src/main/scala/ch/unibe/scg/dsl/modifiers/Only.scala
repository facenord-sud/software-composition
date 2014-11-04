package ch.unibe.scg.dsl.modifiers

/**
* Created by leo on 27.10.14.
*/
class Only(isFirst: Boolean = false) extends Modifier(isFirst){
  override def text(): String = {
    "only"
  }
}
