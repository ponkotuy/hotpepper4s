package hotpepper4s.raw

import hotpepper4s.{CodeName, Results}

/**
 * @author ponkotuy
 * Date: 2014/01/04
 */
case class CreditCardResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    credit_card: List[CreditCard]) extends Results[CreditCard] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[CreditCard] = credit_card
  def creditCard: List[CreditCard] = credit_card
}

case class CreditCard(code: String, name: String) extends CodeName
