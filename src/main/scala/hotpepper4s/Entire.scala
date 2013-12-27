package hotpepper4s

/**
 * @author ponkotuy
 */
trait Entire[A <: Results[_]] {
  def results: A
}

case class EntireImpl[A <: Results[_]](results: A) extends Entire[A]
