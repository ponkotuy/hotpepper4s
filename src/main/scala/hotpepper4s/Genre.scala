package hotpepper4s

/**
 * @author ponkotuy
 */
trait Genre {
  def code: String
  def name: String
  def cat: String
}

object Genre {
  case class GenreFull(code: String, name: String, `catch`: String) extends Genre{
    def cat: String = `catch`
  }

  case class GenreLite(name: String, `catch`: String) extends Genre{
    def code: String = throw new NotImplementedError
    def cat: String = `catch`
  }
}