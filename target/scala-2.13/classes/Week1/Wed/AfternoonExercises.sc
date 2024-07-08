/**
Afternoon Tasks

John from primary school maths is trying to buy as many watermelons as possible and we need to give him a reality check.
John can reasonably carry 3 watermelons without a bag and 5 with one bag
**/

//1) Create a Value to store a number of watermelons

val numOfWatermelons: Int = 8

//2) Use an if statement to print out appropriate messages based on the criteria above:
if(numOfWatermelons <= 3 ) {
  println(s"John can carry all $numOfWatermelons without a bag")
} else if ( numOfWatermelons <= 5) {
  println(s"John can carry all $numOfWatermelons with a bag but not without one")
} else if ( numOfWatermelons > 5 ) {
  println(s"Don't be greedy now John, $numOfWatermelons is too many")
} else {
  println("The given value is not valid for this condition")
}

//3) Use string interpolation to add to each message the number of watermelons John is trying to buy, Which type is most appropriate?
// s type for basic syntax and the data type is simple i.e. no decimals etc
// see above (should of read ahead)

//4) Create a value to store a boolean that indicates whether John has a bag with him or not
val hasBag: Boolean = true

//5) Use an if statement and this bool value to tell john whether he can or cannot buy the desired number of watermelons in task one? Can this be done without else if?

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
  case numOfWatermelons if numOfWatermelons < 0               =>  println(s"Go home John there's magic happening... RUN")
  case numOfWatermelons if numOfWatermelons == 0              =>  println(s"Go home John, all sold out of watermelons here mate")
  case numOfWatermelons if numOfWatermelons <= 3              =>  println(s"John you can carry all $numOfWatermelons without a bag")
  case numOfWatermelons if numOfWatermelons <= 5 && hasBag    =>  println(s"John you can carry all $numOfWatermelons with a bag, well done for bringing one")
  case numOfWatermelons if numOfWatermelons <= 5 && !hasBag   =>  println(s"Sorry John, forgot your bag for life so you can't manage $numOfWatermelons watermelons")
  case numOfWatermelons if numOfWatermelons > 5               =>  println(s"Don't be greedy now John, $numOfWatermelons is too many")
  case _                                                      =>  println("The given value is not valid for this condition")
}

//6) The store puts their prices in a foreign currency, so the conversion rate to £ means one watermelon is £1.397. Calculate and use string interpolation to display the total cost of John's purchase to 2 decimal places- which is the most appropriate?

val pricePerWatermelon: Double = 1.397

println(f"The price of your watermelons is ${pricePerWatermelon * numOfWatermelons}%.2f Johnny")
printf("The price of your watermelons if %.2f Johnny", pricePerWatermelon * numOfWatermelons)

/**
Extension:
logical operators used in IF statements (&& or <) have an order of precedence
1) What is the order and where can we find it:
 ->not
 ->and
 ->or

 e.g:

 print(True or False and False)     # and has precedence
 print((True or False) and False)   # parentheses change precedence

 print(not False or True)        # not has precedence
 print(not (False or True))      # parentheses change precedence

 Output:
 True
 False
 True
 False
**/

//2) what would (true || false && false) result in
val test:Boolean = true || false && false
// result:true

//3) what would ((true||false) && false) result in
val test2:Boolean = ((true||false) && false)

//4) Finally
val test3: Boolean = 1 < 4 && 7 != 10 || 9 + 10 == 21

// Step 1:
// 1 < 4 = true
// 7 != 10 true
// true and true = true

// Step 2:
// true || 9 + 10 == 21
// 9 + 10 = 19
// 19 == 21 = false

// Step 3:
// true || false = true

/**
Research Task

if statements always return values. This means we can assign values based on if statements.

 (always return values?)

How would we go about doing this or where could we search to find out?
Create two values that hold integers. Assign any integer you'd like to these values.
Create a new value to hold a string and assign it "yes" if the first value is greater than the second, and "no" if the second value is greater.

**/

val int1: Int = 6
val int2: Int = 3
val str1: String = if (int1 > int2) "yes" else "no"
println(str1)

