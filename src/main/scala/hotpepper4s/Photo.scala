package hotpepper4s

/**
 * @author ponkotuy
 */
trait Photo {
  def l: String
  def m: String
  def s: String
}

object Photo {
  case class PhotoPC(l: String, m: String, s:String) extends Photo
  case class PhotoMobile(l:String, s:String) extends Photo {
    def m: String = throw new NotImplementedError("PhotoMobile does not exist M size photo.")
  }
}
