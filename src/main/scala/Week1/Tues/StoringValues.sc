// 5 melons at 50p // 2 apples 10p // 6 drinks £1.20

// You can break down each step to compute:
val priceOfMelon = 50
val numberOfMelon = 5
val melonTotal = priceOfMelon * numberOfMelon

// You can compute in line:
val melons = 5 * 50
val apples = 2 * 10
val drinks = 6 * (1.20 * 100)
val total = melons + apples + drinks

// This will not work as we cannot reassign a val!
val total = 0
