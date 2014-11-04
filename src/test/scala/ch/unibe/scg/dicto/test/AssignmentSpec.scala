package ch.unibe.scg.dicto.test

import ch.unibe.scg.dicto.builder.Assignments
import ch.unibe.scg.dicto.definition.DSL._
import ch.unibe.scg.dicto.entities.Entity
import org.scalatest._

class AssignmentSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  override def beforeEach() = {
    Assignments.clear
  }

  "Assigning a Package" should "produces the correct code" in {
    val name = "foo.bar"
    testAssignment("Package", Package(name), name)
  }

  "Assigning a Class" should "produces the correct code" in {
    val name = "FooBar"
    testAssignment("Class", Klass(name), name)
  }

  "Assigning a Method" should "produces the correct code" in {
    val name = "fooBar"
    testAssignment("Method", Method(name), name)
  }

  "Assigning multiple attributes" should "work for a class" in {
    val symbol = 'var
    val name = "foo.bar"
    val parentClass = "bar.foo"
    symbol is_a Klass(name = name, parentClass = parentClass)
    Assignments.text() should equal (s"${symbol.text}:Class with name=" + '"' + name + "\", parentClass=" + '"' + parentClass + '"')
  }

  def testAssignment(entityType:String, entity:Entity, name:String) = {
    val symbol = 'symbol
    Assignments.clear
    symbol is_a entity
    val expected = s"${symbol.text}:$entityType with name=" + "\"" + name + "\""
    Assignments.text() should equal (expected)
  }
}