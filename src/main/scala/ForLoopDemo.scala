object ForLoopDemo {
  //def main(args : Array[String]) : Unit = {

  //}

  def main(args: Array[String]) {
    for (i <- 1.to(4); j <- 1 until 4) {
      println("i = "+ i + ", j = " + j + "; i*j = " + i*j)
    }


    val lst = List(1, "apple", 2, "banana")
    for (i <- lst) {
      println(i)
    }

    val intLst = List(1, 3, 5, 7, 11, 13, 17)
    val filtList = for {i <- intLst; if i < 10} yield {
      i*i
    }

    println(filtList)
  }
}
