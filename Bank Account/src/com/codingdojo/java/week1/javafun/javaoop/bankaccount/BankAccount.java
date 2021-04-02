package com.codingdojo.java.week1.javafun.javaoop.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber = "";
	private Double checking;
	private Double savings;
	public static int accountsCreated = 0;
	public static Double totalMoney = 0.00;
	
	public BankAccount(double checking, double savings) {
		String accountNumber = newAccountNumber();
		this.checking = checking;
		this.savings = savings;
		System.out.println("New account created with the account number of: " + accountNumber + ".");
		accountsCreated += 1;
	}
		
	private String newAccountNumber() {
		String nums = "0123456789";
		String rando = "";
			
		Random rands = new Random();
		for (int i=0; i<10; i++) {
			char num = nums.charAt(rands.nextInt(10));
			rando += num;
			}
		accountNumber = rando;
		return rando;
	}
	
	public void setChecking (Double checking) {
		this.checking = checking;
	}
	public void setSavings (Double savings) {
		this.savings = savings;
	}
	
	public Double getCheckingBalance () {
		return checking;
	}
	public Double getSavingsBalance () {
		return savings;
	}
	public void accountDeposit(String type, Double depositAmount) {
		if (type == "checking") {
			setChecking(getCheckingBalance()+ depositAmount);
			totalMoney += depositAmount;
		}
		else if (type == "savings") {
			setSavings(getSavingsBalance()+ depositAmount);
			totalMoney += depositAmount;
		}
		else {
			System.out.print("Please pick a valid account type");
		}
	}
	
	public void accountWithdraw(String type, Double withdrawAmount) {
		if(type == "checking") {
			if(getCheckingBalance() < withdrawAmount){
				System.out.println("Insufficient funds!");
			}
			else {
				setChecking(getCheckingBalance()- withdrawAmount);
				totalMoney -= withdrawAmount;
			}
		}
		if (type == "savings") {
			if(getSavingsBalance() < withdrawAmount) {
				System.out.println("Insufficient funds!");
			}
			else{
				setSavings(getSavingsBalance()- withdrawAmount);
				totalMoney -= withdrawAmount;
			}
		}
	}
	public Double myBalance() {
			Double totalBalance = checking + savings;
			System.out.println(totalBalance);
			return totalBalance;
	}
}

