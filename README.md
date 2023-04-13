# Session5CalculatorAssignment

Calculator Application in Scala

This project contains a Calculator object which contains different calculator methods that can perform basic arithmetic operations such as addition, subtraction, multiplication, and division, as well as advanced operations such as finding the square root, factorial, GCD (greatest common divisor), and Fibonacci series. It also contains methods to filter odd and even numbers and sum all the operands.

Usage
To use the calculator, first, import the Calculator object from the com.knoldus package. The calculate method is used to perform calculations.

import com.knoldus.Calculator
val result = Calculator.calculate("+", Seq(2.0, 3.0))
println(result) // Future(Success(Seq(5.0)))

The first argument to the calculate method is the operator to use, and the second argument is the sequence of operands to apply the operator to.


Supported operators
The following operators are supported by the calculator:

+ (addition)
- (subtraction)
* (multiplication)
/ (division)
^ (exponentiation)
sqrt (square root)
! (factorial)
sum (sum of all operands)
gcd (greatest common divisor)
odd (filter odd numbers)
even (filter even numbers)
fibonacci (Fibonacci series)

Architecture

The calculator uses the object-oriented programming (OOP) paradigm and includes an Operator trait, which defines the methods that all operators must implement. Each operator is defined as an object that extends the Operator trait. The calculate method of the Calculator object takes an operator and a sequence of operands and returns a Future that contains the result of applying the operator to the operands.


Examples

Addition

import com.knoldus.Calculator
val result = Calculator.calculate("+", Seq(2.0, 3.0))
println(result) // Future(Success(Seq(5.0)))

Subtraction

import com.knoldus.Calculator
val result = Calculator.calculate("-", Seq(5.0, 3.0))
println(result) // Future(Success(Seq(2.0)))

Multiplication

import com.knoldus.Calculator
val result = Calculator.calculate("*", Seq(2.0, 3.0))
println(result) // Future(Success(Seq(6.0)))

Division

import com.knoldus.Calculator
val result = Calculator.calculate("/", Seq(6.0, 3.0))
println(result) // Future(Success(Seq(2.0)))



Output -> 

![Calculator](https://user-images.githubusercontent.com/124980051/231888233-8ff9e988-33f7-49b5-acf8-9272465b4bb7.png)



