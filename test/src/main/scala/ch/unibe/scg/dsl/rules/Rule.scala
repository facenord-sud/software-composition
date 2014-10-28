package ch.unibe.scg.dsl.rules

import ch.unibe.scg.dsl.entities.Entity
import ch.unibe.scg.dsl.modifiers.Modifier
import ch.unibe.scg.dsl.statements.Statement

abstract class Rule(val subject: Symbol, val statement: Statement) {
  var modifier: Modifier = null

  def text():String
}
