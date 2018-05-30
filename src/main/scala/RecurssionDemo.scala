class Factorial {
  //Recurssion
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n*factorial(n-1)
  }

  //Higher order functions: function which takes another function as argument
/*  val mLogNfactorial = (m: Int) => Int {

  }
*/

}

object RecurssionDemo {
  def main(args: Array[String]): Unit = {
    val fact = new Factorial
    val n = 5;
    println(s"factorial of $n: " + fact.factorial(5))
  }
}
