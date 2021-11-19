package models

import org.scalatestplus.play.PlaySpec
import play.api.libs.json.{JsString, JsSuccess, Json}

class CurrencySpec extends PlaySpec {

  "reads" should {
    "parse 'eur' to Euro" in {
      Currency.reads.reads(JsString("eur")) mustBe JsSuccess(Euro)
    }
    "parse 'usd' to USDollar" in {
      Currency.reads.reads(JsString("usd")) mustBe JsSuccess(USDollar)
    }
    "parse 'gbp' to GBPound" in {
      Currency.reads.reads(JsString("gbp")) mustBe JsSuccess(GBPound)
    }
  }

  "reading from a key" should {
    "parse 'eur' to Euro" in {
      val json = Json.obj("currency" -> "eur")
      (json \ "currency").validate[Currency] mustBe JsSuccess(Euro)
    }
    "parse 'usd' to USDollar" in {
      val json = Json.obj("currency" -> "usd")
      (json \ "currency").validate[Currency] mustBe JsSuccess(USDollar)
    }
    "parse 'gbp' to GBPound" in {
      val json = Json.obj("currency" -> "gbp")
      (json \ "currency").validate[Currency] mustBe JsSuccess(GBPound)
    }
  }

}
