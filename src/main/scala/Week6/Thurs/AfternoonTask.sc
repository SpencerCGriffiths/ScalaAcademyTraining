/** Afternoon Task MVP 1 */

  // Create a function that takes an Int input and manipulates it to return a different Int value
val manipulateNum: Int => Int = _ * 2

manipulateNum(2)

  // Create a second function called applyTwice that takes two arguments.
    // One of the arguments is an Int input
    // The other argument is an Int to Int function made in step one
    // the applyTwice function myst apply the Int to Int function argument twice to the Int

//Higher Order Function
def applyTwice(x: Int, function: Int => Int): Int = {
  val one = function(x)
  function(one)
}
  // Create 4 functions (addition, multiplication, division, subtractions), each take two doubles as an inout and return the result

val addition: (Double, Double) => Double = (x, y) => x + y

val multiplication: (Double, Double) => Double = (x, y) => x * y

val division: (Double, Double) => Double = (x, y) => x / y

val subtraction: (Double, Double) => Double = (x, y) => x - y

  // Create a function called mathFunc. Takes two doubles and an operation as a function and returns the result

def mathFunc(x: Double, y:Double, fun: (Double,Double) => Double): Double = {
  fun(x, y)
}

mathFunc(1,2, addition)
mathFunc(1,2, multiplication)
mathFunc(1,2, division)
mathFunc(1,2, subtraction)

/** MVP 2 */

// Create a function called convertToUpperCase, takes any string input, returns that string as uppercase

val convertToUpperCaseFun: (String) => String = (word) => word.toUpperCase

def convertToUpperCaseMeth(word: String): String = {
  word.toUpperCase
}

// create a function called convertToLowerCase, takes any string input, returns that string as lowercase

val convertToLowerCaseFun: (String) => String = (word) => word.toLowerCase

def convertToLowerCaseMeth(word: String): String = {
  word.toLowerCase
}

// create convertString, takes a boolean with name makeStringUpperCase. If true reutrn the 1st upperCase method. if false return 2nd lowerCase method.


def convertStringFun(makeStringUpperCase: Boolean): (String) => String = {
  makeStringUpperCase match {
    case true => convertToUpperCaseFun
    case false => convertToLowerCaseFun
  }
}

def convertStringMeth(makeStringUpperCase: Boolean): (String) => String = {
  makeStringUpperCase match {
    case true => convertToUpperCaseMeth
    case false => convertToLowerCaseMeth
  }
}

// Copy val testString= "cOnVeRtMe". Apply your convertString method to your testString

val testString= "cOnVeRtMe"

convertStringFun(true)(testString)
convertStringMeth(true)(testString)

convertStringFun(false)(testString)
convertStringMeth(false)(testString)

  // Create a "calculate" method that takes a string input and pattern matches it to return one previously written methods from q1 i.e. add, subtract etc.

def calculate(operation: String): (Double, Double) => Double = {

  operation.toLowerCase.trim match {
    case "add" => addition
    case "subtract" => subtraction
    case "multiply" => multiplication
    case "divide" => division
  }
}

  // try applying different string inputs to the calculate method to return each of the methods. Save the result in a val.

  val calculateAddFunction1: (Double, Double) => Double = calculate("add")
calculateAddFunction1(1,2)
  val calculateAddFunction2: (Double, Double) => Double = calculate("aDD")
  val calculateAddFunction3: (Double, Double) => Double = calculate("   add   ")

  val calculateSubtractFunction1: (Double, Double) => Double = calculate("subtract")
calculateSubtractFunction1(1,2)
  val calculateSubtractFunction2: (Double, Double) => Double = calculate("subtrACT")
  val calculateSubtractFunction3: (Double, Double) => Double = calculate("  subtract  ")

  val calculateMultiplyFunction1: (Double, Double) => Double = calculate("multiply")
calculateMultiplyFunction1(1,2)
  val calculateMultiplyFunction2: (Double, Double) => Double = calculate("multiPLY")
  val calculateMultiplyFunction3: (Double, Double) => Double = calculate("  multiply ")

  val calculateDivideFunction1: (Double, Double) => Double = calculate("divide")
calculateDivideFunction1(1,2)
  val calculateDivideFunction2: (Double, Double) => Double = calculate("divIDE")
  val calculateDivideFunction3: (Double, Double) => Double = calculate("  divide   ")


/** ------------------- */
  // what happens if you enter an input that doesn't match

/** ------------------- */
// Option 1- Use an Either
def calculateWithNonMatch(operation: String): Either[String, (Double, Double) => Double] = {

  operation.toLowerCase.trim match {
    case "add" => Right(addition)
    case "subtract" => Right(subtraction)
    case "multiply" => Right(multiplication)
    case "divide" => Right(division)
    case _ => Left("Error: Not valid operation")
  }
}
/** ------------------- */
    // 1.a You can unwrap the Either throwing an Exception
def unwrapFunction(either: Either[String, (Double, Double) => Double]): (Double, Double) => Double = {
  either match {
    case Right(f) => f
    case Left(error) => throw new IllegalArgumentException(error)
    // Could throw  but this will stop it running and error out the program
  }
}

val outcome1a = calculateWithNonMatch("add")
val outcomeFunction = unwrapFunction(outcome1a)
outcomeFunction(1,2)

val error1a = calculateWithNonMatch("oooo")
// val outcomeFunction = unwrapFunction(error1a) <- working out the error results in the throw stopping the worksheet

/** ------------------- */
    // 1.b directly pattern match as outcome

val outcome1b = calculateWithNonMatch("add")
 outcome1b match {
  case Right(fun) => fun(1,2)
  case Left (error) => println(error)
}


val error1b = calculateWithNonMatch("ooo")
error1b match {
  case Right(fun) => fun(1,2)
  case Left (error) => println(error)
}

// Apply the val methods (from above) passing in two int values. print the result using s interpolation

val outcomeAdd = calculateWithNonMatch("add")
outcomeAdd match {
  case Right(fun) => println(s"The outcome of addition between 1 and 2 is ${fun(1,2)}")
  case Left (error) => println(error)
}

val outcomeSubtract = calculateWithNonMatch("subtract")
outcomeSubtract match {
  case Right(fun) => println(s"The outcome of subtract between 1 and 2 is ${fun(1,2)}")
  case Left (error) => println(error)
}

val outcomeMultiply = calculateWithNonMatch("multiply")
outcomeMultiply match {
  case Right(fun) => println(s"The outcome of multiply between 1 and 2 is ${fun(1,2)}")
  case Left (error) => println(error)
}

val outcomeDivision = calculateWithNonMatch("divide")
outcomeDivision match {
  case Right(fun) => println(s"The outcome of division between 1 and 2 is ${fun(1,2)}")
  case Left (error) => println(error)
}

val outcomeError = calculateWithNonMatch("ooo")
outcomeError match {
  case Right(fun) => fun(1,2)
  case Left (error) => println(error)
}

// def manipulateNum2(x: Int): Int = {
//  x * 2
//}
//
//def higherOrder(x: Int, fun: Int => Int): Int = {
//  fun(x)
//}
//
//higherOrder(2, manipulateNum2)

// you can pass a method as a function i.e. a def?? Ask April