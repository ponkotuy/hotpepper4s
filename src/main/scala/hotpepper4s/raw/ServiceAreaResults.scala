package hotpepper4s.raw

import hotpepper4s.{BaseArea, Results, Area}

/**
 * @author ponkotuy
 */
case class ServiceAreaResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val service_area: List[ServiceArea]) extends Results[ServiceArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[ServiceArea] = service_area
  def serviceArea = service_area
}

case class ServiceArea(code: String, name: String, large_service_area: BaseArea) extends Area {
  def largeServiceArea: BaseArea = large_service_area
}