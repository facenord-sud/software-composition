package ch.unibe.scg.dsl

/**
 * Created by leo on 22.10.14.
 */
class ArrayEntity(_entity:Entity) extends AbstractEntity{
  var entities:List[Entity] = List(_entity)

  def and(entity:Entity):ArrayEntity = {
    entities = entities :+ entity
    return this
  }

  override def can(_entity:Entity) = {
    for(entity <- entities) {
      entity.can(_entity)
    }
  }

  override def dependsOn(_entity: Entity): Unit = {
    for(entity <- entities) {
      entity.dependsOn(_entity)
    }
  }
}
