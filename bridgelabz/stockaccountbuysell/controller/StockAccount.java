package com.bridgelabz.stockaccountbuysell.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.stockaccountbuysell.model.CompanyShares;
import com.bridgelabz.stockaccountbuysell.model.CompanySharesModel;
import com.bridgelabz.stockaccountbuysell.model.CustomerShares;
import com.bridgelabz.stockaccountbuysell.model.CustomerSharesModel;
import com.bridgelabz.stockaccountbuysell.model.Transactions;
import com.bridgelabz.stockaccountbuysell.model.TransactionsModel;
import com.bridgelabz.stockaccountbuysell.repository.JsonUtil1;
import com.bridgelabz.stockaccountbuysell.util.StockUtility;

public class StockAccount {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		int customerId;
		int companySymbol;
		int numberOfCompanySharesToBuy;

		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter dateTimeFormat2 = DateTimeFormatter.ofPattern("HHmmss");

		CompanySharesModel companyModel = new CompanySharesModel();
		CustomerSharesModel customerModel = new CustomerSharesModel();
		TransactionsModel transactionModel = new TransactionsModel();

		// paths of files
		String pathForCompanyShares = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccountBuySell/CompanyShares.json";
		String pathForCustomerShares = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccountBuySell/CustomerShares.json";

		String pathForCompanyShares2 = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccountBuySell/CompanyShares2.json";
		String pathForCustomerShares2 = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccountBuySell/CustomerShares2.json";

		String pathForTransaction = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccountBuySell/Transactions.json";
		// code for fetching json data and put it into models

		// code for fetching the company shares
		ObjectMapper mapper = new ObjectMapper();
		companyModel = mapper.readValue(new File(pathForCompanyShares), CompanySharesModel.class);
		// compModel = (CompanySharesModel) JsonUtil1.readMapper(pathForCompanyShares,
		// compModel);

		// code for fetching the customer info
		customerModel = mapper.readValue(new File(pathForCustomerShares), CustomerSharesModel.class);
		// custModel = (CustomerSharesModel) JsonUtil1.readMapper(pathForCustomerShares,
		// custModel);

		File file = new File(pathForTransaction);
		//transactionModel = mapper.readValue(new File(pathForTransaction), TransactionsModel.class);
		if (file.length() != 0)
		{
			// transModel = (TransactionsModel) JsonUtil1.readMapper(pathForTransaction,
			// transModel);
			transactionModel = mapper.readValue(new File(pathForTransaction), TransactionsModel.class);
		}

		List<CompanyShares> companyList = new ArrayList<>();
		
		List<CustomerShares> customerList = new ArrayList<>();
		
		List<Transactions> transactionList = new ArrayList<>();

		companyList.addAll(companyModel.getCompanyShares());
		
		customerList.addAll(customerModel.getCustomerShares());
		
	
		if(!transactionModel.getTransactions().isEmpty())
		{
			transactionList.addAll(transactionModel.getTransactions());
		}
		
		int indexOfCustomer = 0;

		int indexOfCompany = 0;

		System.out.println("===Welcome to Share Transactions===");
		System.out.println();
		System.out.println("Please Enter Customer Symbol");
		customerId = StockUtility.integerInput();
		boolean isCustomerFound = false;
		for (int i = 0; i < customerList.size(); i++) {
			if (customerId == customerList.get(i).getCustomerSymbol()) {
				isCustomerFound = true;
				indexOfCustomer = i;
				break;
			}
		}
		boolean isExit = false;

		int choice;
		if (isCustomerFound) {
			while (!isExit) {
				System.out.println("====Welcome!!" + customerList.get(indexOfCustomer).getCustomerName() + "====");
				System.out.println();
				System.out.println("Operations to Perform");
				System.out.println();
				System.out.println("1) Sell Shares");
				System.out.println("------------------");
				System.out.println("2) Buy Shares");
				System.out.println("------------------");
				System.out.println("3) Display Shares");
				System.out.println("------------------");
				System.out.println("4) Exit");
				System.out.println("------------------");
				System.out.println();
				System.out.println("Please Select the Option");
				choice = StockUtility.integerInput();
				System.out.println();
				switch (choice) {
				case 1:
				                                     //Code For Selling the shares
					System.out.println("=====Sell Shares=====");

					System.out.println("Enter the number of shares you want to sell");

					int sharetoSell = StockUtility.integerInput();

					System.out.println("Please Enter the company symbol to whom you want to sell Your Shares: ");
					companySymbol = StockUtility.integerInput();

					boolean isCompanyFound2 = false;
					for (int i = 0; i < companyList.size(); i++) {
						if (companySymbol == companyList.get(i).getCompanySymbol()) {
							isCompanyFound2 = true;
							indexOfCompany = i;
							break;
						}
					}

					// if company is valid
					if (isCompanyFound2) {
						System.out.println(
								"The company you have selected is:- " + companyList.get(indexOfCompany).getCompanyName());
						System.out.println("Company shares:- " + companyList.get(indexOfCompany).getCompanyShares());
						System.out
								.println("Company share price: " + companyList.get(indexOfCompany).getCompanySharePrice());
						int amountToGet = sharetoSell * companyList.get(indexOfCompany).getCompanySharePrice();
						System.out.println("Amount you will get is:- " + amountToGet);
						// company share increase
						if (sharetoSell <= customerList.get(indexOfCustomer).getCustomerShares()) {
							companyList.get(indexOfCompany)
									.setCompanyShares(companyList.get(indexOfCompany).getCompanyShares() + sharetoSell);
							// company value increase
							companyList.get(indexOfCompany)
									.setCompanyTotalValue(companyList.get(indexOfCompany).getCompanySharePrice()
											* companyList.get(indexOfCompany).getCompanyShares());

							// customer share decrease
							customerList.get(indexOfCustomer)
									.setCustomerShares(customerList.get(indexOfCustomer).getCustomerShares() + sharetoSell);

							// customer balance increase

							customerList.get(indexOfCustomer).setCustomerBalance(
									customerList.get(indexOfCustomer).getCustomerBalance() + amountToGet);

							// code reflecting transaction
							Transactions trans = new Transactions();
							LocalDateTime now = LocalDateTime.now();

							String transId = dateTimeFormat2.format(now)
									+ customerList.get(indexOfCustomer).getCustomerSymbol()
									+ companyList.get(indexOfCompany).getCompanySymbol();
							trans.setTransactionId(transId);
							trans.setBuyer(companyList.get(indexOfCompany).getCompanyName());
							trans.setSeller(customerList.get(indexOfCustomer).getCustomerName());
							trans.setTransactionAmount(sharetoSell * companyList.get(indexOfCompany).getCompanySharePrice());
							trans.setDateTime(dateTimeFormat.format(now));

							transactionList.add(trans);

							int saveOperation;
							System.out.println("====Opeartions to Perform are====");
							System.out.println();
							System.out.println("Press 1 For Saving");
							System.out.println("-------------------------------------");
							System.out.println("Press 2 For Continuing without saving");
							System.out.println("-------------------------------------");
							System.out.println("Enter Your Choice");
							System.out.println();
							saveOperation = StockUtility.integerInput();
							if (saveOperation == 1) {
								JsonUtil1.writeMapper(pathForCompanyShares2, companyModel.getCompanyShares());
								JsonUtil1.writeMapper(pathForCustomerShares2, customerModel.getCustomerShares());
								transactionModel.setTransactions(transactionList);
								transactionModel.setTransaction("Transactions");
								JsonUtil1.writeMapper(pathForTransaction, transactionModel);
								System.out.println("Transaction has saved");
							} else if (saveOperation == 2) {
								System.out.println("Transaction not saved");
							} else
								
								System.out.println("Transaction get void");

						} else {
							System.out.println("You dont have "+sharetoSell+" shares to Buy");
						}

					} else
						System.out.println("Entered Company Symbol doesn't Exists");

					System.out.println("---------------------------------------");
					break;

				case 2:
					// buy

					System.out.println("======Buy Shares=====");

					System.out.println("Please Enter Company Symbol/ID: ");
					companySymbol = StockUtility.integerInput();

					boolean isCompanyFound = false;
					for (int i = 0; i < companyList.size(); i++) {
						if (companySymbol == companyList.get(i).getCompanySymbol()) {
							isCompanyFound = true;
							indexOfCompany = i;
							break;
						}
					}

					System.out.println("Company Name: " + companyList.get(indexOfCompany).getCompanyName());

					System.out.println("Company Shares: " + companyList.get(indexOfCompany).getCompanyShares());

					System.out.println("Company Share price: " + companyList.get(indexOfCompany).getCompanySharePrice());

					int customerBalance = customerList.get(indexOfCustomer).getCustomerBalance();
					System.out.println("Your Balance is: " + customerBalance);
					System.out.println();

					if (isCompanyFound) {

						System.out.println("Please Enter the number of Shares You want to buy :- ");
						numberOfCompanySharesToBuy = StockUtility.integerInput();

						// checking whether amount to buy whether user has that much amount or not
						if (numberOfCompanySharesToBuy < companyList.get(indexOfCompany).getCompanyShares()) {
							// checking user has that much amount or not
							if (customerBalance > (numberOfCompanySharesToBuy
									* companyList.get(indexOfCompany).getCompanySharePrice())) {
								int newCustomerBalance = customerBalance - numberOfCompanySharesToBuy
										* companyList.get(indexOfCompany).getCompanySharePrice();

								// deducting customer balance
								customerList.get(indexOfCustomer).setCustomerBalance(newCustomerBalance);
								// adding customer shares
								customerList.get(indexOfCustomer).setCustomerShares(
										customerList.get(indexOfCustomer).getCustomerShares() + numberOfCompanySharesToBuy);
								// deducting the company share
								companyList.get(indexOfCompany).setCompanyShares(
										companyList.get(indexOfCompany).getCompanyShares() - numberOfCompanySharesToBuy);
								// calculating new total value of company
								companyList.get(indexOfCompany)
										.setCompanyTotalValue(companyList.get(indexOfCompany).getCompanySharePrice()
												* companyList.get(indexOfCompany).getCompanyShares());

								// code reflecting transaction
								Transactions trans = new Transactions();
								LocalDateTime now = LocalDateTime.now();

								String transId = dateTimeFormat2.format(now)
										+ customerList.get(indexOfCustomer).getCustomerSymbol()
										+ companyList.get(indexOfCompany).getCompanySymbol();
								trans.setTransactionId(transId);
								trans.setBuyer(customerList.get(indexOfCustomer).getCustomerName());
								trans.setSeller(companyList.get(indexOfCompany).getCompanyName());
								trans.setTransactionAmount(numberOfCompanySharesToBuy
										* companyList.get(indexOfCompany).getCompanySharePrice());
								trans.setDateTime(dateTimeFormat.format(now));

								transactionList.add(trans);
								int saveOperation;
								System.out.println("=====Opeartions to Perform=====");
								System.out.println();
								System.out.println("Press 1 For Saving");
								System.out.println("--------------------------------------");
								System.out.println("Press 2 For Continuing without saving");
								System.out.println("--------------------------------------");
								System.out.println("Enter Your Choice");
								System.out.println();
								saveOperation = StockUtility.integerInput();
								if (saveOperation == 1) {
									JsonUtil1.writeMapper(pathForCompanyShares2, companyModel.getCompanyShares());
									JsonUtil1.writeMapper(pathForCustomerShares2, customerModel.getCustomerShares());
									transactionModel.setTransactions(transactionList);
									transactionModel.setTransaction("==Transactions Are==");
									JsonUtil1.writeMapper(pathForTransaction, transactionModel);
									System.out.println("SuccessFully stored the Trnsactions");
								} else if (saveOperation == 2) {
									System.out.println("Failed to Store Transactions");
								} else
									System.out.println(" ");

							} else
								System.out.println("Your balance is less");
						} else {
							System.out.println("Company don't have"+numberOfCompanySharesToBuy+ " shares to buy");
						}

					} else {
						System.out.println("Entered Company Symbol doesn't Exists");
					}
					System.out.println("----------------------------------");
					break;

				case 3:
					// Displaying the reports of Transactions
					
					System.out.println("=====Transaction Update Records=====");
					
					
								System.out.print("Transaction Symbol\t");
								System.out.print("Buyer Party\t");
								System.out.print("Seller Party\t");
								System.out.print("Transaction Amount\t");
								System.out.println("DateTime\t");
								
								System.out.println("---------------------------------------------------------------------------------------------------");
								for (int i = 0; i < transactionList.size(); i++) {
									if (file.length()!=0) {
								System.out.print(transactionList.get(i).getTransactionId() + "\t\t");
								System.out.print(transactionList.get(i).getBuyer() + "\t");
								System.out.print(transactionList.get(i).getSeller() + "\t");
								System.out.print(transactionList.get(i).getTransactionAmount() + "\t\t\t");
								System.out.println(transactionList.get(i).getDateTime() + "\t");
								System.out.println("---------------------------------------------------------------------------------------------------");

							}

						
					 else
						
						System.out.println("Sorry....No Any transaction Found !!!");
						}
				
					break;
				case 4:
					isExit = true;
					System.out.println("Thank you!!!");
					break;
				default:
					System.out.println("Invalid Choice");
				}
			}

		} else {
			System.out.println("Invalid Customer Symbol");
		}
	}

}
