package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  // Goal:
  // We want to be able to check when the price of an overseas item will be cheaper for us to buy
  // based on the exchange rate

  // We have an API https://github.com/fawazahmed0/currency-api#readme for the exchange rates

  // Acceptance criteria:
  // - be able to store an item with its price + currency
  // - view a list of stored items and their current prices
  // - change price
  // - delete item

  // Stretch goals:
  // - price history for comparison

  /* Tools
  Controllers
  - handle user requests
  - call into services that do data processing
  - return responses to user

  Services
  - Do data processing
  - Typically connected to DB or other data source
  - Accept parameters and return a known set of possible responses

  Connectors
  - Connects to an external data source
  - Parses JSON into a known data model
   */

  // API -> Connector -> Service -> Controller
  // DB -> Service -> Controller
  // Utilities
  // - General purpose
  // - Not connected to a data source
  // - typically contain 'pure functions', i.e. functions that for a given set of parameters always return the same response
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

}
