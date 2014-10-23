package com.unibe
import ch.unibe.scg.dsl.{Package, Class, Method, Entity}

object Hello {
  def main(args: Array[String]): Unit = {
    val model = new Package(name = "org.app.model")
    val controller = new Package(name = "org.app.controller")
    val view = new Package(name = "org.app.view")
    val test = new Class(parentClass = "org.junit.Test")
    controller and model and view can access(test)
    println("hello world")
  }

  def access(entity:Entity):Entity = {return null}

  def is_a() = {}
}
