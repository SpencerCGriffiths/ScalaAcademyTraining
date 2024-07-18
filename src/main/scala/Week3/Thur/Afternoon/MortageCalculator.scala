package Week3.Thur.Afternoon

case object MortageCalculator extends App {
  // Samantha wants to buy a flat
  // She earns £45,000
  // Deposit £20,000
  // Credit score 577

  // flat is 280,000

  // Conditions:
  // Mortgage = x4 salary per annum
  // Deposit = 10% purchase price
  // Minimum credit score = 550

  // Can she get a mortgage and how much can she borrow
  // can she purchase her flat at the current price
  // write a test spec

  // Outer Method: BuyTheHouse (income: Int, deposit, Int, creditScore, Int, flat price, Int)
  // method- eligible for a mortgage - check credit score- true or false - Either[StringError, CreditScore]
  // method - mortgage amount- per annum x 4 - Int -
  // method - enoughDeposit- House price * 0.1 == deposit
  // method - enoughMoney - deposit + mortgage amount Either[StringError, boolean]


  //

  /** Instantiate values to use throughout */
  case class Purchaser(annualIncome: Int, creditScore: Int, deposit: Int)
  // Case class of the purchaser

  case class MarketRates(mortgageRate: Int, depositPercentage: Double, minCreditScore: Int)

  case class Property(purchasePrice: Int = 280000)
  // Setting property price





  /** Create the relevant methods for the final calculation */

  def creditScoreCheck(creditScore: Int, minimumCreditScore: Int): Either[String, Int] = {
    if(creditScore < minimumCreditScore) Left("Error in minimum creditScore") else Right(creditScore)
  }

  def depositThreshold(deposit: Int, propertyPrice: Int, depositPercentage: Double): Either[String, Int] = {
    val requiredAmount = math.floor(propertyPrice * depositPercentage).toInt
    if(deposit < requiredAmount) Left("Error in depositThreshold") else Right(deposit)
  }

  def financialCheck(annualIncome: Int, mortgageRate:Int, deposit: Int, purchasePrice: Int):  Either[String, Int] = {
    val mortAndDepos: Int = math.floor(annualIncome * mortgageRate + deposit).toInt
    if(purchasePrice > mortAndDepos) Left("There is not enough money in deposit and mortgage") else Right(mortAndDepos)

  }




  /** combining all methods with ForComp */

  def mortageCalculator(purchaser: Purchaser, property: Property, marketRates: MarketRates): Either[String, Boolean] = {

    for {
      creditCheck <- creditScoreCheck(purchaser.creditScore, marketRates.minCreditScore)
      depositCheck <- depositThreshold(purchaser.deposit, property.purchasePrice, marketRates.depositPercentage)
      financeCheck <- financialCheck(purchaser.annualIncome, marketRates.mortgageRate, purchaser.deposit, property.purchasePrice)
    } yield true
  }

  val niceFlat: Property = Property()
  val marketRates: MarketRates = MarketRates(mortgageRate = 4, depositPercentage = 0.1, minCreditScore = 550)
  val Samantha: Purchaser = Purchaser(annualIncome = 45000, creditScore = 577, deposit = 20000)
  println("---> MortgageCalculator")
  print("Can Samantha afford the flat?")
  println(mortageCalculator(purchaser = Samantha, property = niceFlat, marketRates = marketRates))

}


