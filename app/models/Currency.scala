
package models

import play.api.libs.json._

sealed trait Currency

case object Euro extends Currency
case object USDollar extends Currency
case object GBPound extends Currency

object Currency {
  private object Keys {
    val euro = "eur"
    val usd = "usd"
    val gbp = "gbp"
  }

  implicit val reads: Reads[Currency] = Reads[Currency] {
    case JsString(Keys.euro) => JsSuccess(Euro)
    case JsString(Keys.usd) => JsSuccess(USDollar)
    case JsString(Keys.gbp) => JsSuccess(GBPound)
  }

  implicit val writes: Writes[Currency] = Writes[Currency] {
    case Euro => JsString(Keys.euro)
    case USDollar => JsString(Keys.usd)
    case GBPound => JsString(Keys.gbp)
  }

}