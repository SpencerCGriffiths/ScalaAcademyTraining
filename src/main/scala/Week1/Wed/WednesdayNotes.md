String Interpolation 
Using string interpolation allows us to embed variable references directly into a processed string literal. Three common predetermined inerpolators are below: 

s interpolation:

val name: String = "April"
println(s"My name is $name")

println(s"3 x 3 = ${3*3}")

val number: Int = 7
println(s"$number x $number = ${number * number}")

F interpolation

allows for the creation of simpole formatted string 
type usage:
you must pass in the same type as the compoiler is expecting or you will get an error 

// %f - floating point number
// %d - decimal
// %i - Integer
// Find list of types you can use:
//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html#detail

val pi: Double = 3.1415926535897
println(f"Pi to 2dp is $pi%.2f") // 2 decimal places
println(f"Pi to 2dp is $pi%.4f") // 4 decimal places
println(f"Pi to 2dp but with a 16 width is $pi%16.4f") // 16 spaces with 4 decimal places

Raw: 

New line character
\n 

/Users/spencer.griffiths/Documents/ScalaAcademyTraining/src/main/scala/Week1/Wed/Interpolation.sc

If Else:
/Users/spencer.griffiths/Documents/ScalaAcademyTraining/src/main/scala/Week1/Wed/ifElse.sc

Sometimes we want a decision to be made based off the value of something else

Syntax: 

if (condition) { 
    Output
} else if (condition) { 
    Output
} else { 
    Output
} 

-OR-

if (condition) outcome

Match Case:
age match {
case age if age >= 18 => println("film rated as 18")
}

Tenerary/ Inline if: 
val str1: String = if (int1 > int2) "yes" else "no"