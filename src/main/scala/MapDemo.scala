object MapDemo {
  def main(args: Array[String]): Unit ={
    var emptyMap:Map[Char, Int] = Map()

    var countryMap = Map("US" -> 1, "UK" -> 44, "India" -> 91)
    //countryMap + = ("DE" -> 276)
    //countryMap + = ("AU" -> 36)
    println(countryMap)
    println(countryMap("India"))

    //Iterate over the keys and values
    countryMap.keys.foreach { i =>
      print("Key = " + i)
      println(" -> value = " + countryMap(i))
    }

    //Find for a key
    if(countryMap.contains("India")) {
      println("country code for India: " + countryMap("India"))
    }
    if (countryMap.contains("Brazil")) {
      println("country code for Brazil = " + countryMap("Brazil"))
    } else {
      println("Country does not exist in the Map!")
    }
  }
}
