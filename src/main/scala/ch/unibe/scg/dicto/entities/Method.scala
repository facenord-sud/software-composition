package ch.unibe.scg.dicto.entities

/**
 * Created by leo on 22.10.14.
 */
class Method(name:String, params:String = null) extends Entity(name){
  override def text(): String = {
    
    generateCode(Map('name -> name, 'params -> params))
  }
}
