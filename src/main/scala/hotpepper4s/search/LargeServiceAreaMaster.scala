package hotpepper4s.search

import org.json4s.DefaultFormats
import hotpepper4s.Area
import hotpepper4s.raw.AreaResultsEntire

/**
 * @author ponkotuy
 * date: 13/12/26
 */
object LargeServiceAreaMaster {
  import Common._

  implicit val formats = DefaultFormats
  lazy val LargeAreaURL = createBaseURL("large_service_area")

  def areas(): List[Area] = {
    val url = createQueryURL(LargeAreaURL, Map())
    val json = getJSON(url)
    json.extract[AreaResultsEntire].results.data
  }
}
