package ch.unibe.scg.dsl.definition

import ch.unibe.scg.dsl.builder.Assignments
import ch.unibe.scg.dsl.entities.{ArrayEntity, Method, Class, Package, Entity}
import ch.unibe.scg.dsl.modifiers.{Only, Modifier}
import ch.unibe.scg.dsl.rules.Rule
import ch.unibe.scg.dsl.statements.{DependOn, Access, Statement}
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

  def access(symbol:Symbol):Statement = {
    new Access(Assignments get symbol)
  }

  def dependOn(symbol:Symbol):Statement = {
    new DependOn(Assignments get symbol)
  }
  def dependOn(symbol:ArrayEntity):Statement = {
    new DependOn(symbol)
  }

  def only(rule: Rule):Unit = {
    rule.modifier = new Only(isFirst=true)
  }
}