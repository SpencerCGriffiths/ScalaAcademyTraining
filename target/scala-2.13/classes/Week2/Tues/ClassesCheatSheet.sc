/** With parentheses () */

//--------> Construct with no defined parameters:

class Park1

// Make object
new Park1

// This is now an object. Not a lot cannot be done because it has no parameters to use or manipulate

//---------------------------------------------------
//--------> Construct with defined parameters

// We are not giving default values
// We do not have to put val/var (but it is best practice to include)

class Park2(val rollerCoaster: Boolean, val largestLoop: Double)

// Make object
new Park2(true, 4.5) // This works but how would someone know what true or 4.5 relate to
new Park2(rollerCoaster = true, largestLoop = 4.5) // This is more verbose and avoids later confusion

// Extend Park2 Class as an object- must enter values because they are not default:

object Disney extends Park2 (rollerCoaster = true, largestLoop = 4.5)


//---------------------------------------------------
//--------> Abstract

// If we are not giving default values, but are setting defined parameters, might as well make it abstract
// Making it abstract acts as a safety net.
// It will force the developer to enter values sooner and not compile without them.

abstract class Park3(val coaster: Boolean, val Loop: Double)

//Make an object
new Park3() // Cannot make an object from abstract class with ()

// Object can be made with {} as later noted
val y = new Park3(true, 4.5) {}
println(y.coaster)

//---------------------------------------------------
//--------> Constructing with Default Parameter

// Set default values if they are unlikely to change

class Park4(val coaster: Boolean = true , val loop: Double = 4.7)

//Make an object
new Park4 // This object will use the default values
// Do not need to use the keyword override or val or var
new Park4(coaster = false) // You can override the default values


/** Curly Braces */
//---------------------------------------------------
/**--------> No Defined Parameter {}*/


class Park5{}

//Make Object
new Park5

//---------------------------------------------------
/**--------> Constructed with defined parameters (not with defaults) {}*/

// With curly braces we cannot make a class that has defined non default values
class Park6{
  val coaster: Boolean
  val loop: Double
}

// It either needs to be abstract or have defaults

//---------------------------------------------------
/**--------> Construct with default params {} */


class Park7 {
  val Coaster: Boolean = true
  val Loop: Double = 5.6
}

// In {} you must declare val or var unlike in ()
// i.e.
//class Park7 {
//   coaster: Boolean = true
//   Loop: Double = 5.6
//}

// Make an object
new Park7 // Default values so it is accepted

new Park7 {
  override val Coaster: Boolean = false
} // In order not to use default values you have to override


// We can extend the class
object Legoland extends Park7
Legoland.Loop

// We can override the default val
object Legoland2 extends Park7 {
  override val Loop: Double = 7.6
}

//---------------------------------------------------
/**--------> Abstract Class {} */


abstract class Park8{
  val coaster: Boolean
  val loop: Double
}

// Make object
new Park8 {
  val coaster: Boolean = true
  val loop: Double = 4.5
}

//---------------------------------------------------
 /**--------> Extending Classes to make objects */

//When extending abstract class - must give a value to every parameter(even if it has a default)

object HydePark extends Park8 {
  override val coaster: Boolean = true
  override val loop: Double = 4.5
}


abstract class Park9(val coaster: Boolean, val loop: Double)
//Make an object
new Park9(coaster = false, loop = 5.7) // Cannot make an object just using rounds

// Extend the class we can make an object
object AnotherNewPark extends Park9(coaster = true, loop = 4.5)


//---------------------------------------------------
/**--------> What is accessible*/

// We can access the params/attributes only if they were declared as val or var.
// Comment out val in line 138 and it becomes inaccessible

AnotherNewPark.coaster
AnotherNewPark.loop


//---------------------------------------------------
/** -----------> () & {} */
class Park10 (val coaster:Boolean) {
  val loop: Double = 7.6
}

new Park10 (coaster = true)

/** TRAITS */

//---------------------------------------------------
/** ---------> without defaults */

trait CandyFloss {
  val hasCandyFloss: Boolean
}

// This trait has a defined value but not a default
// Everytime we use it we have to give a defined value


object AnotherNewPark2 extends CandyFloss {
  override val hasCandyFloss: Boolean = true
}




//---------------------------------------------------
/** ---------> with defaults */

trait CandyFloss1 {
  val hasCandyFloss: Boolean = true
}

// Make an object extending Candyfloss1
object AnotherNewPark3 extends CandyFloss1


// Make an object extending CandyFloss1 overriding values
object AnotherNewPark3 extends CandyFloss1 {
  override val hasCandyFloss: Boolean = false
}

//---------------------------------------------------
/** ---------> Sealed Keyword */
// Can only access in the same file and cannot import it in to another file
// Allows for safety as it is all in one place

sealed abstract class AbstractSealedClass

sealed class SealedClass

sealed trait SealedTrait

// allows for exhaustive matching (to be continued ........)




//---------------------------------------------------
/** --> Additional */

/**
 * ()
 * class ClassName(args) passes the args to the constructor
 * The constructor is a method that scala makes for you that has all the information to make the object from the class
 * When you use -> new ClassName(args) <- under the hood you are calling the constructor that exists in that class and passing the arguments
 *
 * {}
 * new ClassName{} makes an "anonymous subclass"
 * I am not entirely sure what an anonymous subclass is
 * when you call
 *  */
