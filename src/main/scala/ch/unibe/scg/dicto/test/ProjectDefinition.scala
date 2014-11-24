package ch.unibe.scg.dicto.test

/**
 * Created by leo on 24.11.14.
 */
object ProjectDefinition {
  var suiteId :String = _
  var projectRoot :String = _

  def setProjectRoot(_projectRoot: String) = {
    projectRoot = _projectRoot
  }

  def setSuiteId(_suiteId: String) = {
    suiteId = _suiteId
  }
}
