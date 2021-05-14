package part1recap

import scala.annotation.tailrec
import scala.util.Try

object GeneralRecap extends App {

  val aCondition: Boolean = false

  var aVariable: Int = 42
  aVariable += 1

  // expression
  val aConditionedVal = if (aCondition) 42 else 65

  // code block
  val aCodeBlock = {
    if (aCondition) 74
    56
  }

  // Types
  // Unit
  val theUnit: Unit = println("Hello, scala!")

  def aFunction(x: Int): Int = x + 1

  // recursion - TAIL recursion
  @tailrec
  def factorial(n: Int, acc: Int): Int = {
    if (n <= 0) acc
    else factorial(n - 1, acc * n)
  }

  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog()

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = print("crunch!")
  }

  // Method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog

  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }
  aCarnivore eat aDog

  // Generics
  abstract class MyList[+A]
  // companion objects
  object MyList

  // Case classes
  case class Person(name: String, age: Int)

  // Exceptions
  val aPotentialFailure = try {
    throw new RuntimeException("I'm innocent!")
  } catch  {
    case e: Exception => "Caught"
  } finally {
    println("some logs")
  }

  // Functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  val incremented = incrementer(42)

  val anonIncrementer = (x: Int) => x + 1

  // FP is all about working with functions as first-class
  List(1, 2, 3).map(incrementer)
  // map = HOF

  // for comprehensions
  val pairs = for {
    num <- List(1, 2, 3, 4)
    char <- List('a', 'b', 'c', 'd')
  } yield num + "-" + char
  // List(1, 2, 3, 4).flatMap(num => List('a', 'b', 'c', 'd').map(char => num + "-" + "char))

  // Option and Try
  val anOption = Some(2)
  val aTry = Try {
    throw new RuntimeException
  }

  val unknow = 2
  val order = unknow match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "unknow"
  }

  val bob = Person("Bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"Hi, my name is $n"
    case _ => "I don't know the name"
  }
}
