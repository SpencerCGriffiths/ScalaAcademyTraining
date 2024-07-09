// Functions and Methods

// Functions:
// Functions can be assigned to a val
// Methods are a form of functions
// Functions are no different to any type
// Don't have to name them (if we don't they are not reusable)

// Methods:
// Keyword "Def" must be used
// Methods belong to a class
// Methods can be overridden
// Methods must be names


// Anonymous Function:
(number:Int) => number + 1

// Named Function:
val addition = (number:Int) => number + 1
//Long hand:
val addition: Int => Int = (number: Int) => number + 1


// Method:
def addition = (number: Int) => number + 1


// Override Method (doesn't need override keyword)
def addition = (number: Int) => number + 1


/**
 * A method is defined like this:
 *
 * def nameOfMethod(parameters but this can be empty): ReturnType = {
 * -> Expression 1
 * -> Expression 2
 * -> Expression 3 etc
 * -> Expression last - has to return the return type
 * }
 */

// Make a cup of tea method:
def makeAcupOfTea(numOfSugar:Int): String = {
  s"You have made a tea with $numOfSugar spoons of sugar, Enjoy"
}

// Calling a method
makeAcupOfTea(2)

// The last expression is returned, it does not matter what comes before:
def makeAcupOfTea2(numOfSugar:Int): String = {
  45
  val cuppa = "tea"
  s"You have made a tea with $numOfSugar spoons of sugar, Enjoy"
}
makeAcupOfTea2(2)

/**
 Tasks
 Task 1
 We never see the last expression being a println() why do you think this is?

 Answer:
 println returns a unit type, this is not a helpful data type to return. If you want to return a string return the string not a print line.

 Task 2:
 Think back to if/else statements. What does the below return?

 Answer:
 42

*/

val aValue = (2<3)

val aDifferent: Int = {
  if (aValue) 564 else 865
  42
}

aDifferent


//_________________________________________________________________

// VAT Method Exercise:

//Declare variable for our method:
val vat: Double = 1.2

// Declare the method:
def priceWithVAT(priceOfItem: Double): Double = {
  priceOfItem * vat
}

// Call the method:
priceWithVAT(5.0)

//_________________________________________________________________

// Methods within a class:

// Class-
class Number(number: Int) {

  //Method-
  def addition(num: Int): Int = {
    number + num
  }
}

// Instantiate an object-
val newNumberClass = new Number(5)

// Call method way 1-
newNumberClass.addition(4)

// Call method way 2-
val classAddition = newNumberClass.addition(4)

//_________________________________________________________________

// Task 1:

//Create a method called 'getBigVak' that takes in two integers Input1 and Input2 and returns a string.

// The method should return:
// "first" if input1 > input 2
// "second" if input 1 < input 2
// "same" if input 1 == input 2

def getBigVal(num1: Int, num2: Int): String = {
  if (num1 > num2) {
    "first"
  } else if (num1 < num2) {
    "second"
  } else {
    "same"
  }
}

getBigVal(1,4)
getBigVal(4,1)
getBigVal(1,1)

// Task 2:
// create a method called "nameLength" that takes in two strings called firstname and lastname and returns a integer.

// The method should return:
// length/size of the name which is greater.
// if both names are the same length return 0.

def nameLength(firstName: String, lastName: String): Int = {
 if (firstName.length > lastName.length) {
   firstName.length
 } else if (firstName.length < lastName.length) {
   lastName.length
 } else {
   0
 }
}

nameLength("Tom", "Hiddleston")
nameLength("Elizabeth", "Olsen")
nameLength("Chris", "Pratt")

//_________________________________________________________________

// Referential Transparency

// Simply means a functions return value is based solely on the inputs.

// For example given an addition method that has inputs 1 and 1, the addition function will always return a result of 2.

// This means every reference to addition(1,1) can be replaced with 2 and the application would continue to function as it did prior to the result replacement.

// i.e. save the code and syntactic sugar and just write 2 everywhere.

//_________________________________________________________________

// Pure and Impure functions:
// Pure: given the same input(s) the output will always be the same.
// Impure: Given teh same input(s) the output will be different if passed in multiple times.

// Example of pure:

val sentence: String =""

def append(sentence:String, word:String): String = {
  sentence + " " + word.trim()
}
val a = append(sentence, "Allo")
val b = append(sentence, "Allo")

// Uses a val sentence so it is immutable. Each call the string starts at " ". Each call returns the same thing so it is pure.

// Example of impure:

var sentence2: String = ""

def append2(word:String): String = {
   sentence2 = sentence2 + " " + word
   sentence2.trim()
}

val a2 = append2("Allo")
val b2 = append2("Allo")

// Uses a var value and is mutable. On each call we are reassigning a value so now each call returns something different and potentially unpredictable. 

//_________________________________________________________________
// Task:
// Take a look at these snippets of code.
// What can you infer from them in relation to scope?

// Figure 1:
package maths

trait Numbers {
  val one = 1
  val two = 2
  val three = 3


  def addOneAndThree: Int = {
    one + three
  }

  def addNumAndTwo(num:Int): Int = {
    num + two
  }
}

//Figure 2:
package maths

object Subtractions extends Numbers {
  def subtractNumfromFour(num: Int) = {
    addOneAndThree -num
  }
}

//Figure 3:
package maths

object Multiplications {
  val three = 3

  def multiplyNumAndThree(num: Int): Int = {
    num * Subtractions.three
  }

  def multiplyTwoAndThree: Int = {
    import Subtractions._
    two * one
  }
}

// Package Math - They are all in the same package

// trait has been extended so we can use the values in figure 2.

// Val Three in figure 3 is only accessible within the object in figure three.

// We can import the object Subtractions
//_________________________________________________________________

// Afternoon Tasks!


//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________
//_________________________________________________________________


