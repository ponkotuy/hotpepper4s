package hotpepper4s

/**
 * @author ponkotuy
 */
trait Area {
  def code: String
  def name: String
  def codeName: CodeName = CodeName(code, name)
}

case class BaseArea(code: String, name: String) extends Area
