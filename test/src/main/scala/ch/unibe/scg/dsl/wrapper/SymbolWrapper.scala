package ch.unibe.scg.dsl.wrapper

import ch.unibe.scg.dsl.entity.{ArrayEntity, Entity}

/**
 * Created by leo on 24.10.14.
 */
class SymbolWrapper(symbol:Symbol) {
  def is_a(entity:Entity) = {}

  def :=(entity:Entity) = {}
  def and(symbol:Symbol):ArrayEntity = {
    return new ArrayEntity(new Entity(""))
  }

  def dependsOn(symbol:Symbol) = {}
}
