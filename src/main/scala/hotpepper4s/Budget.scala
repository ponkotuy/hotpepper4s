package hotpepper4s

/**
 * @author ponkotuy
 */
case class Budget(code: String, name: String, average: String) {
  def codeName: CodeName = CodeName(code, name)
}
