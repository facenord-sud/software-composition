package ch.unibe.scg.dicto.builder

/**
 * Created by leo on 24.11.14.
 */
object Rules {

  var code: String = ""

  def save = {
    code += "\n\n" + Assignments.text() + "\n" + RulesDefinition.text()
    Assignments.clear()
    RulesDefinition.clear()
  }
}
