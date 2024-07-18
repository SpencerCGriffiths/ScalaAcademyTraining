package Week2.Wed

import org.scalatest.flatspec.AnyFlatSpec

class FizzBuzzSpec extends AnyFlatSpec {


  "FizzBuzz" should "return Fizz if the input is exactly divisible by 3" in {
    val test = new FizzBuzz(3)
    assert(test.fizzBuzz == "Fizz")
  }

  it should "return Buzz if the input is exactly divisible by 5" in {
    val test = new FizzBuzz(5)
    assert(test.fizzBuzz == "Buzz")
  }

  it should "return FizzBuzz if the input is exactly divisible by 3 and 5" in {
    val test = new FizzBuzz(15)
    assert(test.fizzBuzz == "FizzBuzz")
  }
}
