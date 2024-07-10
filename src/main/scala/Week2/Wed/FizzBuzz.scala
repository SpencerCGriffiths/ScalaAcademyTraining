package Week2.Wed

class FizzBuzz (x: Int) {

  def fizzBuzz(): String = {
    if (x % 3 ==0 && x % 5 == 0) "FizzBuzz"
    else if (x % 3 == 0) "Fizz"
    else if (x % 5 == 0) "Buzz"
    else "Neither Fizz nor Buzz"
  }

}
