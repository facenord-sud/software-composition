package ch.unibe.scg.dsl.wrapper

import ch.unibe.scg.dsl.builder.Assignments
import ch.unibe.scg.dsl.entities.{ArrayEntity, Entity, Package}
import ch.unibe.scg.dsl.modifiers.Modifier
import ch.unibe.scg.dsl.rules.{Can, Rule, AbstractRule}
import ch.unibe.scg.dsl.statements.Statement

/**
 * Created by leo on 24.10.14.
 */
class SymbolWrapper(symbol:Symbol) extends AbstractRule{

  def is_a(entity:Entity) = {
    Assignments.add(symbol, entity)
  }

  def ::(entity:Entity) = {
    is_a(entity)
  }
  def and(symbol:Symbol):ArrayEntity = {
    return new ArrayEntity(new Package(""))
  }

  def text():String = {
    symbol.name
  }

  override def can(statement: Statement): Rule = {
    new Can(Assignments.get(symbol), statement)
  }

  override def can(modifier: Modifier, statement: Statement): Rule = {
    val _can = can(statement)
    _can.modifier = modifier
    _can
  }

  override def must(statement: Statement): Rule = ???

  override def must(modifier: Modifier, statement: Statement): Rule = ???

  override def cannot(statement: Statement): Rule = ???

  override def cannot(modifier: Modifier, statement: Statement): Rule = ???
}
