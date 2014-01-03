package hotpepper4s.raw

import hotpepper4s.{CodeName, Results}

/**
 * @author ponkotuy
 * Date: 2014/01/04
 */
case class SpecialCategoryResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    special_category: List[SpecialCategory]) extends Results[SpecialCategory] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[SpecialCategory] = special_category
  def specialCategory = special_category
}

case class SpecialCategory(code: String, name: String) extends CodeName
