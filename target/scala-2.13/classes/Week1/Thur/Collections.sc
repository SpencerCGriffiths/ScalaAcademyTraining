//Sequences

//Seq
val seq1: Seq[Int] = Seq(1,2,3)

//List
val list1: List[Int] = List(1,2,3)

//Map
// Key value pairs :
// Syntax
// key -> value

val map1: Map[String, Int] = Map(
  "one"   -> 1,
  "two"   -> 2,
  "three" -> 3
)

// Retrieving index values
val getSeqData: Int = seq1(0)

//.head
// give you the first element at index 0
val getSeqHead: Int = seq1.head

//.tail
// Everything but the first element
val getSeqTail: Seq[Int] = seq1.tail


//List
//Find by index
val getListData: Int = list1(1)

val getListHead: Int = list1.head

val getListTail: List[Int] = list1.tail

//Maps
// call by key not by index
val getMapData = map1("one")

//Sequence
val tripledSeq: Seq[Int] = seq1.map {
  number => number * 3
}

//List
val tripledList: List[Int] = list1.map {
  number => number * 3
}

// Map
//Demo
val tripledMap: Map[String, Int] = map1.map {
  case (key, number) => (key, number * 3)
}

//Change Key

val changeKey: Map[String, Int] = map1.map {
  case (key, value) => (key + "New", value)
}

// Change Key and Value
val changeKey: Map[String, Int] = map1.map {
  case (key, value) => (key + "X10", value * 10)
}

//filter
val filteredSeq: Seq[Int] = seq1.filter{
  number => number > 1
}
val filteredList: List[Int] = list1.filter{
  number => number > 1
}

filteredList == filteredList
println(list1)
println(seq1)

seq1.filter{
  number => number > 1
}

println(seq1)

//Filter Map

val filteredMap: Map[String, Int] = {
  map1.filter (number => number._2 > 1)
}

//tupple two inputs

val filterNotList: List[Int] =
  list1.filterNot(number => number >= 2)
//{} - recognise special character
//() - will not recognise special characters

  //Exists
//Boolean - it will return the first match result
val listExists: Boolean = list1.exists{
  number => number > 2
}

val SeqExists: Boolean = seq1.exists{
  number => number > 2
}

val mapExists: Boolean = map1.exists{
  number => number._2 > 2
}
// ._2 looks at val
// ._1 looks at key

//Contains
// check for one parameter in particular we use contains
// returns boolean
val containsSeq: Boolean = seq1.contains(2)
val containsList: Boolean = list1.contains(2)

// With maps can only check the key:
val containsMap: Boolean = map1.contains("two")

// Chaining contains

val containsSeq: Boolean = seq1.contains(2) && seq1.contains(4)
val containsSeq: Boolean = seq1.contains(2)

// Tasks

// 1) Create a Seq of the names of everybody in the academy

val academyNames: Seq[String] = Seq("Antony","April","Arei","Bilal","Jamie","Joe","Muhammad","Roshan","Tayamul","Tom","Spencer")

// 2) Create a Map of 1-"red" 2-"yellow", 3-"blue", 4-"green" and play with accessing the elements
val colourMap: Map[Int, String] = Map(
  1 -> "red",
  2 -> "yellow",
  3 -> "blue",
  4 -> "green"
)

// Extra- you can use toSet to remove duplicates as well as to turn it in to a set
val keySet: Set[Int] = colourMap.keys.toSet
val valSet: Set[String] = colourMap.values.toSet


// Retrieve by Key
val getColour: String = colourMap(1)

// 3) Add 1 to all numbers in a collection
val addingOne: Map[Int, String] = colourMap.map{
  case (key, value) => (key + 1, value)
}
println(addingOne)

// 4) Remove all even numbers from a collection
val removeEven: Map[Int, String] = colourMap.filter {
  number => number._1 % 2 != 0
}
println(removeEven)

// 5) Return true if a Seq has a String that contains the letter "r"
val containsR: Boolean = academyNames.exists{
  name => name.contains("r")
}
println(containsR)

// Task 2

//1) We have looked at Seq and Map iterables. We haven't looked at Sets, What are they? How are they different?
/**
 Sets are iterable data sets that contain No Duplicate Elements
contains:
Does it contain an element
 apply:
set(element) is the same as set contains element
 subsetOf

 */
val fruit: Set[String] = Set("apple", "orange", "peach", "banana")


//2) flatMap is another cool method we can call on collections. Research what it does and when it could be useful. Write an example.


//Arrays

//* You see advanced Java devs use arrays, they work the same way

val arr1: Array[String] = Array("Hello", "My", "name")
val arr2: Array[Int] = Array(1,2,3)
val plusTwo: Array[Int] = arr2.map{
  _ + 2
}


// ***** _ underscore is a unknown field



// With a var we can add elements using :+ to append and = in order to reassign the variable.
var x = Seq[Int]()
x :+= 2
println(x)

val y = Seq(3,4,5)
// Append 6 to it
val x = y :+ 6
val z = 2 +: x

val z1 = y ++ Seq(6,7)
val z2: Seq[Int] = (y :+ Seq(6,7)).flatMap( num => num)
