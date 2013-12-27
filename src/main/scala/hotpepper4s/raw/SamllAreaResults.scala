package hotpepper4s.raw

import hotpepper4s.{Area, BaseArea, Entire, Results}

/**
 * @author ponkotuy
 * date: 13/12/27
 */
case class SmallAreaResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    small_area: List[SmallArea]) extends Results[SmallArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[SmallArea] = small_area
  def smallArea = small_area
}

case class SmallAreaEntire(results: SmallAreaResults) extends Entire[SmallAreaResults]

case class SmallArea(
    code: String,
    name: String,
    middle_area: BaseArea,
    large_area: BaseArea,
    service_area: BaseArea,
    large_service_area: BaseArea) extends Area {
  def middleArea = middle_area
  def largeArea = large_area
  def serviceArea = service_area
  def largeServiceArea = large_service_area
}
