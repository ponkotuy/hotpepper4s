package hotpepper4s

/**
 * @author ponkotuy
 */
trait ShopBase {
  def id: String
  def name: String
  def address: String
  def genre: Genre
  def urls: Urls
}
