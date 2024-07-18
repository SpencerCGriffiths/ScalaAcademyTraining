package Week2.Thurs
import scala.io.StdIn.readLine


  object Main extends App {
    var input = ""

  def doWhile (): Unit = {
    do {
      println("Enter something (type 'exit' to quit):")
      input = readLine()
      println(s"You entered: $input")
    } while (input != "exit")

    println("Goodbye!")
  }

    doWhile()
  }


