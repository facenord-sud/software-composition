package ch.unibe.scg.dsl.builder

import ch.unibe.scg.dsl.entity.Entity

/**
 * Created by leo on 24.10.14.
 */
abstract class AbstractBuilder(val entity:Entity) {

  def toCode()
}
