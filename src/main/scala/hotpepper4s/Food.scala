package hotpepper4s

/**
 * @author ponkotuy
 */
case class Food(code: String, name: String) {
  def codeName: CodeName = CodeName(code, name)
}