package hotpepper4s.raw

import hotpepper4s.Budget.LimitedBudget

/**
 * @author ponkotuy
 */
case class BudgetResults(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    budget: List[LimitedBudget])

case class BudgetEntire(results: BudgetResults)
