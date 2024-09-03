package Week7.Variance

object Afternoon extends App {

/** 1) Create an abstract Animal Class with fields for Name, and diet */

  abstract class Animal {
    val name: String
    val diet: String
  }

  /** 1a) create some animals that extend this class */
  case class Tiger(name: String, diet: String) extends Animal

  /** 1a) Create an Animal val and assign a more specific animal */
  val tonyTiger = Tiger("Tony", "CornFlakes")

  val animal: Animal = tonyTiger
  /** 1a) why does this compile? */
  // 1A Answer: A Cat is a subtype of Animal as we've extended it, therefore we can assign it to this val without an issue

  /** 2) Some Animals are solitary, Model a generic Solitary class that is invariant in type */
  class Solitary [A]

  /** 2a) create a solitary Cat Val. Try to assign this cat a solitary Animal val */

  case class Cat (name: String, diet: String) extends Animal

  val solitaryCat: Solitary[Cat] = new Solitary[Cat]
//  val solitaryCat2: Solitary[Animal] = solitaryCat

  /** 2a) Why does this not compile?*/
  // 2A Answer: We've said Solitary is invariant in A so Solitary[Cat] and Solitary[Animal] are 2 completely different
  // types. It would like were were assigning a String to an val x: Int

  abstract class SolitaryCo [+Animal]
  case class CatCo (name: String, diet: String) extends SolitaryCo
  val solitaryAnimalCo: SolitaryCo[Animal] = CatCo("HissHiss", "Mice")

  /** 3) Some animals like to travel in pairs (swans). Create a generic Pair class that is covariant in type  */

  abstract class Pair [+Animal]

  case class Swans(names: String, diet: String) extends Pair

  /** 3a) Create a val of a pair of swans (val SwanPair: Pair[Swan]) try to assign this val to a pair of Animals*/
  val SwanPair: Pair[Swans] = Swans("Bert and Ernie", "Children's ankles")

  /** 3a) Will this compile or not*/
  // Yes because as it is covariant in type Swans can satisfy the type Animal required by Pair


  /** 4) Sometimes these animals need a person to feed them. Were not concerned about what animals they can feed. Model a generic abstract Feeder class that is contravariant, in its type and has a feedAnimal method */

  abstract class Feeder [-A] {
    def feedAnimal(a:A): Unit = println("Feeding an animal")
  }

  /** 4a) Create an Animal Feeder try to assign this val to a Dog Feeder*/

  val animalFeeder: Feeder[Animal] = new Feeder[Animal] {
    override def feedAnimal(a: Animal): Unit = println(s"Fed ${a.name} some ${a.diet}")
  }

  case class Dog(name: String, diet: String) extends Animal
  val dog: Animal = Dog("Woof", "Beef")

  val dogFeeder: Feeder[Dog] = new Feeder[Dog] {

  }

  /** 3a) */
  /** 3a) */
}
