import java.time.LocalDate

/** Create a method called Horoscope. This method should accept a LocalDate and return a tuple of their star sign and their Horoscope. Use Pattern Matching in your method */

// Tuple -
// a value that contains a fixed number of elements, each with its own type.
// Tuples are immutable
// It is handy to return multiple values from methods

// e.g. ("sugar", 25)

/** Plan
 * Create a Method getStarSign(LocalDate) returning starSign
 * If use object starSign extends StarSign we can enumerate Horoscope easier later
 * Create a Method Horoscope(starSign) returning their Horoscope
 * Create a method Horoscope. Call get StarSign, pass this to Horoscope and return the final value*/

sealed trait StarSign

case object Aries extends StarSign
case object Taurus extends StarSign
case object Gemini extends StarSign
case object Cancer extends StarSign
case object Leo extends StarSign
case object Virgo extends StarSign
case object Libra extends StarSign
case object Scorpio extends StarSign
case object Sagittarius extends StarSign
case object Capricorn extends StarSign
case object Aquarius extends StarSign
case object Pisces extends StarSign

// Create an Error Object to return if there is an error
abstract class Error (name: String, errorCode: Int)
case object StarSignNotFound extends Error("StarSign Not found", 404)


object Horoscopes {
  val ariesHoroscope: String = "Important communications regarding finances could come today, Aries, and it might be fortuitous if you follow up on them right away. Once that's done, you'll probably want to relax and delve into whatever interests you the most. It might be a good idea to read a book, since your mind is especially sharp. Take breaks in the fresh air. Ideas and insights should come quickly, so take notes."
  val taurusHoroscope: String = "Your sensual side is likely to show itself today, Taurus. You might find yourself viewing young folks in tight jeans more appreciatively than you usually do. Racy novels and movies might also suddenly seem appealing. Romantic encounters are intense and passionate, so make sure you allow plenty of time for them. Enjoy yourself!\n\nYou are down to earth but you need to believe in something more. A psychic reading can reveal your true path."
  val geminiHoroscope: String = "Ingenious techniques for growing your money could come your way today, Gemini. While you aren't one to jump into anything, you're certainly likely to give these ideas serious thought. Take care to only go for those that are totally up front, with no hidden sides. Your passion for delving into new professional fields is only surpassed by your romantic passions. Plan a seductive evening with a partner. Make it a night to remember!\n\nThe spotlight is on you right now. It is the moment to shine. Reveal your future path with a psychic reading."
  val cancerHoroscope: String = "Today you're likely to be in just the right place at the right time to meet the right person. You're overdue for a lucky break and probably not expecting it. You may start the day in a restless and frustrated state of mind, Cancer, but whatever happens will catapult you out of it. Be prepared - this transition may involve vast changes in your life, in the long run if not immediately.\n\n2024 is an 8 year, which will bring confidence and authority. Find out what that means for you with your 2024 Numerology Horoscope."
  val leoHoroscope: String = "You might wake up this morning, look in the mirror, and decide that you hate what you see even though you probably look fine. This is a good day to shop for new clothes or get a haircut. Perhaps you feel a little blue. Getting out and indulging yourself is more a necessity than luxury. Don't overindulge in food or drink now, Leo. You might not like the consequences tomorrow!"
  val virgoHoroscope: String = "Today you could find yourself seeking self-knowledge through relationships, Virgo, especially through assisting those you love. Someone is troubled and needs your help. It would be best for all if you gave it, because you're especially sensitive and insightful now. You're especially able to soothe others' anger and mediate arguments. Your optimism is very high, and you have what it takes to pass it on to others."
  val libraHoroscope: String = "Do you have a romantic evening planned for tonight, Libra? If so, it's likely to turn out to be all you'd hoped for. You'll be especially attractive, and your naturally warm and loving nature will be very apparent. Even casual encounters with friends may bring about closer bonding, and new acquaintances are likely to become friends. Your communicative skills are good now, and people will likely respond to you. Go for it!"
  val scorpioHoroscope: String = "You could feel restless and anxious to get out in the open for a while today, Scorpio, but mundane tasks could force you to postpone it. Someone you care about might ask for a favor, and while you may not want to help this person, you probably will. Don't let your irritation show - just get it done quickly and accept the person's thanks. In the evening, go for a long walk under the stars."
  val sagittariusHoroscope: String = "At some point during the day you might find yourself involved in a project that piques your interest far more than usual. You could throw yourself more deeply into it than is necessary now. Take care that it doesn't distract you from what needs to be done, Sagittarius. Your wisdom is especially sharp, and you can use your intuition to gain valuable practical knowledge. Spend the evening meditating."
  val capricornHoroscope: String = "Capricorn, are you hoping to accomplish a goal that you've been working toward for a long time? Don't let delays cause you to fear that it will never happen. It could block your creative energy and cause you to lose faith in yourself. Fortunate changes are in the wind, but it's still going to take a little more effort to get where you want to be. Keep going. You'll get there!"
  val aquariusHoroscope: String = "You may be in an especially nurturing mood today, Aquarius. You might reach out to every living thing around you, from plants to pets to friends, children, and romantic partners. There's a danger of being too helpful and supportive, which some could find stifling. Your loved ones like to see you relaxed and happy, so channel some energy into indulging yourself. Go for a massage or other treat. Live a little!"
  val piscesHoroscope: String = "Social responsibilities might appear to be hitting you all at once. Everyone you know seems to crave your company. As a naturally polite and socially astute person, you might feel obligated to accept any and all invitations. This isn't a good day to commit yourself. Wait a while until you're feeling a little more balanced, then send out your responses. Commit only to those events you would genuinely enjoy."
}

object Methods {

  def findStarSign(dateOfBirth: LocalDate): Object = {
    val monthOfBirth = dateOfBirth.getMonthValue
    val dayOfBirth = dateOfBirth.getDayOfMonth

    (monthOfBirth, dayOfBirth) match {
      case (1, day) if day >= 20 && day <= 31 => Aquarius
      case (2, day) if day >= 1 && day <= 18 => Aquarius
      case (2, day) if day >= 19 && day <= 29 => Pisces
      case (3, day) if day >= 1 && day <= 20 => Pisces
      case (3, day) if day >= 21 && day <= 31 => Aries
      case (4, day) if day >= 1 && day <= 19 => Aries
      case (4, day) if day >= 20 && day <= 30 => Taurus
      case (5, day) if day >= 1 && day <= 20 => Taurus
      case (5, day) if day >= 21 && day <= 31 => Gemini
      case (6, day) if day >= 1 && day <= 20 => Gemini
      case (6, day) if day >= 21 && day <= 30 => Cancer
      case (7, day) if day >= 1 && day <= 22 => Cancer
      case (7, day) if day >= 23 && day <= 31 => Leo
      case (8, day) if day >= 1 && day <= 22 => Leo
      case (8, day) if day >= 23 && day <= 31 => Virgo
      case (9, day) if day >= 1 && day <= 22 => Virgo
      case (9, day) if day >= 23 && day <= 30 => Libra
      case (10, day) if day >= 1 && day <= 22 => Libra
      case (10, day) if day >= 23 && day <= 31 => Scorpio
      case (11, day) if day >= 1 && day <= 21 => Scorpio
      case (11, day) if day >= 22 && day <= 30 => Sagittarius
      case (12, day) if day >= 1 && day <= 21 => Sagittarius
      case (12, day) if day >= 22 && day <= 31 => Capricorn
      case (1, day) if day >= 1 && day <= 19 => Capricorn
      case (_, _) => StarSignNotFound
    }
  }

  def returnHoroscope(starSign: StarSign): String = {
    starSign match {
      case Aries => Horoscopes.ariesHoroscope
      case Taurus => Horoscopes.taurusHoroscope
      case Gemini => Horoscopes.geminiHoroscope
      case Cancer => Horoscopes.cancerHoroscope
      case Leo => Horoscopes.leoHoroscope
      case Virgo => Horoscopes.virgoHoroscope
      case Libra => Horoscopes.libraHoroscope
      case Scorpio => Horoscopes.scorpioHoroscope
      case Sagittarius => Horoscopes.sagittariusHoroscope
      case Capricorn => Horoscopes.capricornHoroscope
      case Aquarius => Horoscopes.aquariusHoroscope
      case Pisces => Horoscopes.piscesHoroscope
    }
  }
}

def horoscopeByDOB (dateOfBirth: LocalDate): String = {
  val starSign: Object = Methods.findStarSign(dateOfBirth)
  starSign match {
    case starSign: StarSign =>
      val horoscope: String = Methods.returnHoroscope(starSign)
      horoscope
    case _ => "Star sign not found."
  }
}



// Testing function

val result: String = horoscopeByDOB(LocalDate.of(2024, 10, 8))
println(result)