package hotpepper4s

/**
 * @author ponkotuy
 */
trait Food extends CodeName

object Food {
  case class FoodNormal(code: String, name: String) extends Food {
    def codeName: CodeName = CodeName(code, name)
  }
}
