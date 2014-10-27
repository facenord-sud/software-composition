package ch.unibe.scg.dsl.entity

/**
 * Created by leo on 22.10.14.
 */
abstract class AbstractEntity {
  def can(text:String):Unit
  def cannot(text:String):Unit
  def must(text:String):Unit
  def text():String
}
