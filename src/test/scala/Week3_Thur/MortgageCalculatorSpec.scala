package Week3_Thur

import Week3.Thur.Afternoon.MVP.MortageCalculator._

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import Week3.Thur.Either._
import org.scalatest.matchers.should.Matchers._

class MortgageCalculatorSpec extends AnyWordSpec {


  "creditScoreCheck " should {
    "Return Right value with credit score" when {
      "the credit score is greater than the threshold" in {
        val testCreditScore: Int = 600
        val testThreshold: Int = 400
        creditScoreCheck(creditScore = testCreditScore, minimumCreditScore = testThreshold) shouldBe testCreditScore
      }
    }
    "Return Left Value with error message" when {
      "the credit score is smaller than the threshold" in {
        val testCreditScore: Int = 400
        val testThreshold: Int = 600
        creditScoreCheck(creditScore = testCreditScore, minimumCreditScore = testThreshold) shouldBe testCreditScore
      }
      "the credit score is a negative" in {
        val testCreditScore: Int = -4
        val testThreshold: Int = 600
        creditScoreCheck(creditScore = testCreditScore, minimumCreditScore = testThreshold) shouldBe testCreditScore
      }
    }
  }


  "depositThreshold " should {
    "Return Right value with the deposit amount" when {
      "The deposit amount is over what is required" in {
        val deposit: Int = 1000
        val propertyPrice: Int = 10000
        val depositPercentage: Double = 0.1
        depositThreshold(deposit: Int, propertyPrice: Int, depositPercentage: Double) shouldBe deposit
      }
    }
    "Return Left Value with error message" when {
      "the deposit amount is smaller than what is required" in {
        val deposit: Int = 0
        val propertyPrice: Int = 10000
        val depositPercentage: Double = 0.5
        depositThreshold(deposit: Int, propertyPrice: Int, depositPercentage: Double) shouldBe "Error in depositThreshold"
      }
      "Need To Think of edge cases" in {
      }
    }
  }

  "financialCheck " should {
    "Return Right value with the total mortgage and deposit amount" when {
      "The combined total is greater than the property price" in {
        val annualIncome: Int = 900
        val mortgageRate: Int = 2
        val deposit: Int = 300
        val purchasePrice = 2000
        financialCheck(annualIncome: Int, mortgageRate: Int, deposit: Int, purchasePrice: Int) shouldBe (2100)
      }
    }
    "Return Left Value with error message" when {
      "the combined total is lower than the required amount" in {
        val annualIncome: Int = 900
        val mortgageRate: Int = 2
        val deposit: Int = 100
        val purchasePrice = 2000
        financialCheck(annualIncome: Int, mortgageRate: Int, deposit: Int, purchasePrice: Int) shouldBe (1900)
      }
      "Need To Think of edge cases" in {
      }
    }
  }

  "MortgageCalculator" should {
    val testProperty: Property = Property(100000)
    val testMarketRates: MarketRates = MarketRates(mortgageRate = 4, depositPercentage = 0.1, minCreditScore = 550)
    val testPurchaser: Purchaser = Purchaser(annualIncome = 45000, creditScore = 577, deposit = 20000)
    mortageCalculator(purchaser = testPurchaser, property = testProperty, marketRates = testMarketRates)

    "Return True" when {
      "The combination of all methods results in a property being a viable purchase" in {

        mortageCalculator(purchaser = testPurchaser, property = testProperty, marketRates = testMarketRates) shouldBe Right(true)
      }
    }

    "Need To Think of edge cases" in {
        }
      }
}


