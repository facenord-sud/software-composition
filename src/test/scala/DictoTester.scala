import ch.unibe.scg.dicto.test.{DictoSuite}
import org.junit.runner.RunWith
import test.example.ExampleTest

/**
 * Created by leo on 19.11.14.
 */
/*@RunWith(value = classOf[Parameterized])
class DictoTester(subrule: Subrule) extends SimpleParametrizedTest(subrule){}*/

@RunWith(classOf[DictoSuite])
@DictoSuite.SuiteID("OtherTest")
@DictoSuite.ProjectRoot("/Users/leo/Documents/uni/master/seminar-software-composition/DummyProject")
@DictoSuite.SuiteClasses(Array(classOf[ExampleTest], classOf[ExampleTest2]))
class DictoTester {}
