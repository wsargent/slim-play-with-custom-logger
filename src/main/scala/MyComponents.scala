import play.api._
import play.api.i18n._
import play.api.inject._

import play.api.libs.ws.ahc.AhcWSComponents

import play.api.mvc.Results._
import play.api.mvc._

import play.api.routing.Router
import play.api.routing.sird._

import play.api.libs.concurrent.Execution.Implicits._

import scala.concurrent.Future

/**
 *
 */
class MyComponents(context: ApplicationLoader.Context)
  extends BuiltInComponentsFromContext(context)
    with I18nComponents
    with AhcWSComponents {

  override lazy val injector =  {
    new SimpleInjector(NewInstanceInjector) +
      router +
      cookieSigner +
      csrfTokenSigner +
      httpConfiguration +
      tempFileCreator +
      global +
      wsApi +
      messagesApi
  }

  /**
   * Simple & fairly self-explanatory router
   */
  val router = Router.from {

    case GET(p"/") => Action {
      Ok("This is the index page.  Try /hello/world for dynamic content")
    }

    // Essentially copied verbatim from the SIRD example
    case GET(p"/hello/$to") => Action {
      Ok(s"Hello $to")
    }

    /*
     Use Action.async to return a Future result (sqrt can be intense :P)
     Note the use of double(num) to bind only numbers (built-in :)
      */
    case GET(p"/sqrt/${double(num)}") => Action.async {
      Future {
        Ok(Math.sqrt(num).toString)
      }
    }

  }
}