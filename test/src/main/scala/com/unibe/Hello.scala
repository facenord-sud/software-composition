package com.unibe

import ch.unibe.scg.dsl.entity.{Entity, Class, Package}
import ch.unibe.scg.dsl.wrapper.SymbolWrapper

object Hello {
  def main(args: Array[String]): Unit = {
    implicit def symbolWrapper(symbol :Symbol) = { new SymbolWrapper(symbol) }

    'model is_a Package(name = "org.app.model")
    'controller := Package(name = "org.app.controller")
    'controller and 'model and 'view can access ('test)
    'controller dependsOn 'model
    println("Hello world")
  }

  def Package(name:String = ""):Entity = {
    new Package(name)
  }

  def access(symbol:Symbol):String = {return ""}

  def is_a() = {}


}
