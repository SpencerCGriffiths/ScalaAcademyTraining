package Week3.Fri

import Week3.Thur.Afternoon.Extension.Extensions.{GenericPostageError, Letter, Name, Postcode}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object FutureAfternoonTask extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global // not best to use in test, find out why later

  def fetchLetter(): Future[Letter] = Future {
//    val john: Name = Name("John")
//    val post: Postcode = Postcode("SE1 9PQ")
//    val letter: Letter = Letter(john, post)
//    letter

//    Thread.sleep(1000000000) // Timeout exception

    Letter(Name("John"), Postcode("SE1 9PQ"))
  }

  val eventualLetter: Future[Letter] = fetchLetter()

  println(Await.ready(eventualLetter, 2.seconds))

  eventualLetter.value match {
    case Some(Success(foundLetter)) =>
      println(s"Letter found! $foundLetter")
    case Some(Failure(exception)) =>
      println(s"Blah Blah $exception")
    case None =>
      println("Future did not complete in the given time")
  }

}
