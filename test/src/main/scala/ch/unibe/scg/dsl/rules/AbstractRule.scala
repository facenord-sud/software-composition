package ch.unibe.scg.dsl.rules

import ch.unibe.scg.dsl.builder.RulesDefinition
import ch.unibe.scg.dsl.modifiers.Modifier
import ch.unibe.scg.dsl.statements.Statement

/**
 * Created by leo on 27.10.14.
 */
trait AbstractRule {
  def can(statement: Statement):Rule
  def canOnly(statement: Statement): Rule
  def cannot(statement: Statement):Rule
  def must(statement: Statement):Rule

  protected def generateRules(rule: Rule):Rule = {
    RulesDefinition.add(rule)
    return rule
  }
}
