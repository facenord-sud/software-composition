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
    'Tests := Klass(parentClass = "junit.framework.TestCase")
    'Controller must dependOn('Model)
    'Model cannot dependOn('View and 'Controller)
    only('Tests can access('Model))
    'Tests and 'Model canOnly access('Model)
    'Controller must dependOn('View)
  }
}