package ch.unibe.scg.dsl.entity

import ch.unibe.scg.dsl.builder.{AbstractRule}

/**
 * Created by leo on 22.10.14.
 */
abstract class AbstractEntity extends AbstractRule{
  def text():String
}
