
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play._
import play.api.mvc.Results
import play.api.test.Helpers._

class ServerSpec extends PlaySpec
  with OneServerPerSuiteWithMyComponents
  with Results
  with ScalaFutures {

  import org.scalatest.time.{Millis, Seconds, Span}

  implicit val defaultPatience =
    PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  "Server query should" should {

    "work" in {
      implicit val ec = app.materializer.executionContext
      val wsClient = components.wsClient

      whenReady(wsUrl("/")(portNumber, wsClient).get) { response =>
        response.status mustBe OK
      }
    }

  }

}
