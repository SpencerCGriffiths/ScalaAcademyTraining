/** Extension and Research */

// Task 1
// create a function called max that takes two doubles and returns the maximum of the two

/** The max() method is utilized to return the maximum value of the two specified int numbers.

 Method Definition: (First_Number).max(Second_Number)

 Return Type: It returns true the maximum value of the two specified int numbers.

 the biggest of the two nums!*/

val max: (Double, Double) => Double = (x,y) => (x).max(y)

max(1,8)

// Create a maxListNum that takes a list of doubles and max. should return the largest num in the list (use reduce)

def maxListNum(nums: List[Double], fun: (Double, Double) => Double): Double = {
  nums.reduce((x,y)=> fun(x,y))
}
val nums: List[Double] = List(1,2,3,4,5,6,7,8)

maxListNum(nums, max)


// Create a function named applyFunc. Two params, function Int => Int, val Int
// the function should apply the function to the integer and return the result

val intfun: Int => Int = _ * 2

def applyFunc(func: Int => Int, num: Int): Int = {
  func(num)
}

applyFunc(intfun, 4)

// Create two functions, double- that doubles, square- that squares

val double: Int => Int = _ * 2
val square: Int => Int = (x) => (x * x)

// us applyFunc to apply double and square to 5, print the result

val double5 = applyFunc(double, 5)
println(s"Double 5 is ${double5}")

val square5 = applyFunc(square, 5)
println(s"5 squared is ${square5}")




// Create a function named power that takes Int exponent, returning a function Int => Int
// Return function should take a base Int and raise it to the power of ex
// Math.pow

def power(exponent: Int)

// Use the power function to create a square function that squares i.e base 2

// apply the square function to the number 6 and print
