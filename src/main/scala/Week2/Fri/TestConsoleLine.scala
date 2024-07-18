package Week2.Fri


object TestConsoleLine extends App {
  // ANSI escape codes
  val RESET = "\u001B[0m"
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

  val BCK_YELLOW = "\u001B[43m"

  // Example usage
  println(s"${BOLD}${RED}Error:${RESET} ${BOLD}${UNDERLINE}Something went wrong!${RESET}")
  println(s"${GREEN}Success:${RESET} Operation completed successfully.")
  println(s"${YELLOW}Warning:${RESET} This is a warning message.")
  println(s"${CYAN}Info:${RESET} Here is some information.")


  println(s"${BCK_YELLOW}Background yellow${RESET}")
}

//  Text Styles
//  Reset: \u001B[0m
//  Bold: \u001B[1m
//  Dim: \u001B[2m
//  Italic: \u001B[3m
//  Underline: \u001B[4m
//  Blink: \u001B[5m
//  Reverse: \u001B[7m
//  Hidden: \u001B[8m
//  Strikethrough: \u001B[9m

//  Text Colors
//  Black: \u001B[30m
//  Red: \u001B[31m
//  Green: \u001B[32m
//  Yellow: \u001B[33m
//  Blue: \u001B[34m
//  Magenta: \u001B[35m
//  Cyan: \u001B[36m
//  White: \u001B[37m
//  Bright Black: \u001B[90m
//  Bright Red: \u001B[91m
//  Bright Green: \u001B[92m
//  Bright Yellow: \u001B[93m
//  Bright Blue: \u001B[94m
//  Bright Magenta: \u001B[95m
//  Bright Cyan: \u001B[96m
//  Bright White: \u001B[97m

//  Background Colors
//  Background Black: \u001B[40m
//  Background Red: \u001B[41m
//  Background Green: \u001B[42m
//  Background Yellow: \u001B[43m
//  Background Blue: \u001B[44m
//  Background Magenta: \u001B[45m
//  Background Cyan: \u001B[46m
//  Background White: \u001B[47m
//  Background Bright Black: \u001B[100m
//  Background Bright Red: \u001B[101m
//  Background Bright Green: \u001B[102m
//  Background Bright Yellow: \u001B[103m
//  Background Bright Blue: \u001B[104m
//  Background Bright Magenta: \u001B[105m
//  Background Bright Cyan: \u001B[106m
//  Background Bright White: \u001B[107m