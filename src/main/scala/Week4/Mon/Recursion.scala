package Week4.Mon

//import Week4.Recursion.Fruit.{Apple, Banana, Fruit, Grape, Mango, Orange}

import java.time.DayOfWeek
import scala.annotation.tailrec

object Recursion extends App {

  // Standard recursion

  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      println("Recursion")
      println(n)
      val finalResult = n * factorial(n - 1)
      println(finalResult) // This and below is the final call
      finalResult
    }
  }

  println("\nFactorial method (4) - Standard rec:")
  println(factorial(4))
  //  println(factorial(400000)) // stack overflow error - limited memory on the call stack


  // Tail Recursion

  /** Helper Function */
  // Helps stop the stack overflow error- reusing the call stack rather than just adding to it

  def smartFactorial(n: Long): Long = {
    @tailrec //tells the compiler that this function using tail recursion, helps prevent stack overflow errors, also code safety
    def factorialHelper(x: Long, acc: Long): Long = { //helper method (has an accumulator  + any additional params that may be needed during the recursion, but not in the original method).
      if (x <= 1) acc
      else {
        println(s"Current X: $x")
        println(s"Currect acc: $acc")
        factorialHelper(x - 1, x * acc) //acc - holds the running total - storing that intermediate
      }
    }

    factorialHelper(n, 1)
  }

  println("\n Factorial - tail rec (4):")
  println(smartFactorial(4))
  //1st call: factorialHelper(4-1, 4 * 1) = (3, 4)
  //2nd call: factorialHelper(3-1, 3 * 4) = (2, 12)
  //3rd call: factorialHelper(2-1, 2*12) = (1, 24)
  //4th call: x ==1 ==> hitting the 'if' and returning the acc which is currently stored at 24.
  // println(smartFactorial(1000))

  /** Tail Recursion -> concatenate a string n times */

  /** Without helper method */

  @tailrec
  def concatenateWords(aWord: String, n: Int, acc: String): String = {
    if (n <= 0) acc // when we have reached the total concat return the total
    else {
      println("\n a call")
      concatenateWords(aWord, n - 1, aWord + acc) // rerun the function but with n being 1 less- The accumulator is storing the value of each call i.e. increasing by 1 hello each time
    }
  }

  println("\n tail rec - concatenate words:")
  println(concatenateWords("hello ", 3, ""))

  /** Task */

  /** Write a method that will find out how many elements are in a list of strings.
   *
   * E.g. List(“a”, “b”, “c”) should return 3.
   *
   * Make the method using if/else and recursion (not tail).
   * Write the method using if/else and tail recursion.
   *
   * Extension: Refactor both methods to use match cases. */

  def nInStringRecurse(list: List[Any]): Int = {
    if (list.length <= 1) {
      1
    } else {
      val finalInt = 1 + (nInStringRecurse(list.tail))
      finalInt
    }
  }

  val listA = List("a", "b", "c")
  println("Task Recursion -> ")
  println(nInStringRecurse(listA))

  def nInStringTailRecurse(list: List[Any]): Int = {
    @tailrec
    def stringHelper(newList: List[Any], acc: Int): Int = {
      if (newList.isEmpty) {
        acc
      } else {
        stringHelper(newList.tail, acc + 1)
      }
    }

    stringHelper(list, 0)
  }

  println("Task Tail with Helper Recursion -> ")
  println(nInStringTailRecurse(listA))

  @tailrec
  def nInStringTail2Recurse(list: List[Any], acc: Int): Int = {
    if (list.isEmpty) {
      acc
    } else {
      nInStringTail2Recurse(list.tail, acc + 1)
    }
  }

  println("Task Tail without Helper Recursion -> ")
  println(nInStringTail2Recurse(listA, 0))

  @tailrec
  def nInStringTail2RecurseRefactor(list: List[Any], acc: Int): Int = {
    list.length match {
      case 0 => acc
      case _ => nInStringTail2RecurseRefactor(list.tail, acc + 1)
    }
  }

  println("Task Tail Recursion Refactor -> ")
  println(nInStringTail2RecurseRefactor(listA, 0))


  /** Enumeration and case objects */
  /** Both are very handy when using recursion to work our way through a list. Especially if that list contains a finite number of values */
  // Note unless you use the keyword sealed your pattern matches within your recursive methods might not be exhaustive. You may see a warning for this.

  /** Recursion with Enums */

  object DayOfWeek extends Enumeration {
    type DayOfWeek = Value // alows DayOfWeek to be used as a type
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  def enumListToString(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
    def enumListHelper(dayEnums: List[DayOfWeek.Value], acc: String): String = {
      dayEnums match {
        case Nil => acc
        case ::(head, tail) => // pattern matching and using ::
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          enumListHelper(tail, acc + makeNiceToRead + head.toString)
      }
    }

    enumListHelper(dayOfWeekEnums, "")
  }

  println("\n enum to string method: " + enumListToString(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday)))

  /** Recursion with case objects */
  sealed trait DayOfWeek

  case object Monday extends DayOfWeek

  case object Tuesday extends DayOfWeek

  case object Wednesday extends DayOfWeek

  case object Thursday extends DayOfWeek

  case object Friday extends DayOfWeek

  case object Saturday extends DayOfWeek

  case object Sunday extends DayOfWeek

  def objectsToString(listDays: List[DayOfWeek]): String = {
    def helperMethod(remainingListDays: List[DayOfWeek], acc: String): String = {
      remainingListDays match {
        case Nil => acc
        case head :: tail =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          helperMethod(tail, acc + makeNiceToRead + head.toString)
      }
    }

    helperMethod(listDays, "")
  }

  println("\n object to string: " + objectsToString(List(Monday, Tuesday, Wednesday)))


  /** Task- Given this list:
   List(Apple, Orange, Banana, Apple, Mango, Apple, Grape, Banana)
   Write a method using enumeration and recursion  that will count the number of times a particular fruit appears in the list.
   E.g. Count of Apple: 3 */

  object Fruits extends Enumeration {
    type Fruit = Value
    val Apple, Orange, Banana, Mango, Grape = Value
  }

  def fruitInList(fruitEnums: List[String], searchFruit: String, acc: Int): String = {
    fruitEnums match {
      case Nil => s"Count of $searchFruit: $acc"
      case ::(head, tail) =>
        val newAcc = if (head == searchFruit) acc + 1 else acc
        fruitInList(tail, searchFruit, newAcc)
    }
  }
  println("\n Task of recursion and enumeration:")
  val fruits = List("Apple", "Orange", "Banana", "Apple", "Mango", "Apple", "Grape", "Banana")
  println(fruitInList(fruits, "Apple", 0)) // Output: Count of Apple: 3

}



