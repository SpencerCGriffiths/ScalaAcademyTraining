/** Classes */
// Capital for the name
// declare using 'class'
// act as blueprints

// First way - unimplemented members
class ThemeParkEmptyParams (val hasRollerCoasters: Boolean, val diameterOfLargestLoop: Double)

// Second way - implement members
// {} braces used here
// default params
class ThemeParkDefaultParams {
  val hasRollerCoasters: Boolean = true
  val diameterOfLargestLoop: Double = 30.24
}

//Implemented Members: These are methods or fields that have a complete definition within the class or trait.

//Unimplemented Members: These are abstract methods or fields that do not have a definition and must be implemented by subclasses or implementing classes.
// Example:
trait Animal {
  // Implemented member
  def eat(): Unit = {
    println("Eating")
  }

  // Unimplemented member
  def makeSound(): Unit
}

// Define a class that extends the trait and implements the unimplemented member
class Dog extends Animal {
  // Implement the unimplemented member
  def makeSound(): Unit = {
    println("Woof!")
  }
}

// Create an instance of the class and call the members
val dog = new Dog
dog.eat()       // Output: Eating
dog.makeSound() // Output: Woof!


// Everything inside {} belongs to that class. Known as members of the class.

class ThemeParkBoth (val diameterOfLargestLoop: Double){
  val hasRollerCoasters: Boolean = true
}

// Use classes to make objects.

/** Objects */
//Keyword - new
// Capital

// Prior:
// class ThemeParkEmptyParams (val hasRollerCoasters: Boolean, val diameterOfLargestLoop: Double)

//Empty params
val mercatorPark: ThemeParkEmptyParams = new
    ThemeParkEmptyParams(hasRollerCoasters = true, diameterOfLargestLoop = 7.95)
mercatorPark.getClass
mercatorPark.hasRollerCoasters

// Default params
//class ThemeParkDefaultParams {
//  val hasRollerCoasters: Boolean = true
//  val diameterOfLargestLoop: Double = 30.24
//}
val disneyWorld: ThemeParkDefaultParams = new ThemeParkDefaultParams()
disneyWorld.diameterOfLargestLoop

/** Parameters */
// Meaningful name
// raw values or existing vals can be passed in

class Hamster (age: Int, colour: String)
val orange: String = "Orange"
//make the Hamster object
val BooTheHamster: Hamster = new Hamster(age = 1, colour = orange)

/** Objects without classes */
// When we only need 1 of something.
// Don't use the new keyword.
// Have no params.
// Available globally.

object DavidsDogs {
  val Loki: String = "Loki"
  val Tayamul: String = "Tayamul"
  val Isla: String = "Isla"
  val Bilal: String = "Bilal"
  val Oscar: String = "Oscar"
}
DavidsDogs.Loki

/** Inheritance */
// use the 'extends' keyword
// declare the class we want to extend
// class we extend from is called the 'parent' or the 'superclass'
// Can only extend 1 class.

class Bakken1 extends ThemeParkDefaultParams {
  override val diameterOfLargestLoop: Double = 20.15
  val oldestThemePark: Boolean = true
}

val printBakken: Bakken1 = new Bakken1

class Bakken extends ThemeParkEmptyParams (hasRollerCoasters = true, diameterOfLargestLoop = 20.15) {
  val oldestThemePark: Boolean = true
}

/** Family tree task */

class Person (firstName: String) {
  val surname: String = "Smith"
}

class Dad extends Person ("Steve")

class girlFriend extends Person ("Jess") {
  override val surname: String = "Jones"
}

/** Traits */
// Keyword - with
// extend multiple traits
// traits can have unimplemented members
// we cannot create an instance of a trait (like we can a class)
// use in combination with something else

trait Mascot {
  val nameOfMainCharacter: String
}

trait OversizedFood {
  val hugeTurkeyLeg: Boolean
}

class DisneyWorld extends ThemeParkDefaultParams with Mascot with OversizedFood {
  override val nameOfMainCharacter: String = "Mickey"
  override val hasRollerCoasters: Boolean = false
  override val hugeTurkeyLeg: Boolean = true
}

val disneyWorld1 = new DisneyWorld

disneyWorld1.hugeTurkeyLeg
disneyWorld1.diameterOfLargestLoop



