package ch.unibe.scg.dsl.definition

import ch.unibe.scg.dsl.entity.{ArrayEntity, Method, Class, Package}
import ch.unibe.scg.dsl.wrapper.SymbolWrapper

object DSL {
  implicit def symbolWrapper(symbol :Symbol) = { new SymbolWrapper(symbol) }

  def Package(name:String):Package = {
    new Package(name)
  }

  def Class(name:String = null, parentClass:String = null):Class = {
    new Class(name, parentClass)
  }

  def Method(name:String):Method = {
    new Method(name)
  }

  def access(symbol:Symbol):Symbol = {return null}

  def dependOn(symbol:Symbol):Symbol = {return null}
  def dependOn(symbol:ArrayEntity):Symbol = {return null}

  def only(t:Symbol):Symbol = {return null}
  def only() = {}
}