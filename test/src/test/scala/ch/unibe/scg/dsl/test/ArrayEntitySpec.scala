package ch.unibe.scg.dsl.test

//import ch.unibe.scg.dsl.builder.Assignments
import ch.unibe.scg.dsl.definition.DSL._
import ch.unibe.scg.dsl.entity.{ArrayEntity, Entity}
import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class ArrayEntitySpec extends FlatSpec with ShouldMatchers {
  val arrayEntity = new ArrayEntity(new DummyEntity())
  val dummyPackage = new DummyEntity()

  //
  "A new ArrayEntity" should "have a size of one" in {
    val sizeEntity = arrayEntity.entities.size
    sizeEntity should equal (1)
  }

  "An ArrayEntity.and(entity)" should "add the entity to the ArrayEntity" in {
    'dummy is_a dummyPackage
    val entities =  arrayEntity.and('dummy).entities(1) should equal(dummyPackage)
  }

  "Call of method from AbstractEntity" should "change the instance vars of ch.unibe.scg.dsl.test.DummyEntity" in {
    arrayEntity.can("foo")
    arrayEntity.dependsOn("bar")
    for(entity <- arrayEntity.entities) {
      val boolCan = entity.asInstanceOf[ch.unibe.scg.dsl.test.DummyEntity].isCan
      boolCan should equal (true)
      val boolDependsOn = entity.asInstanceOf[ch.unibe.scg.dsl.test.DummyEntity].isDependsOn
      boolDependsOn should equal (true)
    }
  }
}

class DummyEntity extends Entity("") {
  var isDependsOn:Boolean = false
  var isCan:Boolean = false
  override def can(text:String):Unit = {
    isCan = true
  }

  override def dependsOn(text:String):Unit = {
    isDependsOn = true
  }

  override def text():String = {
    generateCode(Map())
  }
}
