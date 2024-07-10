package Week2.Wed

class TwoNumbers (x: Int, y: Int) {

  def add(): Int = {
    x + y
  }

  def subtract(): Int = {
    x - y
  }

  def multiply(): Int = {
    x * y
  }

  def divide(): Double = {
    x.toDouble / y.toDouble
  }

  def isAMultiple(): Boolean = {
    if (x % y == 0) {
      true
    } else {
      false
    }
  }

}