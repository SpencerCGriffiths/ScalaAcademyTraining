val map: Map[Int, String] = Map(
  1 -> "Hello",
  2 -> "World",
  3 -> "!"
)

for ((key, value) <- map) {
  println(s"key: $key, value: $value")
}

map foreach {
  case (key, value) => println (key + "--->" + value)
}

val sequence: Seq[String] = map.map {
  case (key, value) => value
}.toSeq

sequence.foreach(string => println(string))

val remaining: Seq[String] = map.map{
  case (key, value) => {
    if (value != "Hello") value else ""
  }
}.toSeq

val remaining: Seq[String] = map.map {
  case (key, value) => {
    if (value != "Hello") value else ""
  }
}.toSeq

remaining.foreach(x => println(x))