package com.bridgelabz.stockaccountbuysell.model;



import java.util.List;

public class CustomerSharesModel {
	
	private List<CustomerShares> CustomerShares;

	public List<CustomerShares> getCustomerShares() {
		return CustomerShares;
	}

	public void setCustomerShares(List<CustomerShares> customerShares) {
		this.CustomerShares = customerShares;
	}

	@Override
	public String toString() {
		return "CustomerSharesModel [CustomerShares=" + CustomerShares + "]";
	}
}
