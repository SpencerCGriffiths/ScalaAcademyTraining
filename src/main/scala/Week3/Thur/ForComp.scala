package Week3.Thur

case object ForComp extends App {

  // <- Backwards arrow is calling something

  /** Classic approach */

  // Classic simple
  def retrieveNums(): Seq[Int] = for (nums <- 1 to 10 ) yield nums
  println(retrieveNums())

  // further logic after the yield
  def squareNums(): Seq[Int] = for (nums <- 1 to 10 ) yield nums * nums
  println(squareNums())

  // if guards
  def ifGuardNums(): Seq[Int] = for (nums <- 1 to 10  if nums % 2 == 0) yield nums
  println(ifGuardNums())

  /** use with case classes */

  sealed trait Colour
  // sealed- do not want outside the file
  // making a trait to group some colours together
  // do not need the added case class functionality

  case object Blue extends Colour
  case object Green extends Colour
  case object Red extends Colour

  case class Pencil(colour: Colour, sharpened: Boolean)

  def getPencils: List[Pencil] = for {
    colour <- List(Blue, Green, Red) // <--- This is all colour options
    sharpened <- List(true, false) // <--- This is all sharpened types
  } yield Pencil(colour, sharpened) // <--- This yield is checking all possible conditions and creating a pencil

  println(getPencils)


  // This doesn't have to be exhaustive
  def getTruePencils: List[Pencil] = for {
    colour <- List(Blue, Red) // <--- This is all colour options
    sharpened <- List(true) // <--- This is all sharpened types
  } yield Pencil(colour, sharpened) // <--- This yield is checking all possible conditions and creating a pencil

  println(getTruePencils)


  /** ENUMS and companion object */
  sealed trait Colour1

  object Colour1 {
    case object Blue extends Colour
    case object Green extends Colour
    case object Yellow extends Colour

    val values: List[Colour] = List(Blue, Green, Yellow)
  }

  case class Pencil1(colour: Colour, sharpened: Boolean)

  def getPencils1: List[Pencil] = for {
    colour <- Colour1.values
    sharpened <- List(true, false)
  } yield Pencil(colour, sharpened)

  println(getPencils1)

  /** Task 1 */
  /** Write a simple method that contains a for comprehension. This method will take in a list of names and return the list all in capitals*/

  def capitalise(names: List[String]): List[String] = for (name <- names ) yield name.toUpperCase()
  println(capitalise(List("john", "steve", "alexander", "karla", "sandra")))

  def capitalisev2(names: List[String]): List[String] = for {
    name <- names.map(x => x.toUpperCase())
  } yield name

  println(capitalisev2(List("john", "steve", "alexander", "karla", "sandra")))

  /** Task 2 */
  /** Duplicate and refactor the method from task 1 so that only the first letter of each name is capitalised*/
  def capitaliseFirst (names: List[String]): List[String] = for (name <- names ) yield name.head.toString.toUpperCase() + name.tail.toLowerCase()
  println(capitaliseFirst(List("john", "steve", "alexander", "karla", "sandra")))

}
