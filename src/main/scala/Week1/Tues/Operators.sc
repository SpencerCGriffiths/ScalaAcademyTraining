//Arithmetic


val a: Int = 10
val b: Int = 5

val add = a + b
println(add)
// + (a+b)

val minus = a - b
println(minus)
// - (a-b)

val division = a / b
println(division)
// / (a/b)

val multiply = a * b
println(multiply)
// * (a*b)

val modulo = a % b
println(modulo)
// % (a%b)


//Relational


val equality = a == b
println(equality)
// ==

val inequality = a != b
println(inequality)
// !=

val lessThan = a < b
println(lessThan)
// <

val greaterThan = a > b
println(greaterThan)
// >

val lessThanOrEqual = a <= b
println(lessThanOrEqual)
// <=

val greaterThanOrEqual = a >= b
println(greaterThanOrEqual)
// >=

// Logical

val and = true && true
val and1 = true && false
// && - and

val or = true || false
val or1 = false || false
// || - or

val not = !true
val not2 = !false
// ! - not

//Exercise 1:

// Logical AND

val T1 = true && true
val T2 = true && false
val T3 = false && true
val T4 = false && false

// Logical OR
val T5 = true || true
val T6 = true || false
val T7 = false || true
val T8 = false || false

// Logical NOT

val T9 = !true
val t10 = !false

// Exercise 2:

// Use Operators to store values relating to the following:

// Four plus three, times fifty-five is less than three-hundred
val q1 = ((4 + 3) * 55) < 300

// ninety-six divided by twelve is greater than eight or exactly eight
val q2 = (96 / 12) > 88 || (96 / 12) == 88

// Hamster is less than Hippo (strings)
val q3 = "Hamster" < "Hippo"
//Compares something alphabetically

// Eight is even
val q4 = 8 % 2 == 0

// One hundred and fifty six divided by eight is less than twenty, and, fifty four is less than 20 and fifty four divided by four is less than fourteen
val q5 = 156 / 8 < 20 && 54 < 20 && 54 / 4 < 14