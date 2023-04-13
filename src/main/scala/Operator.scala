
package com.knoldus

trait Operator extends Validator {
  // validateAndExecute can be defined here
  def validateAndExecute(operands :Seq[Double]):Seq[Double] ={
    if (validate(operands)) {
      execute(operands)
    } else throw new Exception("Operator not found ")
  }
  def execute(operands :Seq[Double]):Seq[Double]

}
