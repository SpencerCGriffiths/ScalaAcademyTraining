package Week3_Fri
import Week3.Fri.Futures.{addition, additionInTheFuture, eventualIsOddOrError, fetchIsOddOrError}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration.{Duration, DurationInt, FiniteDuration}
import scala.util.{Failure, Success}

class FuturesSpec2  extends AnyWordSpec with Matchers with ScalaFutures{

  implicit val defaultPatience: PatienceConfig = PatienceConfig(timeout = Span(5, Seconds), interval = Span(5000, Millis))

  "addition method" should {
    "add two ints" in {
      addition(1,2) shouldEqual 3
    }
  }

  //Unit test the future
  "additionInTheFuture" should {
    "eventually return the current sum" in {
      whenReady(additionInTheFuture) {
        result => result shouldEqual 3
      }
    }
  }

  //EITHERS AND FUTURES

  "fetchIsOddOrError method" should {
    "return Right with a message when the number is odd" in {
      whenReady(fetchIsOddOrError(5)) { result =>
        result shouldEqual Right("5 is odd")
      }
    }
    "return Left with a BadRequest error when the number is even" in {
      whenReady(fetchIsOddOrError(4)) { result =>
        result shouldEqual Left("Bad Request in the is odd method")
      }
    }
  }

  "eventualIsOddOrError future" should {
    "return a right eventually, when given 5 as the Int" in {
      whenReady(eventualIsOddOrError(5)) { result =>
        result shouldEqual Right("5 is odd")
      }
    }
    "return a left eventually, when given 4 as the Int" in {
      whenReady(eventualIsOddOrError(4)) { result =>
        result shouldEqual Left("Bad Request in the is odd method")
      }
    }
  }
}

