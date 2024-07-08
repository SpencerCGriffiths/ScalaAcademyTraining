//Notes

//Syntax
class Hamster ( val age: Int, val colour: String)
val orange: String = "Orange"
val BooTheHamster : Hamster = new Hamster(1, orange)

// When you only need one instance you can make an object instead of a class
// We can call the values of the object with ObjectName.valName

// Objects have no parameters and are available globally

object MathmaticalConstants {
  val pie: Double = 3.14159
  val e: Double = 2.718281
  val goldenRation: Double = 1.618
  val euler: Double = 0.57721
}

println(MathmaticalConstants.euler)


//Inheritance:
// When extending a class the members can be inherrited
// extends keyword
// class that extended is the parent or superclass


// a family has a surname, there are parents, they have children, child grows and gets a girlfriend who is then married,

//Superclass (Smiths)
// Parents Extend Smiths (i.e. they inherit all smith traits
// Child Extends Parents(inherits all smith traits and parent traits)
// Wife Extends Child(inherits everything from them)
// Other family extend Superclass etc

class Smith (){

}

class MaryAndJohnSmith extends Smith () {

}

class MandJchild extends Smith (){

}

class wifeOfChild extends Smith () {

}

class OtherParents extends Smith () {

}

//Traits

// Need to look at this closer


//
/**
Afternoon Task:

Imagine you're modelling an animal sanctuary in code. What type of Scala constructs would you use? represent this in scala.

*/

// Animal(name String age Int) as a superclass
// Mammal(furColour String, hasTail Bool) extends animal
// Warthog(hasTusks) extends Mammal


// Bird extends animal
// Owl extends Bird

// Insect extends animal
// Dragonfly extends Insect

abstract class Animal (val name: String, val age: Int)



class Mammal2 (name: String, age: Int, val furColour: String, val hasTail: Boolean) extends Animal (name, age)

abstract class Animal2 {
  val name: String
  val age: Int
}


abstract class Mammal3 extends Animal2 {
  val furColour: String
  val hasTail: Boolean = true
}

//val testMammal: Mammal3 = new Mammal3 {
//  override val furColour: String = ???
//  override val name: String = ???
//  override val age: Int = ???
//}


abstract class Mammal(name: String, age: Int, val furColour: String, val hasTail: Boolean) extends Animal (name, age)

//val steveMammal: Mammal = new Mammal("Steve", 5, "Brown", true)
//println(steveMammal.name)
//println(steveMammal.age)
//println(steveMammal.furColour)
//println(steveMammal.hasTail)

class Warthog(name: String, age: Int, furColour: String, hasTail: Boolean, val hasTusks: Boolean) extends Mammal2 (name, age, furColour, hasTail)

val steveWarthog: Warthog = new Warthog("Steve", 5, "Brown", true, true)

println(steveWarthog.name)
println(steveWarthog.age)
println(steveWarthog.furColour)
println(steveWarthog.hasTusks)
println(steveWarthog.hasTail)


abstract class Pet (name: String) {
  def speak: Unit = println(s"My name is $name")
}

class Dog(name: String) extends Pet(name)

val d = new Dog("Fido")
d.speak


// extends classes