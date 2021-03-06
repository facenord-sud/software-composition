package ch.unibe.scg.dicto.rules

import ch.unibe.scg.dicto.entities.{AbstractEntity, Entity}
import ch.unibe.scg.dicto.modifiers.Modifier
import ch.unibe.scg.dicto.statements.Statement

abstract class Rule(val subject: AbstractEntity, val statement: Statement) {
  var modifier: Modifier = null

  def text():String

  protected def generateText(action: String): String = {
    var modifierText = ""
    if (Option(modifier).isDefined) {
      if(modifier.isFirst) {
        return s"${modifier.text} ${subject.nameInstance} $action ${statement.text}"
      }
      modifierText = modifier.text()
    }
    s"${subject.nameInstance()} $action $modifierText ${statement.text}"
  }
}
