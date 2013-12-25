package hotpepper4s.raw

import hotpepper4s.Results

/**
 * @author ponkotuy
 */
case class ResultRawImpl(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    shop: List[ShopLiteRaw]) extends Results[ShopLiteRaw] {
  def data: List[ShopLiteRaw] = shop
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
}

case class Entire(results: ResultRawImpl)
