package hotpepper4s

/**
 * @author ponkotuy
 */
trait Shop extends ShopLite {
  def logoImage: String
  def nameKana: String
  def stationName: String
  def ktaiCoupon: Boolean
  def largeServiceArea: Area
  def serviceArea: Area
  def largeArea: Area
  def middleArea: Area
  def smallArea: Area
  def subGenre: SubGenre
  def food: Food
  def subFood: Food
  def budget: Budget
  def budgetMemo: String
  def capacity: Int
  def mobileAccess: String
  def photoMobile: Photo
  def open: String
  def close: String
  def partyCapacity: Int

  /**
   * @return exist: Some(True), not exist: Some(False), don't know: None
   */
  def wifi: Some[Boolean]

  def wedding: String
  def course: Boolean
  def freeDrink: Boolean
  def freeFood: Boolean
  def privateRoom: Boolean
  def horigotatsu: Boolean
  def tatami: Boolean
  def card: Boolean
  def nonSmoking: String
  def charter: String
  def ktai: String
  def parking: String
  def barrierFree: Boolean
  def otherMemo: String
  def sommelier: Boolean
  def openAir: Boolean
  def show: Boolean
  def equipment: Boolean
  def karaoke: Boolean
  def band: Boolean
  def tv: String
  def english: Boolean
  def pet: String
  def child: String
  def lunch: Boolean
  def midnight: Boolean
  def shopDetailMemo: String
  def couponUrls: Urls
}
