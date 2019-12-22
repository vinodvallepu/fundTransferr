package com.hcl.dto;

public class TransactionDto {
	
	private Integer fromAccount;
	private Integer toAccount;
	private double amount;
	public Integer getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Integer getToAccount() {
		return toAccount;
	}
	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}


}
