package Week2.Wed

import org.scalatest.flatspec.AnyFlatSpec


class TwoNumbersSpec extends AnyFlatSpec {

  "add" should "add numbers" in {
    val nums = new TwoNumbers(1,2)
    assert(nums.add == 3)
  }

  "subtract" should "subtract 1st number from 2nd number" in {
    val nums = new TwoNumbers(2,1)
    assert(nums.subtract == 1)
    assert(nums.subtract != -1)
  }

  "multiple" should "multiply the numbers" in {
    val test = new TwoNumbers(2,4)
    assert(test.multiply == 8)
  }

  "divide" should "divide the first number by the second" in {
    val test = new TwoNumbers(4,2)
    assert(test.divide == 2)
  }

  "divide2" should "return a double if divide became a division" in {
    val test = new TwoNumbers(5,2)
    assert(test.divide() == 2.5)
  }

  "isAMultiple" should "check if the 1st number is a multiple of the 2nd" in {
    val test = new TwoNumbers(20, 2)
    assert(test.isAMultiple())
  }


}
