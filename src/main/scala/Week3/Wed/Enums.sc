

// Enumeration

// Useful when representing finite sets of data
// There are so many ways to write these, from native enumeration to sealed case objects!

// Good for finite sets of data
// Helps with exhaustive matching

// --------------------------------------------------------------------------------
/** --> Native */
// Two ways to do it:
//Way one:
object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

Weekday.Monday.toString

//Way Two:
// Good for acronyms*
// Gives the value a different name that we are assigning

object BetterWeekday extends Enumeration {
  val Monday = Value("Mon")
  val Tuesday = Value("Tue")
  val Wednesday = Value("Wed")
  val Thursday = Value("Thur")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")
}

BetterWeekday.Saturday // Prints the acronym
Weekday.values // Full Value Set

// They are inherently ordered by index position
Weekday.Monday < Weekday.Sunday // true as 0 is less than 6

// We can change the order if we want to using Int, Int will relate to index position
object ReorderWeekday extends Enumeration {
  val Monday = Value(1)
  val Tuesday = Value(2)
  val Wednesday = Value(3)
  val Thursday = Value(4)
  val Friday = Value(5)
  val Saturday = Value(6)
  val Sunday = Value(0)
}

// Sunday now comes first as it is index position 0
ReorderWeekday.values

// You can also reorder it and keep strings:
object ReorderWeekday2 extends Enumeration {
  val Monday = Value(1, "Mon")
  val Tuesday = Value(2, "Tue")
  val Wednesday = Value(3, "etc")
  val Thursday = Value(4, "etc")
  val Friday = Value(5, "etc")
  val Saturday = Value(6, "etc")
  val Sunday = Value(0, "etc")
}

//------------------------------------------------------------------
/** --> Exhaustive Matching */
/** Exhaustive Matching with Enumeration */

def exhaustiveMatch(weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "Yay its Mon"
    case BetterWeekday.Tuesday => "Tue"
    case BetterWeekday.Wednesday => "Wed"
    case BetterWeekday.Thursday => "Thur"
    case BetterWeekday.Friday => "Fri"
    case BetterWeekday.Saturday => "Sat"
    case BetterWeekday.Sunday => "Sun"
  }
}

exhaustiveMatch(BetterWeekday.Monday) // returns Yay its Mon

// Be careful about non exhaustive matching
def nonexhaustiveMatch(weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "Mon"
    case BetterWeekday.Tuesday => "Tue"
  }
}


/** ENUMS DON'T COME WITH MUCH BOILER PLATE CODE.*/
/** SEALED CASE OBJECTS ARE THE WAY TO GO */

//-------------------------------------------------------------------
/** -->> Sealed Case Objects */

sealed trait Weekday
// We just want to extend it so make it a trait
// We can link all case objects together through the trait

case object Monday extends Weekday
case object Tuesday extends Weekday
case object Wednesday extends Weekday
case object Thursday extends Weekday
case object Friday extends Weekday
case object Saturday extends Weekday
case object Sunday extends Weekday

// Difference to native enums is when we pattern match we have to do an exhaustive match

def caseObjMatch(weekday1: Weekday): String = {
  weekday1 match {
    case Monday => "Mon in function"
    case Tuesday => "etc"
    case Wednesday => "etc"
    case Thursday => "etc"
    case Friday => "etc"
    case Saturday => "etc"
    case Sunday => "etc"
  }
}

// This looks neater as it isn't weekday.value but just weekday

caseObjMatch(Monday)

// If you comment out any option in the list the exhaustive match you get:
/**
 * /Users/spencer.griffiths/Documents/ScalaAcademyTraining/src/main/scala/Week3/Wed/Enums.sc:114:3
 * match may not be exhaustive.
 * It would fail on the following input: Sunday
 * weekday1 match { */

// no easy way to access all values! - You would need to map through and retireve them one by one
// There is no default ordering

// Allows sense of safety but does mean potentially more code later on to map and order in a function

/**  */
/** ------>> Custom Errors */

abstract class Error (name: String, errorCode: Int)

case object WeekdayNotFound extends Error("Weekday Not found", 404)

// Coming back to this looking at eithers

/**  */

// ----------------------------------------------------------------------------------------
/** ------>> Task */
/** Use native enumeration to display the enums around your data */

object PrimaryColours extends Enumeration {
  val Red, Yellow, Blue = Value
}



object PrimaryColours2 extends Enumeration {
  val Red = Value(1, "R")
  val Green = Value(2, "G")
  val Blue = Value(3, "B")
}

/** print all the data */
PrimaryColours.Red.toString
PrimaryColours.values.toString()

PrimaryColours2.Red.toString
PrimaryColours2.values.toString()

/** Now turn these enums into case object type enumeration */

sealed trait Colours

case object Red extends Colours
case object Green extends Colours
case object Blue extends Colours

def exhaustiveColourMatch(colour: Colours) = {
  colour match {
    case Red => "R"
    case Green => "G"
    case Blue => "B"
  }
}

exhaustiveColourMatch(Red)

/** Now try to print all the values */

//def printAllVals(colours: Colours): String = {
//
//}