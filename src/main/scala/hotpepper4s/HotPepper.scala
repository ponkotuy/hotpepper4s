package hotpepper4s

import com.typesafe.config.ConfigFactory
import hotpepper4s.search._
import scala.util.Try
import hotpepper4s.raw._
import hotpepper4s.Budget.LimitedBudget
import scala.util.Success
import hotpepper4s.raw.ShopSearchEntire
import hotpepper4s.raw.EntireImpl
import hotpepper4s.raw.ResultRawImpl
import scala.util.Failure
import hotpepper4s.raw.ShopSearchResult

/**
 * HotPepper API
 *
 * reference: http://webservice.recruit.co.jp/hotpepper/reference.html
 *
 * @author ponkotuy
 */
object HotPepper {
  val config = ConfigFactory.parseResources("hotpepper4s.conf")
  val key = {
    Try(config.getString("authentication.key")) match {
      case Success(str) => str
      case Failure(e) => "hotpepper4s.conf or authentication.key element doesn't exists."
    }
  }
  val BaseURL = "http://webservice.recruit.co.jp/hotpepper/"
  val Version = "v1"

  // GourmetSearch
  lazy val gourmetSearch = new CommonSearch[Shop, ResultRawImpl, EntireImpl]("gourmet")
  def gourmetSearchById(id: String, typ: Type = Type.NORMAL): Shop =
    gourmetSearch.one(Map("id" -> id, "type" -> typ.str))
  def gourmetSearch(qMap: Map[String, String], typ: Type, start: Int, count: Int): List[Shop] =
    gourmetSearch.list(qMap ++ Map("type" -> typ.str, "start" -> start.toString, "count" -> count.toString))
  def gourmetSearchByName(name: String, typ: Type = Type.NORMAL, start: Int = 1, count: Int = 100): List[Shop] =
    gourmetSearch(Map("name" -> name), typ, start, count)
  def gourmetSearchByKana(kana: String, typ: Type = Type.NORMAL, start: Int = 1, count: Int = 100): List[Shop] =
    gourmetSearch(Map("name_kana" -> kana), typ, start, count)
  def gourmetSearchByNameAny(any: String, typ: Type = Type.NORMAL, start: Int = 1, count: Int = 100): List[Shop] =
    gourmetSearch(Map("name_any" -> any), typ, start, count)

  // ShopSearch
  lazy val shopSearch = new CommonSearch[SearchedShop, ShopSearchResult, ShopSearchEntire]("shop")
  /**
   * @param tel : Number String(checking if '-' contains)
   * @return : ShopLite
   */
  def shopSearchByTel(tel: String): SearchedShop = shopSearch.one(Map("tel" -> tel))
  def shopSearch(qMap: Map[String, String], start: Int, count: Int): List[SearchedShop] =
    shopSearch.list(qMap ++ Map("start" -> start.toString, "count" -> count.toString))
  def shopSearchByKeyword(keyword: String, start: Int = 1, count: Int = 100): List[SearchedShop] =
    shopSearch(Map("keyword" -> keyword), start, count)

  // GetMaster
  lazy val budgets: List[LimitedBudget] =
    new CommonSearch[LimitedBudget, BudgetResults, BudgetEntire]("budget").list()
  lazy val largeServiceAreas: List[Area] =
    new CommonSearch[Area, AreaResults, AreaResultsEntire]("large_service_area").list()
}
