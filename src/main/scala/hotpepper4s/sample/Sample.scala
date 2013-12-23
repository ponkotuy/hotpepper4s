package hotpepper4s.sample

import hotpepper4s.{Type, HotPepper}

/**
 * @author ponkotuy
 */
object Sample extends App {
  println("---- ID検索 ----")
  println(HotPepper.gourmetSearchById("J001040295", Type.LITE))
  println("---- Name検索 ----")
  HotPepper.gourmetSearchByName("花の舞", Type.LITE, count = 3).foreach(shop => println(shop.name))
  // 1始まりなのでstart=3だと前のと被る
  HotPepper.gourmetSearchByName("花の舞", Type.LITE, count = 3, start = 3).foreach(shop => println(shop.name))
  println("---- TEL検索 ----")
  println(HotPepper.shopSearchByTel("0332083008"))
  println("---- Keyword検索 ----")
  HotPepper.shopSearchByKeyword("花の舞 東京", count = 10).foreach(shop => println(shop.name -> shop.address))
}
