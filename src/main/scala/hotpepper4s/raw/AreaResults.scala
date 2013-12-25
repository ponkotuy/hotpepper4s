package hotpepper4s.raw

import hotpepper4s.{Results, Area}

/**
 * @author ponkotuy
 * date: 13/12/26
 */
case class AreaResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    large_service_area: List[Area]) extends Results[Area]{
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[Area] = large_service_area
}

case class AreaResultsEntire(results: AreaResults)