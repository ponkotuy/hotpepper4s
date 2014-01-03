package hotpepper4s.raw

import hotpepper4s.{Food, Results}

/**
 * @author ponkotuy
 * Date: 2014/01/04
 */
case class FoodResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    food: List[FoodFull]) extends Results[FoodFull] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[FoodFull] = food
}

case class FoodFull(code: String, name: String, food_category: FoodCategory) extends Food {
  def foodCategory = food_category
}