package ch.unibe.scg.dsl.definition

import ch.unibe.scg.dsl.entities.{ArrayEntity, Method, Class, Package}
import ch.unibe.scg.dsl.modifiers.Modifier
import ch.unibe.scg.dsl.rules.Rule
import ch.unibe.scg.dsl.statements.Statement
import ch.unibe.scg.dsl.wrapper.SymbolWrapper

object DSL {
  implicit def symbolWrapper(symbol :Symbol) = { new SymbolWrapper(symbol) }

  def Package(name:String):Package = {
    new Package(name)
  }

  def Klass(name:String = null, parentClass:String = null):Class = {
    new Class(name, parentClass)
  }

  def Method(name:String):Method = {
    new Method(name)
  }

  def access(symbol:Symbol):Statement = {return null}

  def dependOn(symbol:Symbol):Statement = {return null}
  def dependOn(symbol:ArrayEntity):Statement = {return null}

  def only(rule: Rule):Modifier = {return null}
  def only():Modifier = {return null}
}