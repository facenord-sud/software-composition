package ch.unibe.scg.dicto.examples

import ch.unibe.scg.dicto.definition.DSL._

/**
* An example class to show what the runner in tools/Runner.scala is doing.<br/>
* Actually, simply printing the generated DICTO code to the console
*/
class ExampleDicto {

   dicto {
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
