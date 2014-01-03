package hotpepper4s.sample

import hotpepper4s.HotPepper

/**
 * @author ponkotuy
 */
object GetMasterSample extends App {
  println(HotPepper.budgets)
  println(HotPepper.largeServiceAreas)
  println(HotPepper.serviceAreas)
  println(HotPepper.largeAreas())
  println(HotPepper.largeAreaByKeyword("神奈川"))
  println(HotPepper.middleAreaByLargeArea("Z011"))
  println(HotPepper.smallAreaByMiddleArea("Y005"))
  println(HotPepper.genres)
  println(HotPepper.foodCategories)
  println(HotPepper.foods)
}
