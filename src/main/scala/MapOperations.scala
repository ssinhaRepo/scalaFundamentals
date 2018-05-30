object MapOperations {
  def main(args: Array[String]) = {
    val map1 = Map(("alice", 21), "bob" -> 25) // Note the tuple and -> notation, they are same, -> syntactic sugar is used commonly

    //Scala syntactic sugar: (, ) = -> () = .apply()

    //By default Maps are immutable, below operation does not change the map1
    println(map1 + ("rose" -> 23, "del" -> 24))

    val map2 = Map("charley" -> 4, "dana" -> 1, "bob" -> 26) // Note: bob exists in 2 maps, so the value of bob in map2 overwrites the value in map1

    //Concat 2 maps
    val familyMap = map1 ++ map2
    println(familyMap)

    //element check in a map:
    //Get the values for the keys
    println(familyMap("alice"))
    //println(familyMap("raman")) // here jvm will throw key-not-found error for Raman
    //If you don't want jvm to throw the error use .get() method
    println(familyMap.get("raman")) // This will return None (nullable type)

    //getOrElse: return default value if the key is not found, very often used
    println(familyMap.getOrElse("raman", "not a family member"))

    //does map contain the key?
    println(familyMap.contains("raman"))

    println(familyMap.isDefinedAt("bob"))

    //For comprehension with if condition
    // <- is call generator which binds a variable with the collection elements
    for((name, age) <- familyMap if age > 10) {
      println(name)
    }

    //foreach syntax for equivalent for comprehension
    println("for comprehension")
    for(x <- 1 to 3; y <- 2 to 4) {
      println(x+y)
    }

    println("equivalent foreach:")
    (1 to 3).foreach(x => (2 to 4).foreach(y => println(x+y)))
  }

}
