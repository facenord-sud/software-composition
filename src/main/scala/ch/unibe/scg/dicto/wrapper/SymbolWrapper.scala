package ch.unibe.scg.dicto.wrapper

import ch.unibe.scg.dicto.builder.{RulesDefinition, Assignments}
import ch.unibe.scg.dicto.entities.{ArrayEntity, Entity, Package}
import ch.unibe.scg.dicto.modifiers.{Modifier, Only, Not}
import ch.unibe.scg.dicto.rules.{Can, Rule, AbstractRule, Must, Cannot}
import ch.unibe.scg.dicto.statements.{Statement}

/**
 * Created by leo on 24.10.14.
 */
class SymbolWrapper(symbol:Symbol) extends AbstractRule{

  def is_a(entity:Entity) = {
    entity.symbol = symbol
    Assignments.add(symbol, entity)
  }

  def :=(entity:Entity) = {
    is_a(entity)
  }
  def and(_symbol:Symbol):ArrayEntity = {
    return new ArrayEntity(getEntity).and(_symbol)
  }
  def text():String = {
    symbol.name
  }

  override def can(statement: Statement): Rule = {
    generateRules(new Can(getEntity, statement))
  }

  override def canOnly(statement: Statement): Rule = {
    val _can = new Can(getEntity, statement)
    _can.modifier = new Only()
    generateRules(_can)
  }

  override def must(statement: Statement): Rule = {
    generateRules(new Must(getEntity, statement))
  }

  override def cannot(statement: Statement): Rule = {
    generateRules(new Cannot(getEntity, statement))
  }

  private def getEntity(): Entity = {
    Assignments.get(symbol)
  }
}
