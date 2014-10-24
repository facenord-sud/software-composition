import _root_.ch.unibe.scg.dsl.entity.{Entity, ArrayEntity}
import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ch.unibe.scg.dsl._

class ArrayEntitySpec extends FlatSpec with ShouldMatchers {
//  val arrayEntity = new ArrayEntity(new DummyEntity())
//  val dummyPackage = new DummyEntity()
//
//  "A new ArrayEntity" should "have a size of one" in {
//    val sizeEntity = arrayEntity.entities.size
//    sizeEntity should equal (1)
//  }
//
//  "An ArrayEntity.and(entity)" should "add the entity to the ArrayEntity" in {
//    val entities =  arrayEntity.and(dummyPackage).entities(1) should equal(dummyPackage)
//  }
//
//  "Call of method from AbstractEntity" should "change the instance vars of DummyEntity" in {
//    arrayEntity.can("foo")
//    arrayEntity.dependsOn("bar")
//    for(entity <- arrayEntity.entities) {
//      val boolCan = entity.asInstanceOf[DummyEntity].isCan
//      boolCan should equal (true)
//      val boolDependsOn = entity.asInstanceOf[DummyEntity].isDependsOn
//      boolDependsOn should equal (true)
//    }
//  }
}

class DummyEntity extends Entity("") {
  var isDependsOn:Boolean = false
  var isCan:Boolean = false
  override def can(text:String) = {
    isCan = true
  }

  override def dependsOn(text:String) = {
    isDependsOn = true
  }
}
