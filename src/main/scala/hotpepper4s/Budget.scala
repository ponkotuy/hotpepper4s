package hotpepper4s

/**
 * @author ponkotuy
 */
trait Budget {
  def code: String
  def name: String
  def average: String
  def codeName: CodeName = CodeName(code, name)
}

object Budget {
  case class NormalBudget(code: String, name: String, average: String) extends Budget
  case class LimitedBudget(code: String, name: String) extends Budget {
    def average: String = throw new NotImplementedError("LimitedBudget doesn't exists average.")
  }
}