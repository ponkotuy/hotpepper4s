package hotpepper4s.raw

import hotpepper4s._
import hotpepper4s.Urls.NormalUrls
import hotpepper4s.Genre.GenreLite

/**
 * @author ponkotuy
 */
case class ShopLiteRaw(
      id: String,
      name: String,
      address: String,
      lat: String,
      lng: String,
      genre: GenreLite,
      `catch`: String,
      access: String,
      urls: NormalUrls,
      photo: PhotoRaw
    ) extends Shop {
  def cat: String = `catch`

  def photoPc: Photo = photo.pc

  lazy val latitude: Double = lat.toDouble
  lazy val longitude: Double = lng.toDouble

  def logoImage: String = throw new NotImplementedError()

  def nameKana: String = throw new NotImplementedError()

  def stationName: String = throw new NotImplementedError()

  def ktaiCoupon: Boolean = throw new NotImplementedError()

  def largeServiceArea: Area = throw new NotImplementedError()

  def serviceArea: Area = throw new NotImplementedError()

  def largeArea: Area = throw new NotImplementedError()

  def middleArea: Area = throw new NotImplementedError()

  def smallArea: Area = throw new NotImplementedError()

  def subGenre: SubGenre = throw new NotImplementedError()

  def food: Food = throw new NotImplementedError()

  def subFood: Food = throw new NotImplementedError()

  def budget: Budget = throw new NotImplementedError()

  def budgetMemo: String = throw new NotImplementedError()

  def capacity: Int = throw new NotImplementedError()

  def mobileAccess: String = throw new NotImplementedError()

  def photoMobile: Photo = throw new NotImplementedError()

  def open: String = throw new NotImplementedError()

  def close: String = throw new NotImplementedError()

  def partyCapacity: Int = throw new NotImplementedError()

  def wifi: Some[Boolean] = throw new NotImplementedError()

  def wedding: String = throw new NotImplementedError()

  def course: Boolean = throw new NotImplementedError()

  def freeDrink: Boolean = throw new NotImplementedError()

  def freeFood: Boolean = throw new NotImplementedError()

  def privateRoom: Boolean = throw new NotImplementedError()

  def horigotatsu: Boolean = throw new NotImplementedError()

  def tatami: Boolean = throw new NotImplementedError()

  def card: Boolean = throw new NotImplementedError()

  def nonSmoking: String = throw new NotImplementedError()

  def charter: String = throw new NotImplementedError()

  def ktai: String = throw new NotImplementedError()

  def parking: String = throw new NotImplementedError()

  def barrierFree: Boolean = throw new NotImplementedError()

  def otherMemo: String = throw new NotImplementedError()

  def sommelier: Boolean = throw new NotImplementedError()

  def openAir: Boolean = throw new NotImplementedError()

  def show: Boolean = throw new NotImplementedError()

  def equipment: Boolean = throw new NotImplementedError()

  def karaoke: Boolean = throw new NotImplementedError()

  def band: Boolean = throw new NotImplementedError()

  def tv: String = throw new NotImplementedError()

  def english: Boolean = throw new NotImplementedError()

  def pet: String = throw new NotImplementedError()

  def child: String = throw new NotImplementedError()

  def lunch: Boolean = throw new NotImplementedError()

  def midnight: Boolean = throw new NotImplementedError()

  def shopDetailMemo: String = throw new NotImplementedError()

  def couponUrls: Urls = throw new NotImplementedError()
}
