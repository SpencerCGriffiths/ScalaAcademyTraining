// MVP

//1)
// a) Make a List of the numbers from 1-5 and a Seq of the primary colours
val nums: List[Int] = List(1,2,3,4,5,6,7,8,9)
val primary: Seq[String] = Seq("red", "yellow", "blue")

//b) Multiply all the values in your list by 3
val numMulti: List[Int] = nums.map{
  number => number * 3
}

//c) Remove "Blue" from your Seq
val noBlue: Seq[String] = primary.filter{
  colour => colour.toLowerCase() != "blue"
}

//d) Returns "true" if your Seq contains "Orange"
val containsYellow: Boolean = primary.contains("Orange")

//2) Go through each value in your list of numbers and return true if they are odd and false if they are even
val oddOrEven: List[Boolean] = nums.map {
  number => number % 2 == 0
}

//3) David has a lot of pets. Decide what pets he has (must include at least 1 dog) and write these in a Map
val DavidPets: Map[Int, String] = Map(
  0 -> "Cat",
  1 -> "Dog",
  2 -> "goat"
)

val DavidPetNames: Map[String, String] = Map(
  "fluff" -> "cat",
  "bubbles" -> "cat",
  "sniffer" -> "dog",
  "garfield" -> "dog",
  "napoleon" -> "dog",
  "devil" -> "goat"
)

//4) Return a List of the names of David's dog(s)
val davidPetTypes: List[String] = DavidPets.values.toList
val DavidDogNames: List[String] = DavidPetNames.filter(_._2 == "dog").keys.toList

//Extension:

//1) Starting with a Seq(1-9), come up with 2 filters that, when used together, will return Seq(1,2,5,7).
val numsSeq: Seq[Int] = Seq(1,2,3,4,5,6,7,8,9)

val filter1: Seq[Int] = numsSeq.filter(n => n < 8 && n != 4).filter(n => n % 3 != 0)

//Verbose option, not very dynamic:
val filter1: Seq[Int] = numsSeq.filter{
  num => num >= 1 && num <= 2 || num == 5 || num == 7
}

//Finding prime numbers but this includes 3
val filter2a: Seq[Int] = numsSeq.filter{n => n > 1}.filter{ x => x == 2 || x == 3 || x % 2 != 0 && x % 3 != 0}

//2) The .head function returns the first element of a list, and the .tail function returns everuthing except the first element. Use head and tail only to get the 3rd element of a List.
println(nums)
val index0: Int = nums.head
val index1: Int = nums.tail.head
val index2: Int = nums.tail.tail.head
val index3: Int = nums.tail.tail.tail.head

//Research:
//1) What makes a Set different from a Seq?


// What should Set(1,2) == Set(2,1,1,1) return?

val setWithDups: Set[Int] = Set(2,1,1,1) // removes duplicates because its a set
val setNotWithDups: Set[Int] = Set(2,1)
val tester: Boolean = Set(1,2) == Set(2,1,1,1)

//2) What do you think List(3,4) == Seq(3,4) will
// return? why?
// What about List(5,6) == Set(5,6)?
