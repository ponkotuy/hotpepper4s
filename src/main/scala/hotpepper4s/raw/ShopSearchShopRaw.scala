package hotpepper4s.raw

import hotpepper4s.{SearchedShop, Genre, Urls}
import hotpepper4s.Urls.NormalUrls

/**
 * @author ponkotuy
 */
case class ShopSearchShop(
    id: String,
    name: String,
    name_kana: String,
    address: String,
    genre: Genre,
    urls: Urls,
    desc: Boolean) extends SearchedShop

case class ShopSearchShopRaw(
    id: String,
    name: String,
    name_kana: String,
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
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: String,
    shop: List[ShopSearchShopRaw])

case class ShopSearchEntire(results: ShopSearchResult)