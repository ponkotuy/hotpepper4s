package hotpepper4s.raw

import hotpepper4s.{Area, BaseArea, Results}

/**
 * @author ponkotuy
 * date: 13/12/27
 */

case class LargeAreaResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val large_area: List[LargeArea]) extends Results[LargeArea] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[LargeArea] = large_area
  def largeArea = large_area
}

case class LargeArea(
    code: String,
    name: String,
    service_area: BaseArea,
    large_service_area: BaseArea) extends Area {
  def serviceArea = service_area
  def largeServiceArea = large_service_area
}