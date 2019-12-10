package com.bridgelabz.stockaccountbuysell.model;


public class CompanyShares {

	private int companySymbol;
	private String companyName;
	private int companyShares;
	private int companySharePrice;
	private int companyTotalValue;

	public int getCompanySymbol() {
		return companySymbol;
	}

	public void setCompanySymbol(int companySymbol) {
		this.companySymbol = companySymbol;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyShares() {
		return companyShares;
	}

	public void setCompanyShares(int companyShares) {
		this.companyShares = companyShares;
	}

	public int getCompanySharePrice() {
		return companySharePrice;
	}

	public void setCompanySharePrice(int companySharePrice) {
		this.companySharePrice = companySharePrice;
	}

	public int getCompanyTotalValue() {
		return companyTotalValue;
	}

	public void setCompanyTotalValue(int companyTotalValue) {
		this.companyTotalValue = companyTotalValue;
	}

	@Override
	public String toString() {
		return "CompanyShares [companySymbol=" + companySymbol + ", companyName=" + companyName + ", companyShares="
				+ companyShares + ", companySharePrice=" + companySharePrice + ", companyTotalValue="
				+ companyTotalValue + "]";
	}

}
