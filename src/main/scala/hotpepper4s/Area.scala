package hotpepper4s

/**
 * @author ponkotuy
 */
case class Area(code: String, name: String) {
  def codeName: CodeName = CodeName(code, name)
}
