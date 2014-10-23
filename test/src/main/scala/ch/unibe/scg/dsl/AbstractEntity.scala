package ch.unibe.scg.dsl

/**
 * Created by leo on 22.10.14.
 */
abstract class AbstractEntity {
  def can(entity:Entity)
  def dependsOn(entity:Entity)
}
