package Week7.Variance

object Variance extends App {

/** -------------> Covariance [+T] <------------- */

/** SuperClass of coffee */
  abstract class Coffee {
    def name: String
  }

/** Sub classes of coffee:
 * Needs a name to satisfy the SuperClass
 */

case class Standard (name: String) extends Coffee
case class Fancy (name: String) extends Coffee

  // Class List is [+A] i.e. it is covariant by default:
def coffeeMenu(coffees: List[Coffee]): String = {
  coffees.foreach{
    coffee => println(coffee.name)
  }.toString
}


  val standardCoffeeMenu: List[Standard] = List(Standard("Latte"), Standard("Americano"), Standard("Cappuccino"))
  val fancyCoffeeMenu: List[Fancy] = List(Fancy("OatLatte"), Fancy("VanillaCappuccino"), Fancy("CoconutChai"))

  println("Standard coffee menu:") + coffeeMenu(standardCoffeeMenu)
  println("Fancy coffee menu:") + coffeeMenu(fancyCoffeeMenu)

  // We can pass in subclasses where the superClass is expected - Covariance
  // It is helpful for type safety

  /** -------------> ContraVariance [-T] <------------- */
  /** Contravariance [-T] */

  abstract class SummerActivity[-T] {
    def printValue(value:T): String
  }
  //Super-class
  abstract class Festival {
    def name: String
  }

  //sub-class of Festival
  case class MusicFestival(name:String) extends Festival

  //sub-class of SummerActivity
  class Glastonbury extends SummerActivity[Festival] {
    override def printValue(festival: Festival): String = festival.name
  } //This class can handle any type of festival.

  class Reading extends SummerActivity[MusicFestival] {
    override def printValue(musicFestival: MusicFestival): String = musicFestival.name
  } //This class can only handle MusicFestival. This class is far more specific that Glastonbury class.

  val newMusicFestival:MusicFestival = MusicFestival("New Music Festival")

  def printNewFestival(summerActivity: SummerActivity[MusicFestival]): String = {
    summerActivity.printValue(newMusicFestival)
  }

  val festival1: SummerActivity[Festival] = new Glastonbury //Valid. Same type.
  val festival2: SummerActivity[MusicFestival] = new Glastonbury //Valid. Glastonbury has type SummerActivity[Festival] and due to contravariance, it's compatible with the sub-type SummerActivity[MusicFestival].
  // val festival3: SummerActivity[Festival] = new Reading //Not valid. Reading has type SummerActivity[MusicFestival] and this is a sub-type of SummerActivity[Festival]. I cannot pass a sub-type in where a super-type is expected.
  val festival4: SummerActivity[MusicFestival] = new Reading //Valid. Type match.

  println(printNewFestival(festival1))
  println(printNewFestival(festival2))
  println(printNewFestival(festival4))

  /** -------------> Invariance [T] <------------- */
// Invariance cannot substitute its type

  // Mutable box should be mutable, the moment you give it type T it makes it immutable
  // Something very structured and rigid use invariance

  //  We are saying this box is invariant i.e. it will only be type T

  class Box[T] (var contentOfBox: T) // a generic class that holds a value of type 'T' in its contentOfBox parameter

  // Super class
  abstract class Fruit {
    def variety: String
  }

  // Secondary Class
  case class Apple(variety: String) extends Fruit
  case class Orange(variety: String) extends Fruit
  // NOTE: Apple and orange are subtypes of Fruit

  // Invariant box is of type Apple and has an apple
  val appleBox: Box[Apple] = new Box[Apple](Apple("Gala"))
  val orangeBox: Box[Orange] = new Box[Orange](Orange("Naranja"))

//  val fruitBox: Box[Fruit] = appleBox // required Box of Fruit, Apple and Orange should be a valid type but they are not
//  val fruitBox2: Box[Fruit] = new Box[Apple](Apple("Gala"))
  val fruitBox3: Box[Fruit] = new Box[Fruit](Apple("Naranja"))


  class Box2[Fruity] (var contentOfBox: Fruity) // a generic class that holds a value of type 'T' in its contentOfBox parameter

  // Super class
  abstract class Fruity {
    def variety: String
  }

  // Secondary Class
  case class Appley(variety: String) extends Fruity
  case class Orangey(variety: String) extends Fruity
  // NOTE: Apple and orange are subtypes of Fruit

  // Invariant box is of type Apple and has an apple
  val appleyBox: Box[Apple] = new Box[Apple](Apple("Gala"))
  val orangeyBox: Box[Orange] = new Box[Orange](Orange("Naranja"))

//  val fruityBox: Box[Fruit] = appleBox // required Box of Fruit, Apple and Orange should be a valid type but they are not
//  val fruityBox2: Box[Fruit] = new Box[Apple](Apple("Gala"))
  val fruityBox3: Box[Fruit] = new Box[Fruit](Apple("Naranja"))

}
