import ch.unibe.scg.dicto.definition.DSL._
import ch.unibe.scg.dicto.test.DictoTest
import org.junit.Test
import org.junit.runner.RunWith

/**
* Created by leo on 19.11.14.
*/

class ExampleTest2 {


  @DictoTest
  def testFourth = {
    //'Xxx := Package(name = "org.app.controller")
    //'Yyy := Package(name = "org.ap.model")
    //'Xxx must dependOn('Yyy)
    //'Yyy cannot dependOn('Yyy)
    //only('Xxx can access('Yyy))
    //only('Yyy can dependOn('Yyy))

  }
}
