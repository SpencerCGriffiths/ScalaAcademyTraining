/** Case Classes */

// These are a very helpful tool that has been introduced by Scala
// Classes are blueprints, they tell us how to make something. Whereas case classes model immutable data
// unlike classes, we don't need to use the 'new' keyword when instantiating a new object
// We are provided with a lot of boilerplate code

/**
 * Extra Methods built in to Case classes:
 * apply
 * unapply
 * hashcode and equals method
 * copy method
 * toString method
 * ...
 */

//class SuperHero(realName: String, heroName: String, weakness: String)
//SuperHero // Cannot call the class, have to make an object first
//
case class SuperHero1(realName: String, heroName: String, weakness: String)
//SuperHero1.apply() // As a super class we can call methods straight on the class


//---------------------------------------------------
/** ---------> Creating an Object with Case Classes */
//Apply-
//A Constructor method- used to make our objects
val newSuperHero: SuperHero1 = SuperHero1.apply(realName = "clarke Kent", heroName = "Superman", weakness = "Kryptonite")


// Or write it out as we have done previously
// Don't need to use the keyword new!
val anotherNewSuperhero: SuperHero1 = SuperHero1(realName = "clarke Kent", heroName = "Superman", weakness = "Kryptonite")


//---------------------------------------------------
/** ---------> Direct Comparison on Case Classes */

// Direct comparison checks what the values are within the object, not comparing the name.
newSuperHero == anotherNewSuperhero

//---------------------------------------------------
/** ---------> Copy Method */

// Copy method allows you to make an exact copy of the object changing any values
// Copy method does not mutate/Alter in place but returns the new object

val updateName = anotherNewSuperhero.copy(realName = "john snow")
//---------------------------------------------------
/** ---------> Case Class Task*/

// 1. Create a dog case class with params of name, breed and age

case class Dog(val name: String, val breed: String, val age: Int)

// 2. Create 4 dog objects
val fido: Dog = Dog(name = "Fido", breed = "Jack Russel", age = 4)
val bear: Dog = Dog.apply(name = "Bear", breed = "Chow Chow", age = 6)
val yaps: Dog = Dog(name = "Yaps", breed = "Chihuahua", age = 8)
val john: Dog = Dog.apply(name = "John", breed = "Rottweiler", age = 9)

// 3. Then create a kennel case class with parameter of name and then a list of the dog case class

case class Kennel(val name: String, val dogCaseClass: List[Dog])

//3. Make a new kennel object and add your dogs

val steveKennel: Kennel = Kennel(name = "Steve's Dogs", dogCaseClass = List(fido, bear, yaps, john))


//4 The kennel that you have set up want to change its name but keep the dogs. Use the case class copy method.

steveKennel.copy(name = "Steve's Sanctuary")

//6 The kennel wants to expand to accept cats and birds as well
// Update the kennel case class
// Create a bird and cat case class using some creative parameters

// make bird case class
// make cat case class
// make a new kennel case class / extend the current

//7 The kennel often gets a new dog/cat/bird joining. Add one of each to the kennel in a reusable way (a method)

//---------------------------------------------------
/** ---------> Case Objects */

// A case object is like an object but far more powerful due to built in methods
// They are used when we need an immutable object

case object Hulk
Hulk.getClass

// These are used for exhaustive matching:
// Real world would be VAT and PAYE service


