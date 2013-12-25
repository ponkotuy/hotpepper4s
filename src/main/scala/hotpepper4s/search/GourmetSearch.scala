package hotpepper4s.search

import hotpepper4s.{Shop, Type}
import hotpepper4s.raw.Entire
import org.json4s._

/**
 * @author ponkotuy
 */
object GourmetSearch {
  import Common._

  implicit val formats = DefaultFormats
  lazy val GourmetURL = createBaseURL("gourmet")

  def one(id: String, typ: Type): Shop = {
    val url = createQueryURL(GourmetURL, Map("id" -> id, "type" -> typ.str))
    val json = getJSON(url)
    json.extract[Entire].results.data.head
  }

  def shops(qMap: Map[String, String]): List[Shop] = {
    val url = createQueryURL(GourmetURL, qMap)
    val json = getJSON(url)
    json.extract[Entire].results.data
  }
}
