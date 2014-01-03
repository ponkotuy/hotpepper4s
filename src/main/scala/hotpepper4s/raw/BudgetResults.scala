package hotpepper4s.raw

import hotpepper4s.Budget.LimitedBudget
import hotpepper4s.Results

/**
 * @author ponkotuy
 */
case class BudgetResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    budget: List[LimitedBudget]) extends Results[LimitedBudget]{
  def data: List[LimitedBudget] = budget
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
}
