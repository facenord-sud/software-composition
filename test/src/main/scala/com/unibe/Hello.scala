package com.unibe

import ch.unibe.scg.dsl.definition.DSL
import ch.unibe.scg.dsl.entities.{Entity, Class, Package}
import ch.unibe.scg.dsl.wrapper.SymbolWrapper
import DSL._

object Hello {
  def main(args: Array[String]): Unit = {
//Model: Package with name="org.app.model"
//Controller: Package with name="org.app.model"
//Tests: Class with parentClass="junit.framework.TestCase"
//Controller must depend-on Model
//Model cannot depend-on View, Controller
//only Tests can access Model
//Tests, Model can only depend-on Controller
  'Model is_a Package(name="org.app.model")
  'Controller is_a Package(name = "org.app.controller")
  'Tests is_a Klass(parentClass = "junit.framework.TestCase")
  'Controller must dependOn ('Model)
  'Model cannot dependOn ('View and 'Controller)
  only('Tests can access ('Model))
  'Tests and 'Model can (only, access('Model))
  }
}
