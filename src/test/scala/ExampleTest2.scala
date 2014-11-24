import ch.unibe.scg.dicto.definition.DSL._
import ch.unibe.scg.dicto.test.DictoTest
import org.junit.Test
import org.junit.runner.RunWith

/**
* Created by leo on 19.11.14.
*/

class ExampleTest2 {

  @DictoTest
  def testThird = {
    'XXX := Method(name = "aMethod")
    'YYY := Klass(name = "AClass")
    'XXX must (dependOn('YYY))
  }
}
