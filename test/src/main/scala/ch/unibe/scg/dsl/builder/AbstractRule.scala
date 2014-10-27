package ch.unibe.scg.dsl.builder

/**
 * Created by leo on 27.10.14.
 */
trait AbstractRule {
  def can(rules:Rule*):Unit
  def cannot(rules:Rule*):Unit
  def must(rules:Rule*):Unit
}
