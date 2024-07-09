
// Task 2)
// Write pure function(s) to return the Fibonacci sequence up to a given "n". Use 3 and 4 as the start terms.

val fibonacciStartAt34: Int => Seq[Int] = (n: Int) => {
  lazy val fib: Int => Int = (index: Int) => {
    if (index == 0) 3
    else if (index == 1) 4
    else {
      fib(index - 1) + fib(index - 2)
    }
  }
  (0 until n).map(fib)
}

// Example usage
val result = fibonacciStartAt34(10)
println(result) // Output: Vector(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)

/** See Notes on Lazy Val at end */
//_____________________________________________________________________

// ------------> Alternative Option

// Pure fibonacci function
val start:Seq[Int] = Seq(3,4)


def fibonacciPure(n:Int, seq:Seq[Int]): Seq[Int] = {
  val n1:Int = seq.reverse.head
  val n2:Int = seq.reverse.tail.head

  if (n <= 0) seq else fibonacciPure(n-1, seq:+n1+n2)
}
fibonacciPure(4, start)

//_____________________________________________________________________

// Task 2 additional)
// using Memoization to make it more memory and speed efficient-
import scala.collection.mutable

def fibRecurseWithMemoization(n: Int): Seq[Int] = {

  // Create a mutable Map as a lookup object
  val memoization = mutable.Map[Int, Int]()

  def getNextNum(index: Int): Int = {

    var result: Int = 0
    // If Memoization look up object contains the key of that index
    if(memoization.contains(index)) {

      //      println("Memoization is happening to save memory and time")
      // Return the value of the key in the map
      memoization(index)
    }

    if (index == 0) {
      result =  3
      result
    } else if (index == 1) {
      result =  4
      result
    } else {
      result = getNextNum(index - 1) + getNextNum(index - 2)
    }

    memoization(index) = result
    result
  }

  (0 until n).map(getNextNum)

}

fibRecurseWithMemoization(10)

//_____________________________________________________________________
// -------------> Cannot get it to be impure!!!

//Impure Functions: An impure function is a function that has side effects or does not always return the same output when given the same input. Side effects can include modifying a global variable, changing the state of an object, or making a network request.

// Task 3)
// Do the same but with an impure function, Which is better? Why?
// Updates the starting sequence

// Impure fibonacci function
var sequence:Seq[Int] = Seq(3,4)

def fibonacciImpure(n:Int):Seq[Int] = {
  val n1:Int = sequence.reverse.head
  val n2:Int = sequence.reverse.tail.head
  if (n <= 0) sequence else{
    sequence = sequence:+n1+n2
    fibonacciImpure(n-1)
  }
}

fibonacciImpure(5)

//_____________________________________________________________________

//------> Fibonacci With One function and one Method

val fibonacciFunctionWith34: Int => Seq[Int] = (n : Int) => {

  def getNextNum: Int => Int = (index: Int) => {

    if (index == 0) {
      3
    } else if (index == 1) {
      4
    } else {
      getNextNum(index - 1) + getNextNum(index - 2)
    }
  }
  (0 until n).map(getNextNum)
}

fibonacciFunctionWith34(10)

//_____________________________________________________________________
//-----------> Fibonacci with Methods

def fibRecurseWithStart(n: Int): Seq[Int] = {
  def getNextNum(index: Int): Int = {

    // Varies from above as setting starting numbers as 3 and 4 as index 0 is equal to 3 and index 1 is equal to 4
    if (index == 0) {
      3
    } else if (index == 1) {
      4
    } else {
      getNextNum(index - 1) + getNextNum(index - 2)
    }
  }
  (0 until n).map(getNextNum)
}
fibRecurseWithStart(10)

//_____________________________________________________________________

//-----------> Fibonacci with Methods at a new start point

def fibRecurseWithStart(n: Int): Seq[Int] = {
  def getNextNum(index: Int): Int = {

    // Varies from above as setting starting numbers as 3 and 4 as index 0 is equal to 3 and index 1 is equal to 4
    if (index == 0) {
      3
    } else if (index == 1) {
      4
    } else {
      getNextNum(index - 1) + getNextNum(index - 2)
    }
  }
  (0 until n).map(getNextNum)
}
//_____________________________________________________________________

// -------------> Fibonacci Breakdown!!!

// Declare the Method for Fibonacci Calculation giving n being the number of resulting elements
def fibSeqWithRecursion(n: Int): Seq[Int] = {

  // Create a method that calculates the actual value at each index
  def getNextNum(index: Int): Int = {

    // if the the number is index 1 or 0 return 1 or 0 as this is the start of the sequence
    if (index <= 1) {
      index
    }
    // if not calculate the next step
    else {
      // example of the recursion below is:
      // getNextNum(3) Calculates-
      // getNextNum(2) + getNextNum(1)
      // getNextNum(2) has to be calculated-
      // getNextNum(1) + getNextNum(0) = 1
      // therefor getNextNum(2) = 1 + getNextNum(1) = 1
      // Finally getNextNum(3) = 2
      getNextNum(index - 1) + getNextNum(index - 2)
    }
  }

  // 0 until n creates a range of values between 0 and n-1
  // map then applies the getNextNum function to the values
  // map maintains the collection type it is given
  // 0 until n produces a range which is a type of Seq[]
  // .map then applies getNextNum to each Int in the range following the above recursive logic i.e. getNextNum(0), getNextNum(1) and on.
  (0 until n).map(getNextNum)
}

fibSeqWithRecursion(10)

// Outcome:
// val res5: Seq[Int] = Vector(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)

// A vector is a subtype of Sequence, it is immutable and efficient and as such Scala is pushing this subtype.

//_____________________________________________________________________

// Lazy Val:
// Lazy means that the compiler doesn't immediately evaluate the bound expression of a lay val. It evaluates the variable only on its first access.
// Upon initial access the compiler evaluates the expression and stores the result in the lazy val. Whenever we access this cal at a later stage no execution happens and the compiler returns the result.

// Potential Concerns:
// lazy can cause potential deadlock when a lazy val is trying to be initialised twice at the same time

// Example:
/**
object FirstObj {
  lazy val initialState: Int = SecondObj.initialState + 1
}

object SecondObj {
  lazy val initialState: Int = FirstObj.initialState + 1
}

object DeadlockExample extends App {
  def run: Unit = {
    println(s"FirstObj initial state: ${FirstObj.initialState}")
    println(s"SecondObj initial state: ${SecondObj.initialState}")
  }

  run
}
*/

// Above accessing FirstObj.initialState triggers the initialisation SecondObj.initialState.
// However SecondObj.initialState requires the initialisation of FirstObj.initialState.
// As such now neither val can be initialised resulting in val not found.

// Delay in computation:

// Lazy vals benefit of not being initialised until later in the program also means that for large data there can be a delay in computation.

// Declaring a Method
  def square(n: Int): Int = {
    // Demonstrates the delay in computation (this would be evident on a large data set
    Thread.sleep(1000)
    n * n
  }
    // Lazy val is not initialised
  lazy val squareOf5: Int = {
    println("Initializing squareOf5")
    square(5)
  }

    // Lazy val is initialised
  lazy val squareOf6: Int = {
    println("Initializing squareOf6")
    square(6)
  }


  def run(): Unit = {
    println("Accessing squareOf5:")
    // Only now is the lazy val initialised prior to computation
    // This adds the time to initialise the val to the computation time of the method run
    println(squareOf5)

    // Same as above
    println("Accessing squareOf6:")
    println(squareOf6)
  }

  run()


//_____________________________________________________________________


// For Loop Variety
val test: Seq[Int] = Seq(1,2,3,4,5,6,7,8)
for(n <- test) {
  println(n)
}

test.foreach {
  case (num) => println(num)
}

for (i <- 0 until test.length) {
  println(test(i))
}

for (i <- test.indices) {
  println(test(i))
}



//_____________________________________________________________________
//_____________________________________________________________________
//_____________________________________________________________________
//_____________________________________________________________________
//_____________________________________________________________________
//_____________________________________________________________________