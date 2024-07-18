package Week3.Thur.Afternoon.Extension

object Extensions extends App {
  case class Name(value: String)

  case class Postcode(value: String)

  case class Letter(name: Name, postcode: Postcode)

  trait GenericPostageError {
    def message: String
  }

  case class InvalidNameError(message: String) extends GenericPostageError

  case class InvalidPostcodeError(message: String) extends GenericPostageError


  val letter: Either[GenericPostageError, Letter] = Right(Letter.apply(Name.apply("John"), Postcode.apply("SE19PQ")))
  val invalidLetter: Either[GenericPostageError, Letter] = Left(InvalidNameError.apply("Name cannot be empty"))

  // You can use Nothing as you are not declaring the value on the other side of the either:

//  val letter: Right[Nothing, Letter] = Right(Letter.apply(Name.apply("John"), Postcode.apply("SE19PQ")))
//  val invalidLetter: Left[InvalidNameError, Nothing] = Left(InvalidNameError.apply("Name cannot be empty"))

  /** ---> 8. Printing the Values you can see left and right */
  println(letter)
  println(invalidLetter)
  println()


  // Companion Object Postcode
  object Postcode {
    def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
      val splitPostcode = maybePostCode.split("\\s").filter(elem => elem != "").toSeq
      val formattedPostCode = splitPostcode.mkString(" ")
      if (splitPostcode.length != 2) Left(InvalidPostcodeError("Invalid postcode format")) else Right(Postcode(formattedPostCode))
    }
  }


  //      method call splits the string input by one or more whitespace regex \\s+ matches any sequence of whitespace characters.


  // Companion Object Name
  object Name {
    def nameOrError(maybeName: String): Either[InvalidNameError, Name] = {
      val nameNoWhite: String = maybeName.trim
      if (nameNoWhite.matches(".*\\d.*")) {
        Left(InvalidNameError("Name cannot contain numbers"))
      } else {
        Right(Name(nameNoWhite))
      }
    }
  }

  object Letter {
    def letterOrError(maybeName: String, maybePostCode: String): Either[GenericPostageError ,Letter] = {
      for {
        name <- Name.nameOrError(maybeName)
        postCode <- Postcode.postcodeOrError(maybePostCode)
      } yield Letter(name, postCode)
    }
  }

  val letterWithANumberInName: Either[GenericPostageError, Letter] = Letter.letterOrError("John123", "SE19PQ")
  val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] = Letter.letterOrError("John", "SE19PQ1") // Invalid due to missing space
  val letterAllInvalid: Either[GenericPostageError, Letter] = Letter.letterOrError("John123", "SE19PQ1") // Invalid name and postcode

  println("--> Testing letterOrError method")
  println(letterWithANumberInName) // Should print: Left(InvalidNameError(Name cannot contain numbers))
  println(letterWithAnInvalidPostcode) // Should print: Left(InvalidPostcodeError(Invalid postcode format))
  println(letterAllInvalid) // Should print: Left(InvalidNameError(Name cannot contain numbers))

}
