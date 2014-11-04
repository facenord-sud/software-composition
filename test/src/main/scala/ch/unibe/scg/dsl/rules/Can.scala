package ch.unibe.scg.dsl.rules

import ch.unibe.scg.dsl.entities.{AbstractEntity, Entity}
import ch.unibe.scg.dsl.statements.Statement
import ch.unibe.scg.dsl.builder.Assignments

/**
 * Created by leo on 27.10.14.
 */
class Can(val _subject: AbstractEntity, val _statement: Statement) extends Rule(_subject, _statement){
  override def text(): String = {
    generateText("can")
  }
}
