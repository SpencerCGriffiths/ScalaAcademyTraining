abstract class Person  {
  val hair: Boolean
  val gender: String
}


abstract class male(
                   ) extends Person {
  val gender: String = "Male"
  val height: Int = 5
}

case class female() extends Person {
  val hair: Boolean = true
  val gender: String = "female"
}

class bold (
             val facialHair: Boolean,
val hair: Boolean =  false
           ) extends male

val boldP : bold = new bold( facialHair = true)

val women: female = female()

def attributesToSet(user: Product): Set[String] = {
  user.productIterator.map(_.toString).toSet
}

val userAttributes = attributesToSet(women)
println(userAttributes)

println(women.hair)
println(women.gender)

println(boldP.facialHair)
println(boldP.height)
println(boldP.hair)
println(boldP.gender)


/**
 class Person {

 // hair undeclared
 // eye colour undeclared
 // beard = undeclared

 }

 class male extends person {
 // hair undeclared
 // beard = undeclared
 }

 class bald extends male {

 // hair false
 }

 class hair extends male {

 // hair true

 }

 val steve = new bald
 val greg = new hair

 */
