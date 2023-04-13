package com.knoldus
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Driver extends App {

  // different variable used to pass values in different methods
  private val seq = Seq(4.0, 2.0)
  private val seqOfSingleValue = Seq(4.0)
  private val seqForFind = Seq(3.0,8.0,15.0)
  private val seqAverage = Seq(2.0,4.0,6.0)

  /*
  Different methods can be call via object to method to execute the methods
   */
  private val additionResult =  Calculator.calculate("+", seq)
  additionResult.onComplete {
    case Success(value) => println("Addition "+value)
    case Failure(ex) => println(ex.getMessage)
  }

  private val subtractionResult = Calculator.calculate("-", seq)
  subtractionResult.onComplete {
    case Success(value) => println("Subtraction"+value)
    case Failure(exception) => println(exception.getMessage)
  }
  private val multiplicationResult = Calculator.calculate("*", seq)
  multiplicationResult.onComplete {
    case Success(value) => println("Multiplication"+value)
    case Failure(exception) => println(exception.getMessage)
  }
  private val divisionResult = Calculator.calculate("/", seq)
  divisionResult.onComplete {
    case Success(value) => println("Division "+value)
    case Failure(exception) => println(exception.getMessage)
  }
  private val powerResult = Calculator.calculate("^", seq)
  powerResult.onComplete {
    case Success(value) => println("Power "+value)
    case Failure(exception) => println(exception.getMessage)
  }
  private val sqrtResult = Calculator.calculate("sqrt",seqOfSingleValue)
  sqrtResult.onComplete {
    case Success(value) => println("Square root"+value)
    case Failure(exception) => println(exception.getMessage)
  }
  private val factorialResult = Calculator.calculate("!",seqOfSingleValue)
  factorialResult.onComplete {
    case Success(value) => println("Factorial "+value)
    case Failure(exception) => println(exception.getMessage)
  }
  private val addAllOperandsResult = Calculator.calculate("sum", seq)
  addAllOperandsResult.onComplete {
    case Success(value) => println( "AddAllOperands "+value)
    case Failure(exception) => println(exception.getMessage)
  }

  private val gcdResult = Calculator.calculate("gcd", seq)
  gcdResult.onComplete {
    case Success(value) => println(s"GCD: $value")
    case Failure(exception) => println(exception.getMessage)
  }

  private val evenResult = Calculator.calculate("even", seq)
  evenResult.onComplete {
    case Success(value) => println(s"Even : $value")
    case Failure(exception) => println(exception.getMessage)
  }
  private val oddResult = Calculator.calculate("odd", seq)
  oddResult.onComplete {
    case Success(value) => println(s"odd: $value")
    case Failure(exception) => println(exception.getMessage)
  }

  private val fibonacciResult = Calculator.calculate("fibonacci", seqOfSingleValue)
  fibonacciResult.onComplete {
    case Success(value) => println(s"fibonacci: $value")
    case Failure(exception) => println(exception.getMessage)
  }

  private val resultOfSquareOfExpression = Calculator.squareOfExpression(6,2)
  println( "resultOfSquareOfExpression "+resultOfSquareOfExpression)

  private val findResult = Find.find(seqForFind)
  findResult.onComplete {
    case Success(value) => println(s"find : $value")
    case Failure(exception) => println(exception.getMessage)
  }

  private val findAverageResult = FindAverages.findAverageAfterChainingOperations(seqAverage)
  findAverageResult.onComplete {
    case Success(value) => println(s"findAverages : $value")
    case Failure(exception) => println(exception.getMessage)
  }
}
