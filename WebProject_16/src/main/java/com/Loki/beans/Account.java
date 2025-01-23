package com.Loki.beans;

public class Account {
    private String accNo;
    private String accHolderName;
    private String accType;
    private double balance;
    private String accBranch;
    private String accBank;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accNo, String accHolderName, String accType, double balance, String accBranch,
			String accBank) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.balance = balance;
		this.accBranch = accBranch;
		this.accBank = accBank;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accHolderName=" + accHolderName + ", accType=" + accType + ", balance="
				+ balance + ", accBranch=" + accBranch + ", accBank=" + accBank + "]";
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccBranch() {
		return accBranch;
	}
	public void setAccBranch(String accBranch) {
		this.accBranch = accBranch;
	}
	public String getAccBank() {
		return accBank;
	}
	public void setAccBank(String accBank) {
		this.accBank = accBank;
	}
}
