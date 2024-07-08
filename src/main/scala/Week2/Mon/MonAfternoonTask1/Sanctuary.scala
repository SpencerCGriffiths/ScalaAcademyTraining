package Week2.Mon.MonAfternoonTask1

object Sanctuary extends App {

  def feedAnimal(animal: Animal) = println(s"You fed ${animal.name} some ${animal.dietType.eats}!")

  val hedwigTheSnowyOwl = new Owl("Hedwig", "Snowy Owl", 8, 2, "White", 150)

  val pumbaTheWarthog  = new Warthog("Pumbaa", "Common Warthog", 4, "Brown", true)

  val jeffTheDragonfly  = new Dragonfly("Jeff", "Blue Eyed Darner", 1, 12, 10, 1)

  println(hedwigTheSnowyOwl.hootsPerNight)
  println(hedwigTheSnowyOwl.age)
  println(hedwigTheSnowyOwl.name)
  println(hedwigTheSnowyOwl.speciesName)
  println(hedwigTheSnowyOwl.wingspan)
  println(hedwigTheSnowyOwl.beakLength)
  println(hedwigTheSnowyOwl.featherColour)
  println(hedwigTheSnowyOwl.canFly)



 def getAnimalAge(animal: Animal): Float = {
    val age = animal.age
   age
 }


  println(getAnimalAge(pumbaTheWarthog))

   feedAnimal(hedwigTheSnowyOwl)

}


// You can't use a method at this level in the sanctuary to alter any Val previously declared:

// Example:

// def veryNoisyHewdig(newHoots: Int): Unit = {
//    override val hedwigTheSnowyOwl.hootsPerNight = 3
//     }

//Problems with this implementation:

// 1. Override-
// This is used to redefine a member in a subclass not within a method!

// 2. Val
// Previous Val's cannot be later overridden or mutated

// 1 Solution:
// In the class if you know it will be changed change it to a var and embed a method to make the change:
/**
class Owl (params) extends Bird with Species with Flyable {
  params....
  var hootsPerNight: Int = 12
  def increaseHoots (hoots: Int): Unit = {
    hootsPerNight = hoots
  }
}
 */

// 2 Solution:
// Create a copy constructor or factory method to create a full copy of the instance
/**
 class Owl(
 val name: String,
 val speciesName: String,
 val age: Float,
 val beakLength: Float,
 val featherColour: String,
 val wingspan: Float,
 val hootsPerNight: Int = 12 // Default value for hootsPerNight
 ) extends Bird with Species with Flyable {

 val dietType: DietType = Omnivore
 val conservationStatus: String = "Least Concern"
 val averageLifespanRange: (Double, Double) = (7, 11)
 val numberOfYoungRange: (Int, Int) = (4, 6)

 // Copy method to create a new instance with modified values
 def copy(
 name: String = this.name,
 speciesName: String = this.speciesName,
 age: Float = this.age,
 beakLength: Float = this.beakLength,
 featherColour: String = this.featherColour,
 wingspan: Float = this.wingspan,
 hootsPerNight: Int = this.hootsPerNight
 ): Owl = {
 new Owl(name, speciesName, age, beakLength, featherColour, wingspan, hootsPerNight)
 }
 }

 // Example usage
 val hedwigTheSnowyOwl = new Owl(
 "Hedwig",
 "Snowy Owl",
 5.0f,
 2.3f,
 "White",
 1.5f
 )

 println(hedwigTheSnowyOwl.hootsPerNight) // Output: 12
 val noisyHedwig = hedwigTheSnowyOwl.copy(hootsPerNight = 20)
 println(noisyHedwig.hootsPerNight) // Output: 20
 */