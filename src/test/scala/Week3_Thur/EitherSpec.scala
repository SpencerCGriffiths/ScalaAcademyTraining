package Week3_Thur


import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import Week3.Thur.Either._
import org.scalatest.matchers.should.Matchers._

class EitherSpec extends AnyWordSpec {

  "Is Odd " should {
    "Return a right" when {
      "The number is odd" in {
        val result = isOdd(3)
        result shouldBe Right("3 is odd")
      }
      "The number is odd and large" in {
        val result = isOdd(10001)
        result shouldBe Right("10001 is odd")
      }
    }
    "Return a left" when {
      "the number is even" in {
        val result = isOdd(4)
        result shouldBe Left(IsOddError)
      }
    }

  }

}
