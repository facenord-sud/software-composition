import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ch.unibe.scg.dsl._

class ArrayEntitySpec extends FlatSpec with ShouldMatchers {
  val arrayEntity = new ArrayEntity(new DummyEntity())
  val sizeEntity = arrayEntity.entities.size
  sizeEntity should equal (1)
  val dummyPackage = new DummyEntity()
  var entities =  arrayEntity.and(dummyPackage).entities
  entities(1) should equal(dummyPackage)
  arrayEntity.can(new DummyEntity())
  arrayEntity.dependsOn(new DummyEntity())
  for(entity <- entities) {
    val boolCan = entity.asInstanceOf[DummyEntity].isCan
    boolCan should equal (true)
    val boolDependsOn = entity.asInstanceOf[DummyEntity].isDependsOn
    boolDependsOn should equal (true)
  }
}

class DummyEntity extends Entity("") {
  var isDependsOn:Boolean = false
  var isCan:Boolean = false
  override def can(entity:Entity) = {
    isCan = true
  }

  override def dependsOn(entity:Entity) = {
    isDependsOn = true
  }
}
