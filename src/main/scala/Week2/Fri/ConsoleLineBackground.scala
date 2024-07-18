package Week2.Fri

object ConsoleLineBackground extends App {
  // ANSI escape codes for background colors
  val RESET = "\u001B[0m"
  val BG_BLACK = "\u001B[40m"
  val BG_RED = "\u001B[41m"
  val BG_GREEN = "\u001B[42m"
  val BG_YELLOW = "\u001B[43m"
  val BG_BLUE = "\u001B[44m"
  val BG_MAGENTA = "\u001B[45m"
  val BG_CYAN = "\u001B[46m"
  val BG_WHITE = "\u001B[47m"
  val BG_BRIGHT_BLACK = "\u001B[100m"
  val BG_BRIGHT_RED = "\u001B[101m"
  val BG_BRIGHT_GREEN = "\u001B[102m"
  val BG_BRIGHT_YELLOW = "\u001B[103m"
  val BG_BRIGHT_BLUE = "\u001B[104m"
  val BG_BRIGHT_MAGENTA = "\u001B[105m"
  val BG_BRIGHT_CYAN = "\u001B[106m"
  val BG_BRIGHT_WHITE = "\u001B[107m"


  val BLACK = "\u001B[30m"
  val RED = "\u001B[31m"
  val GREEN = "\u001B[32m"
  val YELLOW = "\u001B[33m"
  val BLUE = "\u001B[34m"
  val PURPLE = "\u001B[35m"
  val CYAN = "\u001B[36m"
  val WHITE = "\u001B[37m"

  val BOLD = "\u001B[1m"
  val UNDERLINE = "\u001B[4m"


  // Example usage of background colors
//  println(s"${BG_BLACK}This text has a black background${RESET}")
//  println(s"${BG_RED}This text has a red background${RESET}")
//  println(s"${BG_GREEN}This text has a green background${RESET}")
//  println(s"${BG_YELLOW}This text has a yellow background${RESET}")
//  println(s"${BG_BLUE}This text has a blue background${RESET}")
//  println(s"${BG_MAGENTA}This text has a magenta background${RESET}")
//  println(s"${BG_CYAN}This text has a cyan background${RESET}")
//  println(s"${BG_WHITE}This text has a white background${RESET}")
//  println(s"${BG_BRIGHT_BLACK}This text has a bright black background${RESET}")
//  println(s"${BG_BRIGHT_RED}${BLACK}${BOLD}This text has a bright red background${RESET}")
//
//
//  println(s"${BG_BRIGHT_BLUE}${BLACK}${BOLD}This text has a bright blue background${RESET}")
//  println(s"${BG_BRIGHT_MAGENTA}${BLACK}${BOLD}This text has a bright magenta background${RESET}")
//
//  println(s"${BG_BRIGHT_WHITE}${BLACK}${BOLD}This text has a bright white background${RESET}")
//
//
  println(s"${BG_BRIGHT_YELLOW}${BLACK}${BOLD}${UNDERLINE}!! * Ultimate Guess Who Experience * !!${RESET}")
  println()
  println(s"${BG_BRIGHT_GREEN}${BLACK}${BOLD}The rules are simple ....  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla placerat magna eget leo condimentum, sit amet porttitor ex congue. Proin dolor lorem, scelerisque in quam ut, finibus efficitur ligula. Donec pharetra tempor neque mattis tincidunt. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Aenean dictum convallis iaculis. Duis rhoncus imperdiet velit. Phasellus ultricies nisl sit amet ipsum tempor dapibus.${RESET}")

  println()


  def initialHelpRules (): Unit = {
  println(s"${BG_BRIGHT_GREEN}${BLACK}${BOLD}Whenever you are prompted for an answer you can also access the following commands:" +
    s"Enter B -> To see the remaining characters on the board and their attributes \n Enter G -> To make a guess at who the character is \n Enter Exit -> To leave the game :( \n Enter R -> To see the rules and how to win  \n Enter H -> At any time to see these options again ${RESET}")
  }

  initialHelpRules()
  println()


  def goodLuck (): Unit = {
    println(s"${BG_BRIGHT_WHITE}${BOLD}${UNDERLINE}${BLUE}G${RED}O${GREEN}O${YELLOW}D ${BLUE}L${PURPLE}U${CYAN}C${WHITE}K${RESET}")
  }

  goodLuck()
  println()
  def helpMe (): Unit = {
    println(s"${BG_BRIGHT_GREEN}${BLACK}${BOLD} Welcome to the Help Menu: \n Enter B -> To see the remaining characters on the board and their attributes \n Enter G -> To make a guess at who the character is \n Enter Exit -> To leave the game :( \n Enter R -> To see the rules and how to win  \n Enter H -> At any time for help ... As you know...  ${RESET}")
  }

  helpMe()
  println()
}