package Week1.Fri.AfternoonTaskAnswers

trait Species {
  val speciesName: String
  val conservationStatus: String
  val averageLifespanRange: (Double, Double)
  val numberOfYoungRange: (Int, Int)
  val dietType: DietType
}
