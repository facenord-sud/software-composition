package ch.unibe.scg.dsl.rules

import ch.unibe.scg.dsl.entities.Entity
import ch.unibe.scg.dsl.statements.Statement

/**
 * Created by leo on 27.10.14.
 */
class Cannot(val _subject: Entity, val _statement: Statement) extends Rule(_subject, _statement) {

override def text(): String = ???
}
