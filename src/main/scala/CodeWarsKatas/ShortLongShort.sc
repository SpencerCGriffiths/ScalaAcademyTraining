/** Short Long Short*/

/**
Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string on the outside and the longer string on the inside. The strings will not be the same length, but they may be empty ( zero length ).

  Hint for R users:

  The length of string is not always the same as the number of characters
    For example: (Input1, Input2) --> output

("1", "22") --> "1221"
("22", "1") --> "1221"
ShortLongShort.solution("1", "22"); // returns "1221"
ShortLongShort.solution("22", "1"); // returns "1221"
 */

def shortLongShort (x: String, y:String) : String = {
  if (x.length > y.length) {
    s"$y$x$y"
  } else {
    s"$x$y$x"
  }
}

shortLongShort("1", "22"); // returns "1221"
shortLongShort("22", "1"); // returns "1221"
shortLongShort("", "1"); // returns "1"