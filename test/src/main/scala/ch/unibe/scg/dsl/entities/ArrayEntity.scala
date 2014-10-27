package ch.unibe.scg.dsl.entities
import ch.unibe.scg.dsl.builder.{RulesDefinition, Assignments}
import ch.unibe.scg.dsl.modifiers.Modifier
import ch.unibe.scg.dsl.rules.{Can, Rule, AbstractRule}
import ch.unibe.scg.dsl.statements.Statement

/**
 * Created by leo on 22.10.14.
 */
class ArrayEntity(_symbol:Symbol, _entity:Entity) extends AbstractEntity with AbstractRule{
  var entities:Map[Symbol, Entity] = Map[Symbol, Entity](_symbol -> _entity)

  def and(symbol:Symbol):ArrayEntity = {
    val entity = Assignments.get(symbol)
    entities = entities + (symbol -> entity)
    return this
  }

  override def text(): String = ???

  override def can(statement: Statement): Rule = {
//    for((identifier, entity) <- entities) {
//      RulesDefinition.rules ++ new Can()
//    }
    return null
  }

  override def can(modifier: Modifier, statement: Statement): Rule = ???

  override def must(statement: Statement): Rule = ???

  override def must(modifier: Modifier, statement: Statement): Rule = ???

  override def cannot(statement: Statement): Rule = ???

  override def cannot(modifier: Modifier, statement: Statement): Rule = ???
}
