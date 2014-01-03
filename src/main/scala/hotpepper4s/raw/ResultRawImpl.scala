package hotpepper4s.raw

import hotpepper4s.{Shop, Results}

/**
 * @author ponkotuy
 */
case class ResultRawImpl(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    shop: List[ShopLiteRaw]) extends Results[Shop] {
  def data: List[Shop] = shop
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
}
