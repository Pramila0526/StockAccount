package com.bridgelabz.stockaccountbuysell.model;



public class CustomerShares {

	private int customerSymbol;
	private String customerName;
	private int customerShares;
	private int customerBalance;
	
	
	

	public int getCustomerSymbol() {
		return customerSymbol;
	}

	public void setCustomerSymbol(int customerSymbol) {
		this.customerSymbol = customerSymbol;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerShares() {
		return customerShares;
	}

	public void setCustomerShares(int customerShares) {
		this.customerShares = customerShares;
	}
   
	public int getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}

	@Override
	public String toString() {
		return "CustomerShares [customerSymbol=" + customerSymbol + ", customerName=" + customerName
				+ ", customerShares=" + customerShares + ", customerBalance=" + customerBalance + "]";
	}

}
