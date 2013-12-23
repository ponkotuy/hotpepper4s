package hotpepper4s

/**
 * @author ponkotuy
 */
case class SubGenre(code: String, name: String) {
  def codeName: CodeName = CodeName(code, name)
}
