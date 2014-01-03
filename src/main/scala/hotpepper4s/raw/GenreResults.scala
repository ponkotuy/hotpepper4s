package hotpepper4s.raw

import hotpepper4s.Genre.GenreCodeName
import hotpepper4s.Results

/**
 * @author ponkotuy
 */
case class GenreResults(
    private val api_version: String,
    private val results_available: Int,
    private val results_returned: String,
    private val results_start: Int,
    genre: List[GenreCodeName]) extends Results[GenreCodeName] {
  def apiVersion: String = api_version
  def resultsAvailable: Int = results_available
  def resultsReturned: String = results_returned
  def resultsStart: Int = results_start
  def data: List[GenreCodeName] = genre
}
