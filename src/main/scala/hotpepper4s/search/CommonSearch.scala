package hotpepper4s.search

import hotpepper4s.{Entire, Results, HotPepper}
import org.json4s._
import org.json4s.native.JsonMethods._
import java.net.URL

/**
 * @author ponkotuy
 * @tparam A Return Type
 * @tparam B Raw Results Type
 * @tparam C Raw Entire JSON Type
 * @param apiName A part of API's URL
 */
class CommonSearch[A, B <: Results[A], C <: Entire[B]](apiName: String)(implicit mf: scala.reflect.Manifest[C]) {
  implicit val defaultsFormat = DefaultFormats
  val BaseURL = createBaseURL(apiName)

  private def createBaseURL(last: String): String =
    HotPepper.BaseURL + last + "/" + HotPepper.Version + "/?key=" + HotPepper.key + "&format=json"

  private def createQueryURL(base: String, q: Map[String, String]): String =
    base + q.flatMap { case (key, value) =>
      if(value == "") Seq() else Seq("&", key, "=", value)
    }.mkString

  private def getJSON(url: String): JValue = {
    println(s"Get json from $url.")
    parse(new URL(url).openStream())
  }

  def one(qMap: Map[String, String]): A = list(qMap).head

  def list(qMap: Map[String, String]): List[A] = {
    val url = createQueryURL(BaseURL, qMap)
    val json = getJSON(url)
    json.extract[C].results.data
  }

  def list(): List[A] = list(Map())
}
