package hotpepper4s.search

import org.json4s.DefaultFormats
import hotpepper4s.SearchedShop
import hotpepper4s.raw.ShopSearchEntire

/**
 * @author ponkotuy
 */
object ShopSearch {
  import Common._

  implicit val formats = DefaultFormats
  lazy val ShopURL = createBaseURL("shop")

  def one(tel: String): SearchedShop = {
    val num = tel.filterNot(_ == '-')
    require(num.forall(_.isDigit))
    val url = createQueryURL(ShopURL, Map("tel" -> num))
    val json = getJSON(url)
    json.extract[ShopSearchEntire].results.data.head
  }

  def shops(qMap: Map[String, String]): List[SearchedShop] = {
    val url = createQueryURL(ShopURL, qMap)
    val json = getJSON(url)
    json.extract[ShopSearchEntire].results.data
  }
}
