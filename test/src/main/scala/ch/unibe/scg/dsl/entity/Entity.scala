package ch.unibe.scg.dsl.entity

/**
 * Created by leo on 22.10.14.
 */
class Entity(val name:String) extends AbstractEntity{

  def and(entity:Entity):ArrayEntity = {
    return new ArrayEntity(entity)
  }

  override def dependsOn(text:String) = {}
  override def can(text:String) = {}
}
