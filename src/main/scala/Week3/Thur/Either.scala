package Week3.Thur

/** ## Either

 Just like how we used an Option as a type, an Either is also a type
 Takes in 2 parameter (a Left and a Right)
 Popular to sue when error handling. Will mean you can return a Throwable rather than the code crashing.

 Either [A,B]

 A = Left
 - Usually error case

 B = Right
 - Usually the success case

 (Right is right :) )   */

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
}
