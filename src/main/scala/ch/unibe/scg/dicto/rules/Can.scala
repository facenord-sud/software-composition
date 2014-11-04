package ch.unibe.scg.dicto.rules

import ch.unibe.scg.dicto.entities.{AbstractEntity, Entity}
import ch.unibe.scg.dicto.statements.Statement
import ch.unibe.scg.dicto.builder.Assignments

/**
 * Created by leo on 27.10.14.
 */
class Can(val _subject: AbstractEntity, val _statement: Statement) extends Rule(_subject, _statement){
  override def text(): String = {
    generateText("can")
  }
}
