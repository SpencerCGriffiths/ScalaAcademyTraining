package Week3.Fri

import Week3.Fri.FutureAfternoonTask.eventualLetter
import Week3.Thur.Afternoon.Extension.Extensions._
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object EitherAndFuture extends App{
  implicit val ec: ExecutionContext = ExecutionContext.global // not best to use in test, find out why later

   def fetchLetterOrError(name: String, postCode: String): Future[Either[GenericPostageError, Letter]] =
     Future  {
     Letter.letterOrError(maybeName = name, maybePostCode = postCode)
   }

  val eventualLetterOrError: Future[Either[GenericPostageError, Letter]] = fetchLetterOrError("john", "SE1 9PQ")

  /** ---> 8. Printing the Values you can see left and right */
  val letter: Either[GenericPostageError, Letter] = Right(Letter.apply(Name.apply("John"), Postcode.apply("SE19PQ")))
  val invalidLetter: Either[GenericPostageError, Letter] = Left(InvalidNameError.apply("Name cannot be empty"))
  val letterWithANumberInName: Either[GenericPostageError, Letter] = Letter.letterOrError("John123", "SE19PQ")
  val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] = Letter.letterOrError("John", "SE19PQ1") // Invalid due to missing space
  val letterAllInvalid: Either[GenericPostageError, Letter] = Letter.letterOrError("John123", "SE19PQ1") // Invalid name and postcode


  println("--> Testing letterOrError method")
  println(letter)
  println(invalidLetter)
  println(letterWithANumberInName) // Should print: Left(InvalidNameError(Name cannot contain numbers))
  println(letterWithAnInvalidPostcode) // Should print: Left(InvalidPostcodeError(Invalid postcode format))
  println(letterAllInvalid) // Should print: Left(InvalidNameError(Name cannot contain numbers))


  eventualLetterOrError.value match {
    case Some(Success(foundLetter)) =>
      println(s"Letter found! $foundLetter")
    case Some(Failure(exception)) =>
      println(s"Blah Blah $exception")
    case None =>
      println("Future did not complete in the given time")
  }

  Await.ready(eventualLetterOrError, 2.seconds)
}

