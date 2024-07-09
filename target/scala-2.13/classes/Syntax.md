// For Loop 

val test: Seq[Int] = Seq(1,2,3,4,5,6,7,8)
for(n <- test) {
println(n) 
}

test.foreach {
case (num) => println(num)
}

for (i <- 0 until test.length) {
println(test(i))
}

for (i <- test.indices) {
println(test(i))
}

