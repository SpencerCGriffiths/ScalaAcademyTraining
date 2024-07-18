import javax.management.Notification

// Pattern matching a Val:

val weather = "cold"

// If Else Statement
if (weather == "cold") {
  println(s"It is $weather take a coat")
} else if (weather == "hot") {
  println(s"It is $weather were sunglasses")
} else {
  println(s"It is anything but hot or cold so good luck :)")
}


// Match Case Statement
weather match {
    case "cold" => println(s"It is $weather take a coat")
    case "hot" => println(s"It is $weather were sunglasses")
    case _ =>  println(s"It is anything but hot or cold so good luck :)")
}


// Make it case sensitive:
weather.toLowerCase() match {
  case "cold" => println(s"It is $weather take a coat")
  case "hot" => println(s"It is $weather were sunglasses")
  case _ =>  println(s"It is anything but hot or cold so good luck :)")
}

// Pattern Matching an Int

val numOfWatermelons = 3
val hasBag = true

// else if:
if (numOfWatermelons < 0) {
  println(s"Go home John there's magic happening... RUN")
} else if (numOfWatermelons == 0) {
  println(s"Go home John, all sold out of watermelons here mate")
} else if(numOfWatermelons <= 3) {
  println(s"John can carry all $numOfWatermelons without a bag")
} else if ( numOfWatermelons <= 5 && hasBag) {
  println(s"John you can carry all $numOfWatermelons with a bag, well done for bringing one")
} else if ( numOfWatermelons <= 5 && !hasBag) {
  println(s"Sorry John forgot your bag for life so you can't manage $numOfWatermelons watermelons")
} else if ( numOfWatermelons > 5 ) {
  println(s"Don't be greedy now John, $numOfWatermelons is too many")
} else {
  println("The given value is not valid for this condition")
}


//Match (switchCase):
numOfWatermelons match {
  case 0                            =>  println(s"Go home John, all sold out of watermelons here mate")
  case 1 | 2 |  3                   =>  println(s"John you can carry all $numOfWatermelons without a bag")
  case 4 | 5               =>  println(s"John you can carry all $numOfWatermelons with a bag, well done for bringing one")
  case _                            =>  println("The given value is not valid for this condition")
}


//If guards:
// Using if guards (embedding an if in the pattern match)
numOfWatermelons match {
  case x if x < 0               =>  println(s"Go home John there's magic happening... RUN")
  case x if x == 0              =>  println(s"Go home John, all sold out of watermelons here mate")
  case x if x <= 3              =>  println(s"John you can carry all $numOfWatermelons without a bag")
  case x if x <= 5 && hasBag    =>  println(s"John you can carry all $numOfWatermelons with a bag, well done for bringing one")
  case x if x <= 5 && !hasBag   =>  println(s"Sorry John, forgot your bag for life so you can't manage $numOfWatermelons watermelons")
  case x if x > 5               =>  println(s"Don't be greedy now John, $numOfWatermelons is too many")
  case _                        =>  println("The given value is not valid for this condition")
}


// Matching of Objects - Match exhaustive

sealed trait Temperature
// sealed trait - can only be extended from within the same file that it is defined in.
// We will get a compilation error if we don't have an exhaustive match


object Cold extends Temperature
object Hot extends Temperature
object Mild extends Temperature

// Weather is now a instance of Cold object
val weather: Temperature = Cold

weather match {
  case Cold => "Take a coat"
  case Hot => "Wear suncream"
  case Mild => "A light jacket"
 case _ => "Not valid"   // Using sealed trait you can remove wildcard as it has finite options
}

// Having a wild card as sealed it will be happy as it will catch
// if we remove the wild card it will give the error and show that it is not exhaustive.


// SEALED TRAITS
// sealed traits can only be extended in the file!- You know it can only be found in that file
// sealed traits throw compilation error if exhaustive match not exhaustive



// Matching using classes

abstract class Notification
// abstract class - don't want to make an instance just want to extend
// Cannot be instantiated- Must be extended

case class Email (sender: String, title: String, body: String) extends Notification
// case class- Adds extra methods and functionality

case class SMS (caller: String, message: String) extends Notification
case class VoiceRecording (contactName: String, link: String) extends Notification

// imagine there is a notification coming in
val notification: Notification = SMS("Mum", "Are you home?")

notification match {
  case Email(sender, title, body) => "Email from " + sender + "Title: " + title
  case SMS(caller, message) if caller == "Mum" => "SMS from " + caller + ". Don't ignore"  //-Adding an if Guard
  case SMS(caller, message) => "SMS from: " + caller
  case VoiceRecording(contactName, link) => "Recording from: " + contactName + "With link: " + link
  case _ => "Not Valid"
}

// --------------------------------------------------------------------------------------
/** ----> Task 1 */
// Accept a string for a flavour/topping and return a different type of pizza for each one:
// E.g Spicy -> American Hot
// What are we going to do about unknown flavours?

sealed trait Pizza

object Spicy extends Pizza
object Meaty extends Pizza
object Vegan extends Pizza

val myPizza: Pizza = Spicy

myPizza match {
  case Spicy => "American Hot"
  case Meaty => "Meat Planet"
  case Vegan => "No Cheese Special"
  case _     => "thats not a valid pizza option"
}

//// --------------------------------------------------------------------------------------
///** ----> Task 2 */
///** Accept Pizza Measurements for sizes 7= Personal, 9=Small, 11=Medium, 14= Large */
//
//sealed trait Pizza
//
//object Spicy extends Pizza
//object Meaty extends Pizza
//object Vegan extends Pizza
//
//val myPizza: Pizza = Spicy
//
//myPizza match {
//  case Spicy => "American Hot"
//  case Meaty => "Meat Planet"
//  case Vegan => "No Cheese Special"
//  case _     => "thats not a valid pizza option"
//}
//
//val pizzaSize: Int = 7
//
//pizzaSize match {
//  case 7 => "Personal"
//  case 9 => "Small"
//  case 11 => "Medium"
//  case 14 => "Large"
//}
//
//// --------------------------------------------------------------------------------------
///** ----> Task 2b */
///** Make a Pizza case class that accept price and crust parameters. Now match off all the possible options and return the price of the pizza
// * Personal £5.99: classic
// * Small £10.99: classic, italian
// * Medium £12.99: classic, italian, stuffed (+ 2.99)
// * Large £ 14.99: classic, italian, stuffed + (+ 2.99) */
//
//case class PizzaPizza (price: Int, crustParameter: String)
//
//val pizzaToMatch: PizzaPizza = PizzaPizza(5, "stuffed")
//
//pizzaToMatch match {
//  case
//}
//
//// Have them all as case class with inputs