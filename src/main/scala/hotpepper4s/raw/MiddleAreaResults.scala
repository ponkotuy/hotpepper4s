package hotpepper4s.raw

import hotpepper4s.{CodeName, Area, BaseArea, Results}

/**
 * @author ponkotuy
 * date: 13/12/27
 */
case class MiddleAreaResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val middle_area: List[MiddleArea]) extends Results[MiddleArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[MiddleArea] = middle_area
  def middleArea = middle_area
}

case class MiddleArea(
    code: String,
    name: String,
    private val large_area: BaseArea,
    private val service_area: BaseArea,
    private val large_service_area: BaseArea) extends Area with CodeName {
  def largeArea = large_area
  def serviceArea = service_area
  def largeServiceArea = large_service_area
}
