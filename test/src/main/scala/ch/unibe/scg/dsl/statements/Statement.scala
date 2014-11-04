package ch.unibe.scg.dsl.statements

 import ch.unibe.scg.dsl.entities.{AbstractEntity}

abstract class Statement(var entity: AbstractEntity) {
  def text():String
}
