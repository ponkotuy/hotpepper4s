package hotpepper4s.raw

import hotpepper4s.{CodeName, Results}

/**
 * @author ponkotuy
 * Date: 2014/01/04
 */
case class SpecialResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val special: List[Special]) extends Results[Special] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[Special] = special
}

case class Special(code: String, name: String, special_category: SpecialCategory) extends CodeName
