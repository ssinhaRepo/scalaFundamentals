import java.time.LocalDateTime

class MatchAnyType {
  //match any type
  def matchType(x: Any) = x match {
    case _: Int => println("It's an Int")
    case _: String => println("It's a String")
    case _ => println("something else")
  }

  //bind a parameter to the case match type
  def bind(x: Any) = x match {
    case n: Int => println(s"the Int is: $n")
    case s: String => println(s"the string is: $s")
    case default => println(s"something else: $default!") //default is just a name to bind the argument x for use such as $default
  }

  //match with multiple parameters
  //Note: this is against a single value type or tuple, not against individual elements
  def multiMatch(x: Int, y: Int) = (x, y) match {
    case (1, 1) => println("1, 1")
    case (_, 2) => println("last element is 2")
    case (_, _) => println("match any 2 pair!")
  }
}

//Now let's demonstrate the pattern matching for an object (even though it's a reference, using scala case class
// we can treat it just like a simple value type used in the above tuple matching)
case class CashFlow(amount: Double, curreny: String, due: LocalDateTime) //empty body, hence no need of {}

case class Address(city: String, country: String)

case class Person(name: String, age: Int, address: Address)

object PatternMatching {

  def main(args: Array[String]) = {
    val n = 3

    n match {
      case 1 | 3 | 5 => println("n is odd")
      case 2 | 4 | 6 | 8 => println("n is even")
      case _ => println("Something else!")
    }

    val anyType = new MatchAnyType
    anyType.matchType("Hi there!")
    anyType.matchType(101)

    anyType.bind(7)
    anyType.bind("Hello dear!")
    anyType.bind(5.64)

    anyType.multiMatch(1, 2)
    anyType.multiMatch(3, 5)

    //Note there is no new keyword, since it's treated as a value like
    val cashFlow = CashFlow(1000.99, "GBP", LocalDateTime.now)

    cashFlow match {
      case CashFlow(v, "USD", _) => println(s"Due: $v usd")
      case CashFlow(v, "GBP", _) => println(s"Due: $v gbp")
    }

    val address1 = Address("San Fransisco", "USA")
    val address2 = Address("Calcutta", "India")

    val person1 = Person("Sourabh", 36, address1)
    val person2 = Person("Uttam", 56, address2)

    person1 match {
      case Person(name, _, Address(_, country)) => println(s"$name lives in $country")
    }

    //match with condition or filter
    person2 match {
      case Person(n, a, _) if a > 50 => println(s"$n is $a years old")
      case Person(n, a, _) if a <= 20 => println(s"$n is a young star!")
    }

  }
}


