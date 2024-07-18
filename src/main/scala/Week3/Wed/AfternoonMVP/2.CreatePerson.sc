/** Given this data:
 * Full Name
 * Date of Birth
 * Occupation
 * Last County Lived in
 * Date of Death
 Only the fields Full Name, Date of Birth, Last Country lived in are required (this options)
 Create a method that accepts the above data and makes a Person case class from this data
 The Person case class should also include their age, star sign. If they have a dateOfDeath it should include their ageAtDeath*/
import java.time.LocalDate
import java.time.temporal.ChronoUnit

case class Person(
                   fullName: String,
                   dateOfBirth: LocalDate,
                   occupation: Option[String],
                   lastLivedCountry: String,
                   dateOfDeath: Option[LocalDate],
                   ageAtDeath: Option[Int],
                   age: Int,
                   starSign: String
                 )



object Methods {


  def findCurrentAge(dateOfBirth: LocalDate): Int = {
    val currentDate = LocalDate.now()
    val age = currentDate.getYear - dateOfBirth.getYear
    if ((currentDate.getMonthValue < dateOfBirth.getMonthValue) ||
      (currentDate.getMonthValue == dateOfBirth.getMonthValue && currentDate.getDayOfMonth < dateOfBirth.getDayOfMonth)) {
      age - 1
    } else {
      age
    }
  }



  def findStarSign(dateOfBirth: LocalDate): String = {
    val monthOfBirth = dateOfBirth.getMonthValue
    val dayOfBirth = dateOfBirth.getDayOfMonth

    (monthOfBirth, dayOfBirth) match {
      case (1, day) if day >= 20 && day <= 31 => "Aquarius"
      case (2, day) if day >= 1 && day <= 18 => "Aquarius"
      case (2, day) if day >= 19 && day <= 29 => "Pisces"
      case (3, day) if day >= 1 && day <= 20 => "Pisces"
      case (3, day) if day >= 21 && day <= 31 => "Aries"
      case (4, day) if day >= 1 && day <= 19 => "Aries"
      case (4, day) if day >= 20 && day <= 30 => "Taurus"
      case (5, day) if day >= 1 && day <= 20 => "Taurus"
      case (5, day) if day >= 21 && day <= 31 => "Gemini"
      case (6, day) if day >= 1 && day <= 20 => "Gemini"
      case (6, day) if day >= 21 && day <= 30 => "Cancer"
      case (7, day) if day >= 1 && day <= 22 => "Cancer"
      case (7, day) if day >= 23 && day <= 31 => "Leo"
      case (8, day) if day >= 1 && day <= 22 => "Leo"
      case (8, day) if day >= 23 && day <= 31 => "Virgo"
      case (9, day) if day >= 1 && day <= 22 => "Virgo"
      case (9, day) if day >= 23 && day <= 30 => "Libra"
      case (10, day) if day >= 1 && day <= 22 => "Libra"
      case (10, day) if day >= 23 && day <= 31 => "Scorpio"
      case (11, day) if day >= 1 && day <= 21 => "Scorpio"
      case (11, day) if day >= 22 && day <= 30 => "Sagittarius"
      case (12, day) if day >= 1 && day <= 21 => "Sagittarius"
      case (12, day) if day >= 22 && day <= 31 => "Capricorn"
      case (1, day) if day >= 1 && day <= 19 => "Capricorn"
      case (_, _) => "That month or day is not known"
    }
  }



  def ageAtDeath(dateOfDeath: Option[LocalDate], dateOfBirth: LocalDate): Option[Int] = {
    dateOfDeath match {
      case Some(deathDate) =>
        val yearBorn = dateOfBirth.getYear
        val monthOfBirth = dateOfBirth.getMonthValue
        val dayOfBirth = dateOfBirth.getDayOfMonth

        val yearDeath = deathDate.getYear
        val monthOfDeath = deathDate.getMonthValue
        val dayOfDeath = deathDate.getDayOfMonth

        // Calculate the initial age difference in years
        val age = yearDeath - yearBorn

        // Adjust age if the birthday hasn't occurred yet in the death year
        val adjustedAge =
          if (monthOfDeath < monthOfBirth || (monthOfDeath == monthOfBirth && dayOfDeath < dayOfBirth))
            age - 1
          else
            age

        Some(adjustedAge)
      case None => None
    }
  }
}

// Define the createAPerson function
def createAPerson(fullName: String, dateOfBirth: LocalDate, occupation: Option[String], lastLivedCountry: String, dateOfDeath: Option[LocalDate]): Person = {
  // Calling a method to find the age
  val age = Methods.findCurrentAge(dateOfBirth)

  // Calling a method to find the starSign
  val starSign = Methods.findStarSign(dateOfBirth)

  // Calling a method to find the ageAtDeath if it exists
  val ageAtDeath = Methods.ageAtDeath(dateOfDeath, dateOfBirth)

  // Creating the actual person object
  val createdPerson = Person(
    fullName = fullName,
    dateOfBirth = dateOfBirth,
    occupation = occupation,
    lastLivedCountry = lastLivedCountry,
    dateOfDeath = dateOfDeath,
    ageAtDeath = ageAtDeath,
    age = age,
    starSign = starSign
  )

  createdPerson
}


val person = createAPerson(
  fullName = "John Smith",
  dateOfBirth = LocalDate.of(1940, 10, 8),
  occupation = None,
  lastLivedCountry = "Germany",
  dateOfDeath = Some(LocalDate.of(2010, 9, 10))
)

person.productIterator.foreach {
  (feature) => println(feature)
}

// ChronoUnit.YEARS.between() - chronounit built in method