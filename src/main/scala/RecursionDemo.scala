object RecursionDemo {
  def main(args: Array[String]): Unit = {
    println("5! = " + factorial(5))
  }

  def factorial(n: Int) : BigInt = {
    if(n <= 1) {
      1
    } else {
      n* factorial(n - 1)
    }
  }

}
