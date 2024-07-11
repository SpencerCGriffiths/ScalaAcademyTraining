/** Parse nice int from char problem */

/** You ask a small girl,"How old are you?" She always says, "x years old", where x is a random number between 0 and 9.

 Write a program that returns the girl's age (0-9) as an integer.

 Assume the test input string is always a valid string. For example, the test input may be "1 year old" or "5 years old". The first character in the string is always a number.*/

def produceAge (x: String) : Int = {
  val ageString = x.head // head returns a char
  ageString.toString.toInt
}

produceAge("9 years old")

def produceAge2Digit (x: String) : Int = {
val space = x.indexOf(" ")
val numString = x.substring(0, space)
  numString.toString.toInt
}

produceAge2Digit("9 years old")
produceAge2Digit("19 years old")
produceAge2Digit("199 years old")
