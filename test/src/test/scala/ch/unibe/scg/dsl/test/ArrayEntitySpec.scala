package ch.unibe.scg.dsl.test

//import ch.unibe.scg.dsl.builder.Assignments

import ch.unibe.scg.dsl.builder.RulesDefinition
import ch.unibe.scg.dsl.definition.DSL._
import ch.unibe.scg.dsl.entities.{ArrayEntity, Entity}
import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class ArrayEntitySpec extends FlatSpec with Matchers {
  val dummy0 = Package(name = "foo.bar")
  'dummy0 is_a dummy0
  val arrayEntity = new ArrayEntity('dummy0, dummy0)
  val dummyPackage = new DummyEntity()

  //
  "A new ArrayEntity" should "have a size of one" in {
    val sizeEntity = arrayEntity.entities.size
    sizeEntity should equal (1)
  }

  "An ArrayEntity.and(entity)" should "add the entity to the ArrayEntity" in {
    'dummy is_a dummyPackage
    val entities =  arrayEntity.and('dummy).entities('dummy) should equal(dummyPackage)
  }

  "Call one of the rule for ArrayEntity" should "add rules to the singleton" in {
    arrayEntity.can(dependOn('dummy))
    RulesDefinition.rules.size should equal (2)
  }
}

class DummyEntity extends Entity("foo.bar") {


  override def text():String = {
    generateCode(Map())
  }
}
