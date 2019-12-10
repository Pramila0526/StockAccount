package com.bridgelabz.stockaccountbuysell.model;



public class Transactions {
	private String transactionId;
	private int transactionAmount;
	private String buyer;
	private String seller;
	
   private String dateTime;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount + ", buyer="
				+ buyer + ", seller=" + seller + ", dateTime=" + dateTime + "]";
	}

}

