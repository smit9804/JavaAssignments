package com.codingdojo.java.week1.javafun.javaoop.calculator1;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator test1 = new Calculator(4.5, "+", 6.5);
		Calculator test2 = new Calculator(3.6,"-", 1.2);
		Calculator test3 = new Calculator(10.5,"+", 5.2);
		test1.performOperation();
		test2.performOperation();
		test3.performOperation();
		test1.getResults();
		test2.getResults();
		test3.getResults();

	}

}
