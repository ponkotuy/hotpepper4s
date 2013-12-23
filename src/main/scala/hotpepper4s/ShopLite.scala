package hotpepper4s

/**
 * @author ponkotuy
 */
trait ShopLite extends ShopBase {
  def latitude: Double
  def longitude: Double
  def cat: String
  def access: String
  def photoPc: Photo
}
