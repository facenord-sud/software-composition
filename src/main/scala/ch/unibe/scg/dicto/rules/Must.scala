package ch.unibe.scg.dicto.rules

import ch.unibe.scg.dicto.entities.{AbstractEntity, Entity}
import ch.unibe.scg.dicto.statements.Statement

/**
 * Created by leo on 27.10.14.
 */
class Must (val _subject: AbstractEntity, val _statement: Statement) extends Rule(_subject, _statement){
  override def text(): String = {
    generateText("must")
  }
}
