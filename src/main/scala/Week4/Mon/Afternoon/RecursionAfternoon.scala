package Week4.Mon.Afternoon

import Week4.Mon.Afternoon.RecursionAfternoon.Euro2024.Team

import scala.annotation.tailrec

object RecursionAfternoon extends App {


  /** Create an object and extending with Enumeration so you can provide all the teams participating in the Euro 2024. Now write a tail recursive method to print all the teams. Is there an easy way to print them all without having to input each individually in the List in the call? */

  println("\nCreate an object and extending with Enumeration so you can provide all the teams participating in the Euro 2024. Now write a tail recursive method to print all the teams. Is there an easy way to print them all without having to input each individually in the List in the call?")

  object Euro2024 extends Enumeration {
    type Team = Value
    val Germany, Scotland, Hungary, Switzerland, Spain, Croatia, Italy, Albania, Slovenia, Denmark, Serbia, England, Poland, Netherlands, Austria, France, Belgium, Slovakia, Romania, Ukraine, Turkey, Georgia, Portugal, Czechia = Value
  }


  def euroRecurse(list: List[Team]): String = {
    @tailrec
    def helper(remaining: List[Team], acc: String): String = {
      remaining match {
        case Nil => acc
        case head :: tail =>
          val newAcc = if (acc.isEmpty) head.toString else acc + ", " + head.toString
          helper(tail, newAcc)
      }
    }

    helper(list, "")
  }

  println("--> " + euroRecurse(Euro2024.values.toList) + "\n")

  /** Now can you do the same as Question 1, but instead of using Enumeration, implement it using a sealed class and pattern matching inside an object? What do you notice about accessing the values? */
  println("\nNow can you do the same as Question 1, but instead of using Enumeration, implement it using a sealed class and pattern matching inside an object? What do you notice about accessing the values?")

  sealed trait EuroTeams

  case object Germany extends EuroTeams

  case object Scotland extends EuroTeams

  case object Hungary extends EuroTeams

  case object Switzerland extends EuroTeams

  case object Spain extends EuroTeams

  case object Croatia extends EuroTeams

  case object Italy extends EuroTeams

  case object Albania extends EuroTeams

  case object Slovenia extends EuroTeams

  case object Denmark extends EuroTeams

  case object Serbia extends EuroTeams

  case object England extends EuroTeams

  case object Poland extends EuroTeams

  case object Netherlands extends EuroTeams

  case object Austria extends EuroTeams

  case object France extends EuroTeams

  case object Belgium extends EuroTeams

  case object Slovakia extends EuroTeams

  case object Romania extends EuroTeams

  case object Ukraine extends EuroTeams

  case object Turkey extends EuroTeams

  case object Georgia extends EuroTeams

  case object Portugal extends EuroTeams

  case object Czechia extends EuroTeams

  object TeamsList {
    val allTeams: List[EuroTeams] = List(
      Germany, Scotland, Hungary, Switzerland, Spain, Croatia, Italy, Albania, Slovenia,
      Denmark, Serbia, England, Poland, Netherlands, Austria, France, Belgium, Slovakia,
      Romania, Ukraine, Turkey, Georgia, Portugal, Czechia
    )
  }

  def euroRecurse2(list: List[EuroTeams]): String = {
    @tailrec
    def helper(remaining: List[EuroTeams], acc: String): String = {
      remaining match {
        case Nil => acc
        case head :: tail =>
          val newAcc = if (acc.isEmpty) head.toString else acc + ", " + head.toString
          helper(tail, newAcc)
      }
    }

    helper(list, "")
  }

  // Printing all teams using the List Object
  println("--> " + euroRecurse2(TeamsList.allTeams) + "\n")

  /** Using recursion and given a list with all integers from 1  to 20 inclusive, create a method called “isEven” that checks if a number is even or not. This should return a Unit type. */
  println("\n Using recursion and given a list with all integers from 1  to 20 inclusive, create a method called “isEven” that checks if a number is even or not. This should return a Unit type. ")

  val ints: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  println("--> Print lines inside the function")
  def isEven(list: List[Int]): Unit = {
    @tailrec
    def helper(remaining: List[Int]): Unit = {
      remaining match {
        case Nil => Nil
        case head :: tail =>
          println(head % 2 == 0)
          helper(tail)
      }
    }
    helper(list: List[Int])
  }

  println("--> Final type is a unit: " + isEven(ints).isInstanceOf[Unit] + "\n")


  /** Create a method with input a positive number that returns the sum of all numbers between 0 and the number of choice included (e.g. if we enter 5, then the output should be 5+4+3+2+1 = 15, something like the Factorial method using addition instead of multiplication). */
  println("\n Create a method with input a positive number that returns the sum of all numbers between 0 and the number of choice included (e.g. if we enter 5, then the output should be 5+4+3+2+1 = 15, something like the Factorial method using addition instead of multiplication).")

  def sumNums(posNum: Int): Int = {
    @tailrec
    def helper( n: Int, acc: Int): Int = {
      if(n == 0) {
        acc
      } else {
        helper( n - 1, acc + n)
      }
    }
    helper(posNum, 0)
  }

  println("--> Sum of nums: " + sumNums(8) + "\n")

  /** Extension!! */
  println("\n Extension!!")

  /** Create a method using recursion to implement the Fibonacci sequence.
   What happens if you use Int as the input and output data type and give a big integer number e.g. 5000 which is still considered to be an Int?
   Why do you think you are getting this result?*/
  println("\n Create a method using recursion to implement the Fibonacci sequence.\n   What happens if you use Int as the input and output data type and give a big integer number e.g. 5000 which is still considered to be an Int?\n   Why do you think you are getting this result?")


  def fibonacci(n: Long): Long = {
    @tailrec
    def fibHelper(x: Long, prev: Long, next: Long): Long = {
      if (x <= 0) prev
      else fibHelper(x - 1, next, prev + next)
    }
    fibHelper(n, 0, 1)
  }

  println(fibonacci(5000))
  println("Using a Long data type allows for large numbers such as above. However, this can also be formatted to output a string listing the nums \n")



}