package Week1.Fri.AfternoonTaskAnswers

sealed trait DietType {
  val eats: String
}

object Omnivore  extends DietType {
  val eats: String = "Plants and Meat" 
}
object Carnivore extends DietType {
  val eats: String = "Meat" 
}
object Herbivore extends DietType {
  val eats: String = "Plants" 
}