package hotpepper4s.search

import hotpepper4s.HotPepper
import org.json4s._
import org.json4s.native.JsonMethods._
import java.net.URL

/**
 * @author ponkotuy
 */
object Common {
  def createBaseURL(last: String): String =
    HotPepper.BaseURL + last + "/" + HotPepper.Version + "/?key=" + HotPepper.key + "&format=json"

  def createQueryURL(base: String, q: Map[String, String]): String =
    base + q.flatMap { case (key, value) =>
      if(value == "") Seq() else Seq("&", key, "=", value)
    }.mkString

  def getJSON(url: String): JValue = {
    println(s"Get json from $url.")
    parse(new URL(url).openStream())
  }
}
