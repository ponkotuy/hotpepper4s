package hotpepper4s

/**
 * @author ponkotuy
 */
trait CodeName {
  def code: String
  def name: String
}

object CodeName {
  def apply(code: String, name :String): CodeName = CodeNameImpl(code, name)
  case class CodeNameImpl(code: String, name: String) extends CodeName
}
