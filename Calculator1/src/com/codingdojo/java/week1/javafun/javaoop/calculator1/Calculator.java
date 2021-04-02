package com.codingdojo.java.week1.javafun.javaoop.calculator1;

public class Calculator {
	private Double operandOne;
	private String operation;
	private Double operandTwo;
	private Double math;
	
	public Calculator() {
		}
	public Calculator(Double operandOne, String operation, Double operandTwo) {
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
	}
	public void setOperandOne(Double operandOne) {
		this.operandOne = operandOne;
	}
	public Double getOperandOne() {
		return operandOne;
	}
	public void setOperandTwo(Double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public Double getOperandTwo() {
		return operandTwo;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperation() {
		return operation;
	}
	public void setMath(Double math) {
		this.math = math;
	}
	public Double getMath() {
		return math;
	}
	
	
	public void performOperation() {
		if(getOperation().equals(("+"))) {
			Double total = getOperandOne() + getOperandTwo();
			math = total;
		}
		if(getOperation().equals(("-"))) {
			Double total = getOperandOne() - getOperandTwo();
			math = total;
		}
	}
	public void getResults() {
		System.out.println(getMath());
	}
}
