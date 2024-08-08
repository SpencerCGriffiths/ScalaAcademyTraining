/** Higher Order Functions */

// ##What does it mean to be a first class citizen?
// We can

// 1. Assign functions to Vals

val addition: (Int, Int) => Int = (x, y) => x + y // val addition: (Int, Int) => Int = <function>

addition(1, 2) //val res0: Int = 3

val subtract: (Int, Int) => Int = (x, y) => x - y // val addition: (Int, Int) => Int = <function>

// 2. We can store functions in collections
// i.e. lists, maps, sequences

val functionList = List(
  (a: Int, b: Int) => a + b,
  (a: Int, b: Int) => a * b,
  (a: Int, b: Int) => a - b,
  (a: Int, b: Int) => a / b
) // val functionList: List[(Int, Int) => Int] = List(<function>, <function>, <function>, <function>)


// This is a list that contains functions
// This would need to use index to access the function

functionList.head(1, 2) // Index 0 - val res1: Int = 3
functionList(1)(1,2) // Index 1 - val res2: Int = 2
functionList(2)(1,2) // Index 2 - val res3: Int = -1
functionList(3)(1,2) // Index 3 - val res4: Int = 0


// 3. Pass functions into arguments/params
// This is the more common format
// as long as it has the right params of the right type i can pass the function
def manipulateNumbers (x: Int, y:Int, function:(Int,Int) => Int) : Int = {
  function(x,y)
} // def manipulateNumbers(x: Int, y: Int, function: (Int, Int) => Int): Int


manipulateNumbers(1,2, addition) // val res5: Int = 3
manipulateNumbers(1,2, subtract) // val res6: Int = -1

// 4. return functions from other functions

def createAdditionFunction(x:Int): Int => Int = {
//  println(s"$x")
  (y: Int) => x + y
} // def createAdditionFunction(x: Int): Int => Int

// This is just returning a function but it isn't actually doing anything yet as we haven't declared y
createAdditionFunction(1) // val res7: Int => Int = <function>

// This creates the function AddOne and already gives it 1
val addOne: Int => Int = createAdditionFunction(1) // val addOne: Int => Int = <function>

// The value passed to the addOne is the y value
addOne(2) // val res8: Int = 3

// Hint- This could be a calculator function that allows you to wrap a master in a function

// ------------------------------------------------------------------------------
/*************************************/
/** ---> Function as params */

  // Declaring a Higher Order Function
def firstHOF(x: Int, function: Int => Int): Int = {
  function(x) // This needs a function and will pass x as the param
}

// This is a separate method that wants one param and adds two
def addTwo(n: Int): Int = n + 2

// This calls the Higher Order function, the first param is passed to the internal function
// The second param is the function that the first param is being passed to
firstHOF(1, addTwo)

// Example 2:
def square(n: Int): Int = n * n

// Example 2:
firstHOF(2, square)

/** Using Strings*/

  // Declare the higher order function
def processTheList(list1: List[String], function: String => String): List[String] =  {

//  i will perform a function on each item in the list
  list1.map(function)

}

// normal function to add an s
def addS(word: String): String = {
  word + "s"
}

// normal function to make uppercase
def upperCase(word: String): String = {
  word.toUpperCase
}

val newList: List[String] = List("Hello", "World", "Scala")

processTheList(newList, addS) // val res11: List[String] = List(Hellos, Worlds, Scalas)
processTheList(newList, upperCase) // val res12: List[String] = List(HELLO, WORLD, SCALA)

/** Map higher order function- Common */
// iterating through a function and doing something to the values

val numbers = Seq(1,2,3,4,5)

val doubledNumbers = numbers.map(num => num * 2)

/** Fold Left */
// Fold Left - USed to reduce a collection into a single value.

  // Current value - Index 0
val foldLeftEx = numbers.foldLeft(0)(_ + _) // Accumulator + Current Value
// val foldLeftEx: Int = 15

val stringList: List[String] = List("Hello", "World", "Welcome", "to", "Scala")

val concatString: String = stringList.foldLeft("")(_ + _) // val concatString: String = HelloWorldWelcometoScala
val concatString2: String = stringList.foldLeft("")(_ + " " + _).trim // val concatString2: String = Hello World Welcome to Scala

/** Fold Right */
// Current value - 0
val foldRightEx = numbers.foldRight(0)(_ + _) // Accumulator + Current Value
// val foldLeftEx: Int = 15

val concatStringR: String = stringList.foldRight("")(_ + _) // val concatString: String = HelloWorldWelcometoScala
val concatStringR2: String = stringList.foldRight("")(_ + " " + _).trim // val concatString2: String = Hello World Welcome to Scala

/** More complex folding */
case class Male (male: Boolean)
case class Animal(name: String, male: Male)

// Using case class to keep it type safe

val animalList = List(Animal("Fred the Fox", Male(true)), Animal("Sally the Seahorse", Male(false)), Animal("Lucky the lion", Male(true)))

// Starting with an empty list of strings
val foldAnimalsLeft = animalList.foldLeft(List[String]()) { (acc, animal) =>
  // if animal male its sir
  // if animal female madam
  val sirOrMadam = animal.male match {
    // using case classes above allows us to do Male(true) rather than just true
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }

  // concatenate a list :+
  acc :+ s"$sirOrMadam ${animal.name}"

}

println(foldAnimalsLeft)

/** Complex fold right */
// Starting with an empty list of strings
val foldAnimalsRight = animalList.foldRight(List[String]()) { (animal, acc) =>
  // if animal male its sir
  // if animal female madam
  val sirOrMadam = animal.male match {
    // using case classes above allows us to do Male(true) rather than just true
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }

  // concatenate a list :+
  acc :+ s"$sirOrMadam ${animal.name}"

}

println(foldAnimalsRight)

/** Practice task  */

  // Use numbers list and find the product of the list
val numbersTask = Seq(1,2,3,4,5)

val total = numbersTask.foldLeft(0)(_ +_) // val total: Int = 15

// Use the filter method to return only the true ints from the list

val trueInts = numbersTask.filter(n => n % 2 == 0) // val trueInts: Seq[Int] = List(2, 4)

// Use a fold function to count the number of characters in a string
val stringTask: List[String] = List("hEllo", "worLd", "welcOme", "to", "scAla")

val numOfChars: Int = stringTask.foldLeft("")(_+_).length // val numOfChars: Int = 24

val numOfChars2: Int = stringTask.foldLeft(0){ (acc, word) =>
  word.length + acc
}

// Use the map function to iterate through the list, transform the first letter to a capital. Concat into a sentence

/** Complete using Val  */
val upperCaseList: List[String] = stringTask.map(word =>
  word.head.toString.toUpperCase + word.tail.toLowerCase
)

val upperCaseConcat: String = upperCaseList.foldLeft("")(_ + " " + _).trim


/** Complete as a Higher Order Function */
def capitalisedSentence(words: List[String], function1:(List[String]) => List[String], function2: (List[String]) => String): String = {
  val capital = function1(words)
  val string = function2(capital)
  string
}

def upperCaseMeth (words: List[String]) : List[String] = {
  words.map(word =>
  word.head.toString.toUpperCase + word.tail.toLowerCase
  )
}

def concateWords (words: List[String]) : String = {
  words.foldLeft("")(_ + " " + _).trim
}

val upperSentence = capitalisedSentence(stringTask, upperCaseMeth, concateWords)

/** Returning functions*/

def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) =>
    salary * 1.1
}

def mediumRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) =>
    salary * 1.2
}

def largeRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) =>
    salary * 1.5
}
//^^ Each is their own mini higher order function

// make a case class to patten match
case class Employee(name: String, salary: Double, lengthOfEmployment: Int)

//^^ The above could be in a separate file and only used when needed

def getPayRise (employee: Employee): (Int, Double) => Double = {
  employee.lengthOfEmployment match {
    case year if year <= 3 => smallRise(employee.salary) //
    case year if year <= 5 => mediumRise(employee.salary)
    case year if year > 7 => largeRise(employee.salary)
  }
}
// This is returning the correct function


val Amanda = Employee("Amanda", 30000.0 , 2)

val choosePayRise = getPayRise(Amanda)
// val ChoosePayRise: (Int, Double) => Double = <function>
// ^^ Returns the appropriate pay rise function

val getNewSalary = choosePayRise(Amanda.lengthOfEmployment, Amanda.salary)
// ^^ Using the function that was returned

/** Using it as a Higher order function means that we can change the small rise amount to 1.1. If we multiplied it by 1.1 in multiple places then we would have to change it everywhere */

/** Eg interest rates. Creating a method means that when it changes we can just change that easy method*/

/**Returning Functions Task 2*/

def smallDiscount(price: Double): (Double) => Double = {
  (price:Double) =>
    price * 0.8
}
def mediumDiscount(price: Double): (Double) => Double = {
  (price:Double) =>
    price * 0.6
}
def bigDiscount(price: Double): (Double) => Double = {
  (price:Double) =>
    price * 0.5
}

case class Item(name: String, price: Double)

def getDiscount(item: Item): (Double) => Double = {

  item.price match {
    case price if price < 20 => smallDiscount(item.price)
    case price if price >= 20 && price <= 50=> mediumDiscount(item.price)
    case price if price > 50 => bigDiscount(item.price)
  }

}

val lamp: Item = Item("lamp", 15.0)
val getDiscountFunction = getDiscount(lamp)
val discountPrice = getDiscountFunction(lamp.price)

val table: Item = Item("table", 40.0)
val getDiscountFunction = getDiscount(table)
val discountPrice = getDiscountFunction(table.price)

val house: Item = Item("lamp", 100.0)
val getDiscountFunction = getDiscount(house)
val discountPrice = getDiscountFunction(house.price)

val magicItem: Item = Item("magic", 30)
getDiscount(magicItem)(magicItem.price)

// Task 1 passing in a function
// Task 2 returning a function 