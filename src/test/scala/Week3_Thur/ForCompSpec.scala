package Week3_Thur

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import Week3.Thur.ForComp._


class ForCompSpec extends AnyWordSpec with Matchers {

  "retrieveNums" should {
    val expected = Seq(1,2,3,4,5,6,7,8,9,10)

    "Generate a sequence of Numbers" in{

      retrieveNums() shouldBe expected

      }

    "Contain 10 elements" in{

      retrieveNums() should have length 10

    }

    "start with 1 and end with 10" in{

      retrieveNums().head shouldBe 1
      retrieveNums().last shouldBe 10

    }


  }

  "" must {
    "" when {
      "" in {


      }
    }
  }

}


