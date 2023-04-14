
package com.knoldus
import scala.concurrent.Future
import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.math.pow


/*
Calculator object contains all the basic calculator methods which take operator type and operands
 */
object Calculator {

  //Square of Expression executes particular Expression
  def squareOfExpression(firstOperand: Double, secondOperand: Double): String = {
    val result = math.pow((firstOperand + secondOperand), 2) == (math.pow((firstOperand), 2) + math.pow(secondOperand, 2) + (2 * firstOperand * secondOperand))
    if (result) "Equal" else "Not Equal"
  }

  /*
  calculator contains different methods
   */
  def calculate(operator: String, operands: Seq[Double]): Future[Seq[Double]] = {
    operator match {
      case "+" => execute(Addition, operands)
      case "-" => execute(Subtraction, operands)
      case "*" => execute(Multiplication, operands)
      case "/" => execute(Division, operands)
      case "^" => execute(Power, operands)
      case "sqrt" => execute(SquareRoot, operands)
      case "!" => execute(new Factorial, operands)
      case "sum" => execute(AddAllOperands, operands)
      case "gcd" => execute(Gcd, operands)
      case "odd" => execute(OddNumber, operands)
      case "even" => execute(EvenNumber, operands)
      case "fibonacci" => execute(new Fibonacci, operands)
      case _ => throw new IllegalArgumentException("not a valid operator")
    }
  }
  def execute(operator: Operator, operands: Seq[Double]): Future[Seq[Double]] = {
    Future {
      operator.validateAndExecute(operands)
    }
  }
}

/*
Every object contains Different operations
 */

object Addition extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands(0) + operands(1))
  }
}

object Subtraction extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands(0) - operands(1))
  }
}

object Multiplication extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands(0) * operands(1))
  }
}

object Division extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2 && operands(1) != 0
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands(0) / operands(1))
  }
}

object Power extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(math.pow(operands.head, operands(1)))
  }
}

object SquareRoot extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(math.sqrt(operands.head))
  }
}

class Factorial extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(factorial(operands.head))
  }
  def factorial(number: Double, accumulator: Double = 1): Double = {
    if (number == 0.0) accumulator
    else factorial(number - 1, accumulator * number)
  }
}


object AddAllOperands extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(addAll(operands))
  }
  // Helper method to add up all the operands
  private def addAll(operands: Seq[Double]): Double = {
    if (operands.isEmpty) {
      0.0
    } else {
      operands.head + addAll(operands.tail)
    }
  }
}

object Gcd extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2
  override def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(getGcd(operands(0), operands(1)))
  }
  @tailrec
  private def getGcd(first: Double, second: Double): Double = {
    if (second == 0) first else getGcd(second, first % second)
  }
}

object EvenNumber extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty
  override def execute(operands: Seq[Double]): Seq[Double] = {
    val evenNumber = operands.filter(value =>value % 2 == 0)
    evenNumber
  }
}

object OddNumber extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty
  override def execute(operands: Seq[Double]): Seq[Double] = {
    val oddNumber = operands.filter(value => value % 2 != 0)
    oddNumber
  }
}

class Fibonacci extends Operator {
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1
  override def execute(operands: Seq[Double]): Seq[Double] = {
    val numTerms = operands(0).toInt
    val fibonacciSeries = getFibonacciSeries(numTerms)
    fibonacciSeries.map(_.toDouble)
  }
  def getFibonacciSeries(numTerms: Int): Seq[Int] = {
    if (numTerms <= 0) Seq.empty
    else if (numTerms == 1) Seq(0)
    else if (numTerms == 2) Seq(0, 1)
    else {
      val series = getFibonacciSeries(numTerms - 1)
      series :+ series.takeRight(2).sum
    }
  }
}


object Find extends Factorial {
  def find(numbers: Seq[Double]): Future[Seq[Double]] = {
    Future {
      numbers.filter(numbers => factorial(numbers, 1) > pow(6, numbers))
    }
  }
}

object FindAverages extends Fibonacci {
  def findAverageAfterChainingOperations(numbers: Seq[Double]): Future[Double] = {
    Future {
      val fibonacciSeries = numbers.map {
        value => getFibonacciSeries(value.toInt)
      }
      val result = fibonacciSeries.flatten.filter(f => f % 2 != 0)
      result.sum / numbers.length
    }
  }
}
