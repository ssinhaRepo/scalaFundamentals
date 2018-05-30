object SetDemo {
  def main(args: Array[String]): Unit = {
    val set1:Set[Int] = Set()
    val set2:Set[Int] = Set(1, 4, 6, 1)
    val set4:Set[Int] = Set(1, 43, 6)
    val set3:Set[String] = Set("Saana", "Rehaan")

    println(set2.head)
    println(set2.tail)
    println(set1.isEmpty)
    println(set2.min)
    println(set2.max)
    println(set2.&(set4)) //intersection
    println(set2.&~(set4)) //difference
    println(set4.&~(set2))
    println(set2.intersect(set4))
    println(set2.union(set4))


    //var concatSet1 = set2 ++ set3
    var concatSet1 = set2.++(set3)
    println(concatSet1)
  }

}
