package ch.unibe.scg.dsl.entity
import ch.unibe.scg.dsl.builder.Assignments

/**
 * Created by leo on 22.10.14.
 */
class ArrayEntity(_entity:Entity) extends AbstractEntity{
  var entities:List[Entity] = List(_entity)

  def and(symbol:Symbol):ArrayEntity = {
    val entity = Assignments.get(symbol)
    entities = entities :+ entity
    return this
  }

  override def can(text:String) = {
    for(entity <- entities) {
      entity.can(text)
    }
  }

  override def dependsOn(text: String): Unit = {
    for(entity <- entities) {
      entity.dependsOn(text)
    }
  }

  override def text(): String = ???
}
