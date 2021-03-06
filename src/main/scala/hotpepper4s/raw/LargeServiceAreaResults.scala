package hotpepper4s.raw

import hotpepper4s.{BaseArea, Results}

/**
 * @author ponkotuy
 * date: 13/12/26
 */
case class LargeServiceAreaResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val large_service_area: List[BaseArea]) extends Results[BaseArea]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[BaseArea] = large_service_area
  def largeServiceArea = large_service_area
}
