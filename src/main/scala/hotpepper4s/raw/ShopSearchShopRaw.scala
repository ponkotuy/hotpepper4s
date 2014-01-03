package hotpepper4s.raw

import hotpepper4s._
import hotpepper4s.Urls.NormalUrls

/**
 * @author ponkotuy
 */
case class ShopSearchShop(
    id: String,
    name: String,
    private val name_kana: String,
    address: String,
    genre: Genre,
    urls: Urls,
    desc: Boolean) extends SearchedShop{
  def nameKana: String = name_kana
}

case class ShopSearchShopRaw(
    id: String,
    name: String,
    private val name_kana: String,
    address: String,
    genre: ShopSearchGenre,
    urls: NormalUrls,
    desc: String) {
  def toSearchedShop: SearchedShop = {
    ShopSearchShop(id, name, name_kana, address, genre, urls, desc == "1")
  }
}

case class ShopSearchGenre(name: String) extends Genre{
  def code: String = throw new NotImplementedError()
  def cat: String = throw new NotImplementedError()
}

case class ShopSearchResult(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: String,
    shop: List[ShopSearchShopRaw]) extends Results[SearchedShop]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  lazy val resultsStart: Int = results_start.toInt
  lazy val data: List[SearchedShop] = shop.map(_.toSearchedShop)
}
