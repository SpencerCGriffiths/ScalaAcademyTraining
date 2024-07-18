package Week3_Thur

import org.scalatest.wordspec.AnyWordSpec
import Week3.Thur.Afternoon.Extension.Extensions._
import org.scalatest.matchers.should.Matchers._

class ExtensionsSpec extends AnyWordSpec{

  "postcodeOrError" should {

    "Return the given postcode properly formatted as Right(Postcode(value))" when {
      "given a postcode with a space in between two string" in {
        val testPostcode: String = "SE1 9PQ"
        Postcode.postcodeOrError(testPostcode) shouldBe Right(Postcode(testPostcode))
      }

      "given a postcode with multiple space in between two string" in {
        val testFormatted: String = "SE1 9PQ"
        val testPostcodeInput: String = "SE1           9PQ"
        Postcode.postcodeOrError(testPostcodeInput) shouldBe Right(Postcode(testFormatted))
      }

      "given a postcode with space before and after and a space in between two string" in {
        val testFormatted: String = "SE1 9PQ"
        val testPostcodeInput: String = "    SE1    9PQ     "
        Postcode.postcodeOrError(testPostcodeInput) shouldBe Right(Postcode(testFormatted))
      }
    }


    "Return an Left(InvalidPostcodeError(Invalid postcode format))" when {
      "given a postcode with more than two blocks of strings" in {
        val testPostcode: String = "SE 19 PQ"
        Postcode.postcodeOrError(testPostcode) shouldBe Left(InvalidPostcodeError("Invalid postcode format"))
      }

      "given a postcode with a large number of seperate characters" in {
        val testPostcodeInput: String = "S E 1 9 P Q B C"
        Postcode.postcodeOrError(testPostcodeInput) shouldBe Left(InvalidPostcodeError("Invalid postcode format"))
      }

    }

  }

  "nameOrerror" should {

    "Return the name that was input" when {

      "A name is input without numbers" in {
        val testName: String = "john"
        Name.nameOrError(testName) shouldBe Right(Name(testName))
      }

      "A name is input without numbers but with white trailing" in {
        val testName: String = "john    "
        Name.nameOrError(testName) shouldBe Right(Name(testName))
      }

      "A name is input without numbers but with white leading space" in {
        val testName: String = "    john"
        Name.nameOrError(testName) shouldBe Right(Name(testName))
      }
    }

    "Return a InvalidNameError" when {

      "A name with a number is entered" in {
        val testName: String = "john123"
        Name.nameOrError(testName) shouldBe Left(InvalidNameError("Name cannot contain numbers"))
      }
    }
  }
}
