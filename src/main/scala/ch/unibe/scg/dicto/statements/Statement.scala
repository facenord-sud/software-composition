package ch.unibe.scg.dicto.statements

 import ch.unibe.scg.dicto.entities.{AbstractEntity}

abstract class Statement(var entity: AbstractEntity) {
  def text():String
}
