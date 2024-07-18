val acceptedStrings: Seq[String] = Seq("gender", "glasses", "facialhair", "hat", "eyecolour", "hair", "haircolour") // This order

var remainingFeatures: Seq[String] = Seq("gender", "glasses", "facialhair", "hat", "eyecolour", "eyecolour", "eyecolour", "hair", "haircolour", "haircolour", "haircolour", "haircolour")

// Remaining Hair Options
var remainingHairColours: Seq[String] = Seq("1. brown", "2. blonde", "3. black") // to change

// Remaining Eye Options
var remainingEyeColours: Seq[String] = Seq("1. blue", "2. brown", "3. green")

var value: Any = ""

def gameQuestions(remainingQuestions: Set[String], acceptedStrings : Seq[String]): Unit = {
  println("Ask another question.")
  println("You can pick from the following questions by typing the number:")
  acceptedStrings.filter {
    case feature => remainingQuestions.contains(feature)
  }.foreach{
    case "gender" => println("1. Are they _(male/female)_ ?")
    case "glasses" => println("2. Do they wear glasses?")
    case "facialhair" => println("3. Do they have facial hair?")
    case "hat" => println("4. Are they wearing a hat?")
    case "eyecolour" => println("5. Do they have _(colour)_ eyes?")
    case "hair" => println("6. Do they have hair?")
    case "haircolour" => println("7. Is their hair _(colour)_ ?")
  }
}

val remainingQuestions: Set[String] = remainingFeatures.toSet

// Tells you what questions are still to be asked
gameQuestions(remainingQuestions, acceptedStrings)

var response: String = "1"
// based on the primary response allows you to pick the sub category
response match {
  // When Your primary selection is haircolour
  case "haircolour" => {

    def hairColourMatch (response): Any = {
      println("\nSelect the hair colour:")
      remainingHairColours.foreach {
        case (element) => print(f"$element ")
      }
      value = scala.io.StdIn.readLine().toLowerCase()
      value match {
        case "1" || "1." => {
          println("Is their hair brown?")
          value = "brown"
        }
        case "2" || "2." =>{
          println("Is their hair blonde?")
          value = "blonde"
        }
        case "3" || "3." =>{
          println("Is their hair black?")
          value = "black"
        }
        case _ => {
          println("That is not an accepted input please try again")
          hairColourMatch(response)
        }
      }
    }
    value = hairColourMatch(response)
    if (characterToGuess.hairColour == value) include = true else include = false
  }
  case "eyecolour" => {

    def eyeColourMatch(response): Any = {

      println("Which colour eye:")
      remainingEyeColours.foreach {
        case (element) => print(f"$element" + "\n")
      }
      value = scala.io.StdIn.readLine().toLowerCase()

      value match {
        case "1" || "1." => {
          println("Do they have blue eyes?")
          value = "blue"
        }
        case "2" || "2." => {
          println("Do they have brown eyes?")
          value = "brown"
        }
        case "3" || "3." => {
          println("Do they have green eyes?")
          value = "green"
        }
        case _ => {
          println("That is not an accepted input please try again")
          eyeColourMatch(response)
        }
      }
    }
    if (characterToGuess.eyeColour == value) include = true else include = false
    value = eyeColourMatch(response)
    }
  }

  case "1" || "1." => {
     def genderMatch (response): Any = {
      println("\nSelect the gender:")
      println("1.male -or- 2.female?")
      value = scala.io.StdIn.readLine().toLowerCase()
      if(value == "1." || value == "1") {
        println("1. Are they male?")
        value = "male"
      } else if (value == "2." || value == "2") {
        println("1. Are they female?")
        value = "female"
      } else {
        println("That is not an accepted input sorry ")
        genderMatch(response)
      }
    }
    value = genderMatch(response)
    if (characterToGuess.gender == value) include = true else include = false

  }
  case "2" || "2." => {
    value = characterToGuess.glasses
  }
  case "facialhair" => {
    value = characterToGuess.facialHair
  }
  case "hat" => {
    value = characterToGuess.hat
  }
  case "hair" => {
    value = characterToGuess.hasHair
  }
}