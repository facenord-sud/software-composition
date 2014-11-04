package ch.unibe.scg.dsl.modifiers

/**
 * Created by leo on 27.10.14.
 */
abstract class Modifier(val isFirst: Boolean = false) {
  def text():String
}
