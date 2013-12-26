package hotpepper4s.raw

import hotpepper4s.{Entire, Area, BaseArea, Results}

/**
 * @author ponkotuy
 * date: 13/12/27
 */
case class MiddleAreaResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    middle_area: List[MiddleArea]) extends Results[MiddleArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[MiddleArea] = middle_area
}

case class MiddleAreaEntire(results: MiddleAreaResults) extends Entire[MiddleAreaResults]

case class MiddleArea(
    code: String,
    name: String,
    large_area: BaseArea,
    service_area: BaseArea,
    large_service_area: BaseArea) extends Area {
  def largeArea = large_area
  def serviceArea = service_area
  def largeServiceArea = large_service_area
}
