package ch.unibe.scg.dsl.wrapper

import ch.unibe.scg.dsl.builder.Assignments
import ch.unibe.scg.dsl.entity.{ArrayEntity, Entity, Package}

/**
 * Created by leo on 24.10.14.
 */
class SymbolWrapper(symbol:Symbol) {

  def is_a(entity:Entity) = {
    Assignments.add(symbol, entity)
  }

  def :=(entity:Entity) = {
    is_a(entity)
  }
  def and(symbol:Symbol):ArrayEntity = {
    return new ArrayEntity(new Package(""))
  }

  def text():String = {
    symbol.name
  }

  def dependsOn(symbol:Symbol) = {}
}
