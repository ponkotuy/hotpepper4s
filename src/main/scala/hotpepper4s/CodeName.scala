package hotpepper4s

/**
 * @author ponkotuy
 */
trait CodeName {
  import CodeName._
  def code: String
  def name: String
  def toCodeName: CodeNameImpl = CodeNameImpl(code, name)
  def toTuple: (String, String) = code -> name
}

object CodeName {
  def apply(code: String, name :String): CodeName = CodeNameImpl(code, name)
  case class CodeNameImpl(code: String, name: String) extends CodeName
}
