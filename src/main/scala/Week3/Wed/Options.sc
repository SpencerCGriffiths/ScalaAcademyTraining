

/** Options */

/**
 * Often used to replace exceptions that can be thrown when we have parameters that might be present, might not. We don't have to waster time checking for something that isn't there
 * We can pattern match on these too

Think about the pizza restaurant
If the customer doesn't specify their crust, they will have a classic crust by default

case class Pizza (size:Int, crust Option[String])

This results in some or none

Pizza(14, Some("stuffed))
Pizza(14, None)

 */

// trait is easy to extend
// could be a case class
trait Pizza {
  val size: Int
  val crust: Option[String]
}

// They do not have the option of crust in personal pizza
object Personal extends Pizza {
  val size: Int = 7
  val crust: Option[String] = None
}

object SmallClassic extends Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("classic")
}

object smallItalian extends Pizza {
  override val crust: Option[String] = Some("Italian")
  override val size: Int = 9
}

val pizzaOrder: Pizza = new Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("Italian")
}

def whatCrust(pizza: Pizza): String = {
  pizza.crust match {
    case Some("Classic") => "Classic Crust"
    case Some("Italian") => "Italian Crust"
    case Some(x) => s"$x is not a valid crust type"
    case None => "Default Crust - Classic"
  }
}

whatCrust(pizzaOrder)

/** .get */
  // We can get the value of the option.
val getCrust: String = pizzaOrder.crust.get

  // This is bad practice!!!!!
  // Do not do this as if there is a none value it can cause issues

/** .getOrElse */
  // Allows for a default to be given
val getOrElseCrust: String = pizzaOrder.crust.getOrElse("default crust - classic")

// Default goes in the bracket

/** Make a chocolate bar case class with an optional filling
 * Write a method to return the filling of the chocolate bar which if empty will give a default
 * Demonstrate this working by making some chocolate objects
 */

case class ChocolateBar (filling: Option[String])

def getFilling(chocolateBar: ChocolateBar): String = {
  chocolateBar.filling match {
    case Some("Caramel") => "This chocolate is full of caramel"
    case Some("Nougat") => "This chocolate is full of nougat"
    case Some("Wafer") => "This chocolate is full of wafer"
    case Some(x) => s"$x is not a chocolate filling"
    case None => "Default - This chocolate is empty inside"
  }
}

val caramelChoc: ChocolateBar = ChocolateBar(Some("Caramel"))
val nougatChoc: ChocolateBar = ChocolateBar(Some("Nougat"))
val waferChoc: ChocolateBar = ChocolateBar(Some("Wafer"))
val defaultChoc: ChocolateBar = ChocolateBar(None)

val caramelChocFilling: String = getFilling(caramelChoc)
val nougatChocFilling: String = getFilling(nougatChoc)
val waferChocFilling: String = getFilling(waferChoc)
val defaultFilling: String = getFilling(defaultChoc)


