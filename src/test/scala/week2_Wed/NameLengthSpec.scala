package Week2.Wed

import org.scalatest.FlatSpec

class NameLengthSpec extends FlatSpec {

  "nameLength" should "Return firstName if it is longer than last name" in {
    val test = new NameLength()
    assert(test.nameLength("Johnathon", "Smith") == 9)
  }

//  it should "Return LastName if it is longer than the first name" in {
//    val test = new NameLength()
//    assert()
//  }
}
