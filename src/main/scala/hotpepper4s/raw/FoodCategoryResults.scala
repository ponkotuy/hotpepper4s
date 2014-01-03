package hotpepper4s.raw

import hotpepper4s.{CodeName, Results}

/**
 * Food Category
 *
 * @author ponkotuy
 * date: 2013/12/30
 */
case class FoodCategoryResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val food_category: List[FoodCategory]) extends Results[FoodCategory]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[FoodCategory] = food_category
  def foodCategory = food_category
}

case class FoodCategory(code: String, name: String) extends CodeName
