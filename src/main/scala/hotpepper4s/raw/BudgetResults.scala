package hotpepper4s.raw

import hotpepper4s.Budget.LimitedBudget
import hotpepper4s.Results

/**
 * @author ponkotuy
 */
case class BudgetResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    budget: List[LimitedBudget]) extends Results[LimitedBudget]{
  def data: List[LimitedBudget] = budget
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
}

case class BudgetEntire(results: BudgetResults)
