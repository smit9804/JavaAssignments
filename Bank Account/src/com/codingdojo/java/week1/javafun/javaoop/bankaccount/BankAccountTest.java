package com.codingdojo.java.week1.javafun.javaoop.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount chase = new BankAccount(25000, 30000);
		BankAccount carl = new BankAccount(25, 2902010);
		BankAccount mike = new BankAccount(25000000, 15);
		
		chase.accountDeposit("checking", 65000.00);
		carl.accountDeposit("checking", 25.00);
		mike.accountDeposit("checking", 1000000.00);
		mike.accountWithdraw("checking", 25000.00);
		carl.accountWithdraw("checking", 35.00);
		chase.myBalance();
		carl.myBalance();
		mike.myBalance();
	}

}
