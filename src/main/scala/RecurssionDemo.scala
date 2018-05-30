import scala.annotation.tailrec

class Factorial {
  //Recurssion
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n*factorial(n-1)
  }

  //Now this can be rewritten in terms of a case expression/pattern match: more scala way of doing things
  def fact(n: Int): Int = n match {
    case 0 => 1
    case n => n*fact(n-1)
  }

  //But the problem with this is that as you try to get the factorial for bigger and bigger number
  //JVM needs to create stacks for each recurssion of the fact(), and eventually this can blowup the
  //stack-space. The solution is a tail recurssion where scala re-writes it in terms of loop
  //Also this is an example of a Nested function
  def factorial1(n: Int): Int = {
    //but the tail recursive function modifies the function definition, so wrapped in another function to keep the
    //function signature same i.e. f(n) = n! or takes only one argument
    //Note the tailrec annotation is a safeguard incase someone tries to change it, then compiler will complain
    @tailrec def fact(n: Int, acc: Int): Int = n match {
      case 0 => acc
      case n => fact(n - 1, n * acc)
    }
    fact(n, 1)
  }

  //function literal
  val mLogNfactorial = (m: Int, n: Int) => m*math.log(factorial1(n))
  val expX = (x: Int) => math.exp(x)

  //Higher order functions: function which takes another "function literal" (not a function form) as argument
  //Since the argument is just a data
  def doIt(n: Int, f: Int => Double) = f(n)
}

object RecurssionDemo {
  def main(args: Array[String]): Unit = {
    val fct = new Factorial
    val n = 5;
    println(s"factorial of $n: " + fct.factorial(5))
    println(s"factorial of $n: " + fct.fact(4))
    println(s"factorial of $n: " + fct.factorial1(6))
    println(fct.mLogNfactorial(20, 10))
    println(fct.doIt(3, fct.expX))
  }
}
