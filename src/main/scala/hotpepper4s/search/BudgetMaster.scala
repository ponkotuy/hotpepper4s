package hotpepper4s.search

import hotpepper4s.Budget.LimitedBudget
import hotpepper4s.raw.BudgetEntire
import org.json4s.DefaultFormats

/**
 * @author ponkotuy
 */
object BudgetMaster {
  import Common._

  implicit val formats = DefaultFormats
  lazy val BudgetURL = createBaseURL("budget")

  def budgets(): List[LimitedBudget] = {
    val url = createQueryURL(BudgetURL, Map())
    val json = getJSON(url)
    json.extract[BudgetEntire].results.data
  }
}
