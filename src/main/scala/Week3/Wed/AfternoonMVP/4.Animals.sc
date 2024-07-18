/** Create an animal that can then be extended by instances of animals
 * Create different types of Animals that extend Animal
 * - Hint How can you make a trait that allows for exhaustive pattern matching?
 * Using pattern matching return a string with a facts about that animal e.g. Pig -> "Can Fly"*/

sealed trait Animal

case object pig extends Animal

case class piggy() extends Animal
