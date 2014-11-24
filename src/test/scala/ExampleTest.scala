package  test.example
import ch.unibe.scg.dicto.definition.Subrule
import ch.unibe.scg.dicto.test.DictoTest
import org.junit.Assert._
import org.junit.{BeforeClass, Ignore, Test}
import org.junit.runner.RunWith
import org.junit.runners.{Parameterized, JUnit4}
import ch.unibe.scg.dicto.definition.DSL._

class ExampleTest {

  @DictoTest
  def testOne():Unit = {
    'View := Package(name = "org.app.view")
    'Model := Package(name = "org.app.model")
    'Controller := Package(name = "org.app.controller")

    'View must dependOn('Model)
    'Model cannot dependOn('View and 'Controller)
    only('Controller can access('Model))
  }

  @DictoTest
  def testSecond = {
    'SuperClass := Klass(name = "SuperClass")
    'SubClass := Klass(name = "SubClass", parentClass = "SuperClass")
    'SuperClass cannot (access('SubClass))
  }
}