package Week2.Wed

class NameLength {

  def nameLength(firstName: String, lastName: String): Int = {
    if (firstName.length > lastName.length) {
      firstName.length
    } else if (firstName.length < lastName.length) {
      lastName.length
    } else {
      0
    }
  }

}
