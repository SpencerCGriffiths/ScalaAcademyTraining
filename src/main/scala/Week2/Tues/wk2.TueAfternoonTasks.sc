/** Afternoon Tasks
 * Classes, Case Classes, Case Objects
 */


/** MVP */
//---------------------------------------------------
/**1) What are three main differences between a class and a case class?
 * case class's have inbuilt methods
 * case class's do not need to use the 'new' keyword when creating an object
 * a .copy method is available in order to create a copy of the original class and change a val easily
 * */

//---------------------------------------------------
/**2) Which of the following lines of code is runnable and which will produce an error*/

case class Person(name: String, age: Int, nationality: String, isStudent: Boolean) // Declaring a case class
val firstPerson = new Person("Carlos",23,"Spanish",true) // case class can use new keyword
val secondPerson = Person("Carlos",23,"Spanish",true) // case class can also not use new keyword
// thirdPerson = Person("Chloe", 25, "British", false) // Doesn't run without Val

class Animal(name: String, colour: String, pet: Boolean) // Declaring normal class
//val cat = Animal("cat", "black", true) // class cannot work without new keyword
val dog = new Animal("dog","white",true) // class requires new keyword
//---------------------------------------------------
/**3) After reviewing all the combinations, which ones are true when compared using the == operator?*/

case class Muffin(flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin("chocolate",3.50,"Mercator Bakery")
val blueberryMuffin = Muffin("blueberry",3.50,"Mercator Bakery")
val vanillaMuffin = Muffin("vanilla",3.50,"Mercator Bakery")
val anotherChocolateMuffin = Muffin("chocolate",3.50,"Mercator Bakery")
val oneMoreChocolateMuffin = Muffin("chocolate",3.50,"Mercator Bakery")
val finalChocolateMuffin = Muffin("choocolate",2.50,"Mercator Bakery")

// the == operator compares the values inside of the object

// Only true comparison would be true
chocolateMuffin == anotherChocolateMuffin
chocolateMuffin == oneMoreChocolateMuffin
anotherChocolateMuffin == oneMoreChocolateMuffin

// EveryOther comparison would be false
blueberryMuffin == vanillaMuffin

//---------------------------------------------------
/** Extension */
//---------------------------------------------------

// ---------------------------------------------------
/** 1) Construct a case class that takes in a minimum of 3 parameters, each of a different type, and a case object*/

case class afterNoonTask (val taskName: String, val hoursForTask: Int, val completed: Boolean)

case object completedTask

//---------------------------------------------------
/** 2) Create 3 instances of the case class*/

val createClasses: afterNoonTask = afterNoonTask(taskName = "Create Classes", hoursForTask = 3, completed = true)
val learnDataTypes: afterNoonTask = afterNoonTask(taskName = "Learn different Data types", hoursForTask = 1, completed = true)
val fibonacciSequence: afterNoonTask = afterNoonTask(taskName = "Implement the fib sequence", hoursForTask = 1, completed = true)

//---------------------------------------------------
/** 3) use the ".copy" method to create a further 3 instances, each time modifying a different class parameter */
val createClassesTime: afterNoonTask = createClasses.copy(hoursForTask = 2)
val dataTypesIncomplete: afterNoonTask = learnDataTypes.copy(completed = false)
val renameFibSeq: afterNoonTask = fibonacciSequence.copy(taskName = "Fibonacci Recursion")

//---------------------------------------------------
/** 4) Use the ".toString" method to print all parameter of the instance you have already created for exercise 3 */
createClassesTime.toString
dataTypesIncomplete.toString
renameFibSeq.toString

//---------------------------------------------------
/** 5) Use the ".equals" method to compare case class instances you have already created as a part of the exercise so far */
// .equals acts the same as == . They both compare the values in the object not the memory space
val testCopy: afterNoonTask = createClasses.copy()
testCopy.equals(createClasses)
createClasses.equals(createClassesTime)

//---------------------------------------------------
/** Research */
//---------------------------------------------------

//---------------------------------------------------
/** 1) We discussed about .copy, .toString, and .equals methods but there are a lot of available. Try to find as many as possible and apply them*/
/**
 * apply: Factory method to create instances.
 * unapply: Method for pattern matching.
 * copy: Method to create a modified copy of an instance.
 * equals: Structural equality check.
 * hashCode: Hash code generation based on fields.
 * toString: String representation of the instance.
 * productArity: Number of fields in the case class.
 * productElement: Access individual fields by index.
 * productIterator: Iterate over all fields.
 * productPrefix: Name of the case class.
 * eq: Checks if the references are the same
 */

case class classMethodTesting(val test1: String)

/** --> Apply - Factory method to create an instance */
val testObjApply: classMethodTesting = classMethodTesting.apply(test1 = "test")
val testObjNoApply: classMethodTesting = classMethodTesting(test1 = "test")


/** --> Unapply - Allows you to destructor the values from an object (returns an option). Often used for match */

// Define the case class
case class Person(name: String, age: Int)

// Create an instance of the case class
val person = Person("Alice", 30)

// Explicitly use the unapply method
val extracted = Person.unapply(person)
val value = extracted.getOrElse()
println(value)

/** --> Copy - Returns an exact copy of the object it is called on with any variable changed */
val personOlder = person.copy(age = 31)


/** --> Equals - Checks the values of one object against another to see if they are the same */
val personExactCopy = person.copy()

//Not Equal
person.equals(personOlder)

//Equal
person.equals(personExactCopy)

/** --> Hashcode - Prints a hashcode i.e. a integer value associated with the object  */
person.hashCode

/** --> toString - produces a string representation of the object and its values*/
person.toString

/** --> productArity - returns the number of elements in the case class */
person.productArity

/** --> productElement - returns the nth elements of the case class where n is 0 based*/
person.productElement(0)
person.productElement(1)

/** --> productIterator - returns an iterator over all the elements of a case class*/
person.productIterator.foreach(println)


/** --> productPrefix - returns the name of the case class*/
person.productPrefix


/** --> Eq - Checks if the references are the same */
chocolateMuffin.eq(anotherChocolateMuffin)
chocolateMuffin.eq(chocolateMuffin)

////---------------------------------------------------
/** 1) What is the difference between == and .equals? why? *

 "==" Operator:
Defined in Scala's Any class.
 Checks for structural equality.
 Handles nulls gracefully.
 Delegates to .equals for non-null references.

 .equals Method:
 Inherited from Java's Object class.
 Default implementation checks for reference equality.
 Can be overridden for custom equality logic (as in case classes).
 Does not handle nulls gracefully if called on a null reference.

 .eq Method:

 Checks if the reference is the same
 */
////---------------------------------------------------
///** ---------> */
