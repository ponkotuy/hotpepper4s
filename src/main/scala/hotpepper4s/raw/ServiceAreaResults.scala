package hotpepper4s.raw

import hotpepper4s.{BaseArea, Entire, Results, Area}

/**
 * @author ponkotuy
 */
case class ServiceAreaResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    service_area: List[ServiceArea]) extends Results[ServiceArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[ServiceArea] = service_area
  def serviceArea = service_area
}

case class ServiceAreaEntire(results: ServiceAreaResults) extends Entire[ServiceAreaResults]

case class ServiceArea(code: String, name: String, large_service_area: BaseArea) extends Area {
  def largeServiceArea: BaseArea = large_service_area
}