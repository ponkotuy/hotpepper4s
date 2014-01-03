package hotpepper4s

import com.typesafe.config.ConfigFactory
import hotpepper4s.search._
import scala.util.Try
import hotpepper4s.raw._
import hotpepper4s.Budget.LimitedBudget
import scala.util.Success
import hotpepper4s.raw.ResultRawImpl
import scala.util.Failure
import hotpepper4s.raw.ShopSearchResult
import hotpepper4s.Genre.GenreCodeName

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
  lazy val gourmetSearch = new CommonSearch[Shop, ResultRawImpl]("gourmet")
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
  lazy val shopSearch = new CommonSearch[SearchedShop, ShopSearchResult]("shop")
  /**
   * @param tel : Number String(checking if '-' contains)
   * @return : ShopLite
   */
  def shopSearchByTel(tel: String): SearchedShop = shopSearch.one(Map("tel" -> tel))
  def shopSearch(qMap: Map[String, String], start: Int, count: Int): List[SearchedShop] =
    shopSearch.list(qMap ++ Map("start" -> start.toString, "count" -> count.toString))
  def shopSearchByKeyword(keyword: String, start: Int = 1, count: Int = 100): List[SearchedShop] =
    shopSearch(Map("keyword" -> keyword), start, count)

  // Budget Master
  lazy val budgets: List[LimitedBudget] =
    new CommonSearch[LimitedBudget, BudgetResults]("budget").list()

  // Large Service Area Master
  lazy val largeServiceAreas: List[BaseArea] =
    new CommonSearch[BaseArea, LargeServiceAreaResults]("large_service_area").list()

  // Service Area Master
  lazy val serviceAreas: List[ServiceArea] =
    new CommonSearch[ServiceArea, ServiceAreaResults]("service_area").list()

  // Large Area Master
  lazy val largeArea = new CommonSearch[LargeArea, LargeAreaResults]("large_area")
  def largeArea(qMap: Map[String, String]): List[LargeArea] = largeArea.list(qMap)
  def largeAreas(): List[LargeArea] = largeArea.list()
  def largeAreaByCode(code: String): LargeArea = largeArea.one(Map("large_area" -> code))
  def largeAreaByKeyword(keyword: String): List[LargeArea] = largeArea(Map("keyword" -> keyword))

  // Middle Area Master
  lazy val middleArea = new CommonSearch[MiddleArea, MiddleAreaResults]("middle_area")
  def middleArea(qMap: Map[String, String]): List[MiddleArea] = middleArea.list(qMap)
  def middleAreaByCode(code: String): MiddleArea = middleArea.one(Map("middle_area" -> code))
  def middleAreaByLargeArea(area: Area): List[MiddleArea] = middleAreaByLargeArea(area.code)
  def middleAreaByLargeArea(area: String): List[MiddleArea] = middleArea(Map("large_area" -> area))
  def middleAreaByKeyword(keyword: String): List[MiddleArea] = middleArea(Map("keyword" -> keyword))

  // Small Area Master
  lazy val smallArea = new CommonSearch[SmallArea, SmallAreaResults]("small_area")
  def smallArea(qMap: Map[String, String]): List[SmallArea] = smallArea.list(qMap)
  def smallAreaByCode(code: String): SmallArea = smallArea.one(Map("small_area" -> code))
  def smallAreaByMiddleArea(area: Area): List[SmallArea] = smallAreaByMiddleArea(area.code)
  def smallAreaByMiddleArea(area: String): List[SmallArea] = smallArea(Map("middle_area" -> area))
  def smallAreaByKeyword(keyword: String): List[SmallArea] = smallArea(Map("keyword" -> keyword))

  // Genre Master
  lazy val genres: List[GenreCodeName] =
    new CommonSearch[GenreCodeName, GenreResults]("genre").list()

  // Food Category Master
  lazy val foodCategories: List[FoodCategory] =
    new CommonSearch[FoodCategory, FoodCategoryResults]("food_category").list()

  // Food Master
  lazy val foods: List[FoodFull] =
    new CommonSearch[FoodFull, FoodResults]("food").list()

  // Credit Card Master
  lazy val creditCards: List[CreditCard] =
    new CommonSearch[CreditCard, CreditCardResults]("credit_card").list()
}
