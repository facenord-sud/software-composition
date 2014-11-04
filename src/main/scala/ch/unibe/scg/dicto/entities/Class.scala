package ch.unibe.scg.dicto.entities

/**
 * Created by leo on 22.10.14.
 */
class Class(name:String = null, val parentClass:String = null) extends Entity(name){
  override def text(): String = {
    generateCode(Map('name -> name, 'parentClass -> parentClass))
  }
}
