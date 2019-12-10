package com.bridgelabz.stockaccountbuysell.model;

import java.util.List;

public class TransactionsModel {
	private List<Transactions> transactions;
	private String transaction;

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "TransactionsModel [transactions=" + transactions + ", transaction=" + transaction + "]";
	}
	
}
