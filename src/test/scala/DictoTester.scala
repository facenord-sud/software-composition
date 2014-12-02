import ch.unibe.scg.dicto.test.{DictoTest, DictoSuite}
import org.junit.runner.RunWith
import test.example.ExampleTest
import ch.unibe.scg.dicto.definition.DSL._
/**
* Created by leo on 19.11.14.
*/
/*@RunWith(value = classOf[Parameterized])
class DictoTester(subrule: Subrule) extends SimpleParametrizedTest(subrule){}*/

@RunWith(classOf[DictoSuite])
//@DictoSuite.SuiteID("XXX") //-> optional, usually a  hash is generated
@DictoSuite.ProjectRoot("/Users/leo/Documents/uni/master/seminar-software-composition/dicto/TestProject")
//@DictoSuite.SuiteClasses(Array(classOf[ExampleTest], classOf[ExampleTest2])) -> optional you can include other class with DICTO DSL inside
//@DictoSuite.ServerAddress("http://localhost:4567") //-> OPTIONAL you can change the server address
class DictoTester {

  @DictoTest
  def test = {
    'Application := Package(name="org.jhotdraw.application")
    'Contrib := Package(name="org.jhotdraw.contrib")
    'Util := Package(name="org.jhotdraw.util")
    'Test := Package(name="org.jhotdraw.test")

    'Application must dependOn('Contrib)
    only('Application can dependOn('Util))            //fails
    'Test cannot dependOn('Application) 		//fails
    'Application canOnly dependOn('Test)  		//fails
  }
}
