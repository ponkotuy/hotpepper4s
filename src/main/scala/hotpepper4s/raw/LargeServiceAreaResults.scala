package hotpepper4s.raw

import hotpepper4s.{BaseArea, Entire, Results}

/**
 * @author ponkotuy
 * date: 13/12/26
 */
case class LargeServiceAreaResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    large_service_area: List[BaseArea]) extends Results[BaseArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[BaseArea] = large_service_area
  def largeServiceArea = large_service_area
}

case class LargeServiceAreaEntire(results: LargeServiceAreaResults) extends Entire[LargeServiceAreaResults]