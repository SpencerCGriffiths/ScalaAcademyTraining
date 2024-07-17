/** Using pattern matching, when given given a string of the name of a country your pattern match should return that countries capital city
 * Think about how you will deal with countries you have not included
 * What happens when someone has entered a county in all lowercase/ uppercase or mixed?
 * what if the country has whitespaces either side of it?
 * */

// Create function for pattern matching
def getCapital (country: String): String = {
  country.toLowerCase().trim match {
    case "england" => s"The capital of ${country.trim.toLowerCase()} is London"
    case "france" => s"The capital of ${country.trim.toLowerCase()} is Paris"
    case "japan" => s"The capital of ${country.trim.toLowerCase()} is Tokyo"
    case "brazil" => s"The capital of ${country.trim.toLowerCase()} is Brasília"
    case "canada" => s"The capital of ${country.trim.toLowerCase()} is Ottawa"
    case "india" => s"The capital of ${country.trim.toLowerCase()} is New Delhi"
    case _ => "This country is not recognised or capital is not available"
  }
}

// Call with valid inputs
getCapital("england")
getCapital("france")
// Testing case sensitivity
getCapital("JAPAN")
getCapital("BrAzIl")
// testing blank space handling
getCapital("        Canada      ")
getCapital("India    ")
// testing error/ unknown value handling
getCapital("Germany")





