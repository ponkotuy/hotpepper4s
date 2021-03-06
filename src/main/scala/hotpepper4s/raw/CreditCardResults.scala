package hotpepper4s.raw

import hotpepper4s.{CodeName, Results}

/**
 * @author ponkotuy
 * Date: 2014/01/04
 */
case class CreditCardResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    private val credit_card: List[CreditCard]) extends Results[CreditCard] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[CreditCard] = credit_card
  def creditCard: List[CreditCard] = credit_card
}

case class CreditCard(code: String, name: String) extends CodeName
