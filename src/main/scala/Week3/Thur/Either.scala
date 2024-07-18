package Week3.Thur

import sun.security.util.Password

import java.time.LocalDate

/** ## Either
 *
 * Just like how we used an Option as a type, an Either is also a type
 * Takes in 2 parameter (a Left and a Right)
 * Popular to sue when error handling. Will mean you can return a Throwable rather than the code crashing.
 *
 * Either [A,B]
 *
 * A = Left
 * - Usually error case
 *
 * B = Right
 * - Usually the success case
 *
 * (Right is right :) )   */

object Either extends App{


  def isEven (x: Int): Either[String, String] = if (x % 2 == 0) Right(s"$x is even") else Left(s"$x is odd")

  println(isEven(4))
  println(isEven(5))

  // Custom Error
  // Exception is built in for custom errors
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception

  case object IsOddError extends NewError(400, "Bad Request in the is odd method")

  // passing in NewError means we can pass in everything that is extending NewError
  def isOdd (x: Int): Either[NewError, String] = if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)

  println(isOdd(4))
  println(isOdd(5))

  /** Try/Catch */
  def plusOne(x: String): Either[String, Int] = {
    try {
      Right(x.toInt)
    } catch {
      case e: Exception => Left(s"Failed due to: $e")
    }
  }

  println(plusOne("1")) // Right - try
  println(plusOne("One")) // Left - catch


  /** Functions directly*/
  plusOne("3").map(num => num + 1)
  plusOne("i will fail").map(num => num +1) // will fail above and not get to here


  /** Pattern Matching Either */
  // try the left first
  def plusOneMatch(): Unit = {
    plusOne("1") match {
      case Left(e) => println(s"Left: $e")
      case Right(x) => println(s"Right: $x")
    }
  }

  println(plusOneMatch())


  /** Combination */

  // When you have methods that depend on each other for comprehension allows you to fail before causing a clash in data types
  // Fail fast - as soon as one condition is not met = exit


  /** Declare Classes to work with */
  // This is the user trying to log in
  case class User(username: String, password: String, dateOfBirth: LocalDate)

  // return type is a validated user
  case class ValidatedUser (username: String, password: String, dateOfBirth: LocalDate)


  /** Create Methods to test the validity of the user */

  // Validate Username
  def validatedUsername(username: String): Either[String, String] = {
    if(username.length < 12) Left("Username must be at least 12 characters") else Right(username)
  }
              // Can add custom errors later in the Left[]

  // Validate Password
  def validatePassword(password: String): Either[String, String] = {
    if(password.toLowerCase == password || password.toUpperCase() == password) Left("Password must be a mix of upper and lower case") else Right(password)
  }

  // Validate DOB over 18
  def validateDOB(dateOfBirth: LocalDate): Either[String, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now())) Left("User must be 18 years old") else Right(dateOfBirth)
  }

  /** Combine the methods in one Method in order to validate */

  // Combine all three and Validate the whole user

  def validateTheUser(user: User): Either[String, ValidatedUser] = {

    for {
      // Values on left are just stand in, could be anything
      // the right is calling the method
      username <- validatedUsername(user.username)
      password <- validatePassword(user.password)
      dateOfBirth <- validateDOB(user.dateOfBirth)
      // If any of the above fail it will hit the error in the left inside of each method

      // If all the above is fine return the last thing
      createValUser = ValidatedUser(username = username, password = password, dateOfBirth = dateOfBirth)
    } yield createValUser // yield i.e. return, the created validated user
  }

  val usernameBad = User("austen", "Password", LocalDate.of(1994, 4, 10))
  println("---> Bad Username")
  println(usernameBad)
  println(validateTheUser(usernameBad))
  println()
  val passwordBad = User("StoneColdSteveAusten", "password", LocalDate.of(1994, 4, 10))
  println("---> Bad Password")
  println(passwordBad)
  println(validateTheUser(passwordBad))
  println()
  val DOBBad = User("StoneColdSteveAusten", "Password", LocalDate.of(2024, 4, 10))
  println("---> Bad DOB")
  println(DOBBad)
  println(validateTheUser(DOBBad))
  println()
  val AllGood = User("StoneColdSteveAusten", "Password", LocalDate.of(2004, 4, 10))
  println("---> Perfect User")
  println(AllGood)
  println(validateTheUser(AllGood))
  println()

}
