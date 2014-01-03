package hotpepper4s.raw

import hotpepper4s.{Area, BaseArea, Entire, Results}

/**
 * @author ponkotuy
 * date: 13/12/27
 */
case class SmallAreaResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val small_area: List[SmallArea]) extends Results[SmallArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[SmallArea] = small_area
  def smallArea = small_area
}

case class SmallArea(
    code: String,
    name: String,
    private val middle_area: BaseArea,
    private val large_area: BaseArea,
    private val service_area: BaseArea,
    private val large_service_area: BaseArea) extends Area {
  def middleArea = middle_area
  def largeArea = large_area
  def serviceArea = service_area
  def largeServiceArea = large_service_area
}
