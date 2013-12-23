package hotpepper4s

import com.typesafe.config.ConfigFactory
import hotpepper4s.search.{ShopSearch, GourmetSearch}
import java.net.URLEncoder

/**
 * HotPepper API
 *
 * reference: http://webservice.recruit.co.jp/hotpepper/reference.html
 *
 * @author ponkotuy
 */
object HotPepper {
  val config = ConfigFactory.parseResources("hotpepper4s.conf")
  val key = config.getString("authentication.key")
  val BaseURL = "http://webservice.recruit.co.jp/hotpepper/"
  val Version = "v1"

  // GourmetSearch
  def gourmetSearchById(id: String, typ: Type = Type.NORMAL): Shop = GourmetSearch.one(id, typ)
  def gourmetSearch(qMap: Map[String, String], typ: Type, start: Int, count: Int): List[Shop] =
    GourmetSearch.shops(qMap ++ Map("type" -> typ.str, "start" -> start.toString, "count" -> count.toString))
  def gourmetSearchByName(name: String, typ: Type = Type.NORMAL, start: Int = 1, count: Int = 100): List[Shop] =
    gourmetSearch(Map("name" -> name), typ, start, count)
  def gourmetSearchByKana(kana: String, typ: Type = Type.NORMAL, start: Int = 1, count: Int = 100): List[Shop] =
    gourmetSearch(Map("name_kana" -> kana), typ, start, count)
  def gourmetSearchByNameAny(any: String, typ: Type = Type.NORMAL, start: Int = 1, count: Int = 100): List[Shop] =
    gourmetSearch(Map("name_any" -> any), typ, start, count)

  // ShopSearch
  /**
   * @param tel : Number String(checking if '-' contains)
   * @return : ShopLite
   */
  def shopSearchByTel(tel: String): SearchedShop = ShopSearch.one(tel)
  def shopSearch(qMap: Map[String, String], start: Int, count: Int): List[SearchedShop] =
    ShopSearch.shops(qMap ++ Map("start" -> start.toString, "count" -> count.toString))
  def shopSearchByKeyword(keyword: String, start: Int = 1, count: Int = 100): List[SearchedShop] =
    shopSearch(Map("keyword" -> keyword), start, count)
}
