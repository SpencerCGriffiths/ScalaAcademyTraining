
// s

val name: String = "April"
println(s"My name is $name")

println(s"3 x 3 = ${3*3}")

val number: Int = 7
println(s"$number x $number = ${number * number}")

// F

// %f - floating point number
// %d - decimal
// %i - Integer
// Find list of types you can use:
//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html#detail

val pi: Double = 3.1415926535897
println(f"Pi to 2dp is $pi%.2f") // 2 decimal places
println(f"Pi to 2dp is $pi%.4f") // 4 decimal places
println(f"Pi to 2dp but with a 16 width is $pi%16.4f") // 16 spaces with 4 decimal places




printf("'%s'", "Hello")
printf("'%s'", name)
printf("'%16s'", name)
printf("'%-16s'", name)


// Raw
// Raw will print exactly what is in there and escapes special characters etc.
// without
println("Hello \nWorld")
// with
println(raw"Hello \n  World")


// Character to enter new line
println("Hello \n  World")


//Exercises:

// Create 2 strings for two peoples names. Then using those names use string interpolation to print "A is older than B"
val name1: String = "Stephen"
val name2: String =  "John"

println(s"$name1 is older than $name2")
printf("'%s' is older than '%s'", name1, name2)

// Create 2 integers for the age of each person. Then use string interpolation to calculate how much older the first person is and print "A is X years older than B'
val age1: Int = 40
val age2: Int = 36

println(s"$name1 is ${age1 - age2} years older than $name2")

// Change your 2 integers to doubles and provide new decimal point values. Using string interpolation update the previous task so that the sentence remains the same using the 2 doubles.
val age1b: Double = 40.34
val age2b: Double = 36.45

println(f"$name1 is ${age1b - age2b}%.2f years older than $name2")

// Use string interpolation to avoid the new lines from this string "\n\n\n\n\n\n\n\nsameline\n\n"

println(raw"\n\n\n\n\n\n\n\nsameline\n\n")

// Extra
val height: Double = 1.6

println(s"$name jumps $height m")
println(f"$name can throw a ball $height%.0f meters high")




