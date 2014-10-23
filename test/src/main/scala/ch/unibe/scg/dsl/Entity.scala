package ch.unibe.scg.dsl

/**
 * Created by leo on 22.10.14.
 */
class Entity(val name:String) extends AbstractEntity{

  def and(entity:Entity):ArrayEntity = {
    return new ArrayEntity(entity)
  }

  override def dependsOn(entity:Entity) = {}
  override def can(entity:Entity) = {}
}
