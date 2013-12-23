package hotpepper4s

/**
 * @author ponkotuy
 */
trait Urls {
  def pc: String
  def mobile: String
  def qr: String
  def sp: String
}

object Urls {
  case class CouponUrls(pc: String, mobile: String, qr: String, sp: String) extends Urls
  case class NormalUrls(pc: String, mobile: String, qr: String) extends Urls {
    def sp: String = throw new NotImplementedError("NormalUrls does not exist sp URL.")
  }
}