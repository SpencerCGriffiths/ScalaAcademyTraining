package Week3.Fri


import Week3.Thur.Either.{NewError, isOdd}
import scala.concurrent
import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.{Failure, Success}

object Futures extends App{

  def addition (x:Int, y:Int): Int = {
    Thread.sleep(1000) //long computation
    x + y
  }

  def additionInTheFuture: Future[Int] = Future {
    addition(1,2)
  }

  val waitTime: FiniteDuration = Duration(5, TimeUnit.SECONDS)
  // FiniteDuration is a class that represents an amount of time
  // Duration is a standard object in scala and this makes a 5 second object

  println(additionInTheFuture) //Future(<not completed>)
  // Future cannot be completed as we are not awaiting it

  println(Await.result(additionInTheFuture, waitTime))
  // Here we are waiting until either the function completes or the waitTime elapses
  // i.e. either give me the outcome of the future or throw a Timeout exception
  // Await.result(future, timeout)

  println(Await.ready(additionInTheFuture, waitTime))
  // Await ready returns the future itself not just the result

// -------------------------------------------------------------------------------
/** --> Task */
// Yesterday we made an isOdd method and a class called NewError
// Make a method called fetchIsOddOrError
// This method will take in an Int and return a Future[Either[NewError, String]] It will run the isOdd method, in the future
// Make a def which calls fetchIsOddOrError
// Prove this works by writing a short test spec


def fetchIsOddOrError(num:Int): Future[Either[String, String]] =
  Future {
    Thread.sleep(1000)
    isOdd(num)
  }

  println(Await.ready(fetchIsOddOrError(5), waitTime))
  println(Await.ready(fetchIsOddOrError(4), waitTime))

  def eventualIsOddOrError(x:Int): Future[Either[String, String]] =
    fetchIsOddOrError(x)

  println(Await.ready(eventualIsOddOrError(5), waitTime))
  println(Await.ready(eventualIsOddOrError(4), waitTime))

}
