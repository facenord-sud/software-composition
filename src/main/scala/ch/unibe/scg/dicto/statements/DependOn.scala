package ch.unibe.scg.dicto.statements

import ch.unibe.scg.dicto.entities.{AbstractEntity, Entity}

/**
 * Created by leo on 27.10.14.
 */
class DependOn(entity: AbstractEntity) extends Statement(entity) {
  override def text(): String = {
    "depend on " + entity.nameInstance()
  }
}
