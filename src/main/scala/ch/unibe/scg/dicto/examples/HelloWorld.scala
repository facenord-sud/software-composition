package ch.unibe.scg.dicto.examples

import ch.unibe.scg.dicto.definition.DSL._

/**
* The most simple example to show that the our DSL generate DICTO code
*/
class HelloWorld {

  def main(args: Array[String]) = {
    val result = dicto {
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
    println(result)
  }
}
