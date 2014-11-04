package ch.unibe.scg.dicto.test

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ch.unibe.scg.dicto.entities.{Entity}



class EntitySpec extends FlatSpec with ShouldMatchers {
  "Hello" should "have tests" in {
    true should be === true
  }

  "Entity#multipleParameters" should "return the correct string" in {
   val e = new Entity("")
    val result = e.parameters(Map('name -> "test", 'other -> null))
    result should equal ("with name=\"test\"")
  }
}
