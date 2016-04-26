
import play.api._
import play.api.ApplicationLoader.Context

import play.api.inject._

import play.api.libs.ws.ahc.AhcWSComponents

import play.api.mvc.Results._
import play.api.mvc._

import play.api.routing.Router
import play.api.routing.sird._

import play.api.libs.concurrent.Execution.Implicits._

import scala.concurrent.Future

/**
 * Run Play components.
 */
class MyComponents(context: ApplicationLoader.Context)
  extends BuiltInComponentsFromContext(context)
    with AhcWSComponents {

  private val logger = org.slf4j.LoggerFactory.getLogger("application")

  override lazy val injector =  {
    new SimpleInjector(NewInstanceInjector) +
      router +
      global +
      httpConfiguration +
      wsApi
  }

  /**
   * Simple & fairly self-explanatory router
   */
  val router = Router.from {

    case GET(p"/") => Action {
      logger.error("Rendering index page")
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

    case GET(p"/play") => Action.async {
      wsClient.url("https://playframework.com").get().map { response =>
        val body = response.body
        Ok(body)
      }
    }

  }
}

class MyAppLoader extends ApplicationLoader {
  def load(context: Context) = new MyComponents(context).application
}