import org.scalatest._
import org.scalatestplus.play._
import play.api.ApplicationLoader.Context
import play.api.test._
import play.api.test.Helpers._
import play.api._

/**
 */
class ApplicationSpec extends PlaySpec with OneAppPerTestWithMyComponents {

  "Routes" should {

    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

  }

  "Router" should {

    "render hello world" in {
      val response = route(app, FakeRequest(GET, "/hello/world")).get

      status(response) mustBe OK
      contentType(response) mustBe Some("text/plain")
      contentAsString(response) must include("Hello world")
    }

  }
}