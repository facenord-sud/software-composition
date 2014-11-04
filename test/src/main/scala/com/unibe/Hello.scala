package com.unibe

import ch.unibe.scg.dsl.definition.DSL
import ch.unibe.scg.dsl.entities.{Entity, Class, Package}
import ch.unibe.scg.dsl.wrapper.SymbolWrapper
import ch.unibe.scg.dsl.builder._
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
  'View := Package(name="org.app.view")
  'Model := Package(name="org.app.model")
  'Controller := Package(name = "org.app.controller")
  'Tests := Klass(parentClass = "junit.framework.TestCase")
  'Controller must dependOn ('Model)
  'Model cannot dependOn ('View and 'Controller)
  only('Tests can access ('Model))
  'Tests and 'Model canOnly access('Model)
  'Controller must dependOn ('View)
  println (Assignments.text)
  println (RulesDefinition.text)
  }
}
