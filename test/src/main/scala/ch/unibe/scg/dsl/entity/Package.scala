package ch.unibe.scg.dsl.entity

/**
 * Created by leo on 22.10.14.
 */
class Package(name:String) extends Entity(name){
  override def text(): String = {
    generateCode(Map('name -> name))
  }
}
