//Note: + sign before the generic type T, this is given to be able to use the supertype of T
class GenericClass[+T] (val value:T) {
  def printIt = println("passed value of type: " + value.getClass)

}

class OnePerson

class Employee extends OnePerson



object GenericsDemo {
  def main(args: Array[String]): Unit = {
    val genericTypeInt = new GenericClass(3)
    val genericTypeStr = new GenericClass("three")
    genericTypeInt.printIt
    genericTypeStr.printIt

    val p1 = new GenericClass(new Employee)
    //Note Below: OnePerson is a supertype of Employee, we had to use +T in GenericClass definition to be able to use this
    val p2: GenericClass[OnePerson] = p1

    p1.printIt

    GenericsDemo.matchList(List(1, 2))
    GenericsDemo.matchList(List(1.01, 2))

    GenericsDemo.printList(List("one", 2, "three", 4, 5.0, true))

  }

  def matchList[T](lst: List[T]) = lst match {
    case Nil => println("empty List") //Nil is same as List()
    case List(_) => println("any one element list")
    case List(1, _) => println("2 element list with first element = 1")
    case List(_, _) => println("any 2 elements list")
  }

  //Tail recurssion to access all the elements of a list without using an iterator
  def printList[T](lst: List[T]): Unit = lst match {
    //if empty list then stop
    case Nil => println("Done!")
    // else break the list in head element and a tail list and keep printing the head element recurssively until get an empty list
    case h :: t =>
      println(s"$h")
      //Rucerssive call
      printList(t)
  }

}

