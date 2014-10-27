package ch.unibe.scg.dsl.entity

import scala.reflect.runtime.{universe => ru}
/**
 * Created by leo on 22.10.14.
 */
class Class(name:String = null, val parentClass:String = null) extends Entity(name){
  override def text(): String = {
    generateCode(Map('name -> name, 'parentClass -> parentClass))
  }
}
