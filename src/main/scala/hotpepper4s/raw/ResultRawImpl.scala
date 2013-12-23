package hotpepper4s.raw

/**
 * @author ponkotuy
 */
case class ResultRawImpl(
    api_version: String,
    results_available: Int,
    results_returned: String,
    results_start: Int,
    shop: List[ShopLiteRaw])

case class Entire(results: ResultRawImpl)
