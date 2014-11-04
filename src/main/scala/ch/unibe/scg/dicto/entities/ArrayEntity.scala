package ch.unibe.scg.dicto.entities
import ch.unibe.scg.dicto.builder.{RulesDefinition, Assignments}
import ch.unibe.scg.dicto.modifiers.{Only, Modifier}
import ch.unibe.scg.dicto.rules._
import ch.unibe.scg.dicto.statements.Statement

/**
 * Created by leo on 22.10.14.
 */
class ArrayEntity(_entity:Entity) extends AbstractEntity with AbstractRule{
  var entities: List[Entity] = List[Entity](_entity)

  def and(symbol:Symbol):ArrayEntity = {
    val entity = Assignments.get(symbol)
    entities = entities :+ entity
    return this
  }

  override def nameInstance(): String = {
    entities.map { _.nameInstance() }.mkString(", ")
  }
  override def text(): String = ???

  override def can(statement: Statement): Rule = {
    generateRules(new Can(this, statement))
  }

  override def canOnly(statement: Statement): Rule = {
    val _can = new Can(this, statement)
    _can.modifier = new Only()
    generateRules(_can)
  }

  override def must(statement: Statement): Rule = {
    generateRules(new Must(this, statement))
  }


  override def cannot(statement: Statement): Rule = {
    generateRules(new Cannot(this, statement))
  }
}
