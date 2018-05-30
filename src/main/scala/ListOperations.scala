object ListOperations {
  def main(args: Array[String]): Unit = {
    val listOfLists = List(
      List(1, 2, 3),
      List("four", "five"),
      List(), //null element
      List(-2.4, false)
    )

    val lst = List(1, 2, 3, 4, 5)

    //Filter operation, note: the lambda expression in the filter argument
    println(lst.filter(n=> n%2 == 0))

    //list.map: maps n to n+2 for the list elements: Note the lambda operation
    println(lst.map(n => n+2))
    //shorthand version of above lambda, the _ can be used if n occurs at the first element of the left side expression like here
    println(lst.map(_+2))

    //Flatten the nested list and ignore the empty list in it: Think of data cleaning
    println(listOfLists.flatten)

    //Flatten the nested list, ignore empty list, do some operation on the list: think of mapping after flattening
    val listOfEmps = List(
      List("ryan"),
      List("ani", "amit"),
      List(),
      List("clyde", "alex", "vidya")
    )

    println(listOfEmps.flatten.map(c => c.capitalize))
    //instead use flatmap function where you can pass the map on the elements
    println(listOfEmps.flatMap(c => c.map(s => s.capitalize)))
    //shorthand notation for the lambda function using _
    println(listOfEmps.flatMap(_.map(_.capitalize)))

    //However, note that with the lambda function I could not use the same list to capitalize since there are numbers
    // so instead of lambda, we can use a partial-function (case) and can handle string, and non-strings separately
    println(listOfLists.flatten.map(
        {
          case s:String => s.capitalize
          case s: Int => s
          case s: Double => s
          case s: Boolean => s
        }
      )
    )

    //The problem with this method is that we need to handle every type of Types, which we may not know, but most importantly
    // we don't care about, all we care is that capitalize if the element is a String, else ignore. Use 'collect' instead of map
    println(listOfLists.flatten.collect(
        {
          case s: String => s.capitalize
        }
      )
    )

    //Fold is similar terminology for Reduce in the functional programing world
    val intList = List(1, 2, 4, 8)

    //Sum all the elements of the list. Note 0 is the initial value of the accumulator, since we are summing
    println(intList.foldLeft(0)(
      (acc, nxt) => acc + nxt
    ))
    //Similarly product of all the elements
    println(intList.foldLeft(1)(
      (acc, nxt) => acc*nxt
    ))

    //Imagine you have to concatinate the elements of a list. Just note that in the background it's calling multiple intermediate StringBuiler
    // objects to manipulate the interm strings, which may cause performance issue due to heavy load on garbage collection
    // This could be a drawback using this method, may be simply iterating over the list will be better
    val strList = List(1, ": one, ", 2, ": two, ", 3, ": three")
    println(strList.foldLeft("")(
      (acc, nxt) => acc + nxt
    ))

    //Now we have a well defined list, why do we need to provide any starting point? Well we have another function called
    //Reduce which does away with exactly that

    println(intList.reduce((a,b) => a+b))
    println(strList.reduce((a,b) => a.toString+b.toString)) //reduce expects all the elements should be of same type
    //Note idiomatically we can get away with typing the same variables a, b... by using _ since they are occur at the same order
    //let's use the shorthand for the multiplication case
    println(intList.reduce((_*_)))

    //Examples of the foldLeft/reduce functions with generic functions: May not be the most efficient way of doing since the time
    //complexity is mostly linear with the size

    //Example 1: find out if an element exists in a list
    def elementExists[T](lst: List[T], e: T) = {
      lst.foldLeft(false)((a, b) => a || b == e)
    }

    println(elementExists(intList, 12))

    //Example 2: Reverse the elements of a list
    println(intList.reverse)
    //but if I were to write a generic function to do it
    def reverseList[T](lst: List[T]): List[T] = {
      lst.foldLeft(List[T]())((a, b) => b :: a)
    }

    println(reverseList(intList))

    //For comprehension for list
    val itemPrice = List(
      List(1000, 800, 20),
      List(),
      List(240, 1320)
    )

    //return a list of prices + prices*0.1 where the prices are >= 1000
    //For comprehension way
    println(for {
      ip <- itemPrice
      p <- ip
      if p >= 1000
    } yield p + p*0.1)

    //functional way of doing
    println(itemPrice.flatMap(ip => ip.filter(p => p >= 1000).map(p => p + 0.1*p)))
  }
}
