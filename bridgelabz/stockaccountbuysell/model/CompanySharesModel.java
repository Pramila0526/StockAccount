package com.bridgelabz.stockaccountbuysell.model;

import java.util.List;

public class CompanySharesModel {
	private List<CompanyShares> companyShares;

	public List<CompanyShares> getCompanyShares() {
		return companyShares;
	}

	public void setCompanyshares(List<CompanyShares> companyShares) {
		this.companyShares = companyShares;
	}

	@Override
	public String toString() {
		return "CompanySharesModel [companyShares=" + companyShares + "]";
	}

}
