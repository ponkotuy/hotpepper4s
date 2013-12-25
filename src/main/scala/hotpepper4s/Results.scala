package hotpepper4s

/**
 * @author ponkotuy
 * date: 13/12/26.
 */
trait Results[T] {
  def apiVersion: String
  def resultsAvailable: Int
  def resultsReturned: String
  def resultsStart: Int
  def data: List[T]
}
