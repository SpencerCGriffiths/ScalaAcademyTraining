val weather: String = "cold"

if (weather == "cold") {
  println(s"It is $weather take a coat")
} else if (weather == "hot") {
  println(s"It is $weather were sunglasses")
} else {
  println(s"It is anything but hot or cold so good luck :)")
}


val season: String = "winter"

if (weather == "cold" && season == "winter" ) {
  println(s"It is $weather take a coat")
} else if (weather == "hot") {
  println(s"It is $weather wear sunglasses")
} else {
  println(s"It is anything but hot or cold so good luck :)")
}

if (weather == "cold") println("in line if is possible? ")

// Exercise:

//Use conditions to calculate somebody's grade given the percentage they scored
val grade: Int = 90

if (grade >= 90 ) {
  println("A")
} else if (grade < 90 && grade >= 80 ) {
  println("B")
} else if (grade < 80 && grade >= 70 ) {
  println("C")
}else if (grade < 70 && grade >= 60 ) {
  println("D")
}else if (grade < 60 && grade >= 50 ) {
  println("E")
} else {
  println("F")
}

// Use conditions to work out for a given age, what film ratings they are able to see. Make sure your conditions are exhaustive and any age will get a response.

val age: Int = 19

if (age >= 18) {
  println("18")
} else if (age >= 15) {
  println("15")
} else if (age >= 12) {
  println("12")
} else if (age >= 8) {
  println("PG")
} else if (age >= 4) {
  println("U")
} else if (age < 4 ) {
  println("No films for you child!")
}


//Switch Case/ Pattern Matching


age match {
  case age if age >= 18 => println("film rated as 18")
}
