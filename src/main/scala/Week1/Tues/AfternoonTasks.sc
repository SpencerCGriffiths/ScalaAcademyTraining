// MVP

// Before coding decide if the answer will be true or false and why, then use operators to store values relating to the following:

//a)
// Three plus four, times fifty-seven is less than three-hundred
val a: Boolean = 3 + 4 * 57 < 300

//b)
// One-hundred and forty-four, divided by 12 is greater than twelve or equal to twelve
val b: Boolean = 144 / 12 >= 12

//c)
//Cat is less than Dog
val c: Boolean = "Cat" < "Dog"

//d)
// Rabbit is less than Hamster
val d: Boolean = "Rabbit" < "Hamster"

//e)
// Seventeen is odd
val e: Boolean = 17 % 2 != 0

//f)
//Seventy-five divided by nine is less than thirty and eighty-nine divided by six is less than twenty
val f: Boolean = 75 / 9 <  30 && 89 / 6 < 20

//2
// What is the difference between a string e.g. "I love scala already" and a print line println("I love scala")

val string: String = " i love scala already"
// this is a value of a string but does not on its own print to a console

println(string)
// this is printing the value

//3

// Have a play with scala in a worksheet using everything we have learnt today. What is possible? what isn't? is there anything that you have done that you think is pretty cool or that's strange?


// To return to this one


// Extension

//1
//"STRING" == "string"
val one: Boolean = "STRING" == "string"
// == is able to compare strings i.e. "string" == "string" = true
// BUT, it is case sensitive

//2
//Can you convert "one" to 1
val i: Int = "1".toInt
println(i)

//val x: String = "one".toInt
//println(x)
////Results in error

//3
//Can you convert 1 to "one"
val y: String = 1.toString
println(y)

// 4
// Can you convert one in to a string
val y: String = 1.toString
println(y)

//5
// Convert lower case string to upper case
val string: String = "I_Am_WoNkY"
println(string.toUpperCase())

//6
//Convert upper case to lower case
println(string.toLowerCase())


//Research

// Make a Val called new which is type string:
//val new: String = "New is protected Silly"

//Why doesn't this compile?
// new is a keyword

//What do we need to do within our code to make it compile?
val anythingButNew: String = "HaHa, problem solved!"
println(anythingButNew)

// Are there any other words you cannot use?
// See notes for descriptions of words
/**
 - abstract
 - case
 - catch
 - class
 - def
 - do
 - else
 - extends
 - false
 - final
 - finally
 - for
 - forSome
 - if
 - implicit
 - import
 - lazy
 - match
 - new
 - null
 - object
 - override
 - package
 - private
 - protected
 - return
 - sealed
 - super
 - this
 - throw
 - trait
 - true
 - try
 - type
 - val
 - var
 - while
 - with
 - yield
**/