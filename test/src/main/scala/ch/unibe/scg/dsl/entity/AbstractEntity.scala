package ch.unibe.scg.dsl.entity

/**
 * Created by leo on 22.10.14.
 */
abstract class AbstractEntity {
  def can(text:String)
  def dependsOn(text:String)
}
