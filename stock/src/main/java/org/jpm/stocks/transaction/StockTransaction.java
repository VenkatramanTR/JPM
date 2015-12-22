package org.jpm.stocks.transaction;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.jpm.stocks.data.Stock;

/**
 * Class StockTransaction contains the stock transactions
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public class StockTransaction {
	
	private Logger logger = Logger.getLogger(StockTransaction.class);
	
	private int timeOfPurchase;
	private Stock stock = null;
	private String transactionType = null;
	private int shareQuantity = 0;
	private double sharePrice = 0.0;
	
	public StockTransaction()
	{
		
	}
	/**
	 * constructor for populating all the member variables
	 * @param timeOfPurchase
	 * @param stock
	 * @param transactionType
	 * @param shareQuantity
	 * @param SharePrice
	 */
	public StockTransaction(int timeOfPurchase, Stock stock, String transactionType, int shareQuantity, double SharePrice)
	{
		this.timeOfPurchase = timeOfPurchase;
		this.stock = stock;
		this.transactionType = transactionType;
		this.shareQuantity = shareQuantity;
		this.sharePrice = SharePrice;
	}
	public Date getCorrectDate()
	{
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, timeOfPurchase);
		return now.getTime();
	}
	public int getTimeOfPurchase() {
		return this.timeOfPurchase;
		
	}
	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public void setTimeOfPurchase(int timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getShareQuantity() {
		return shareQuantity;
	}
	public void setShareQuantity(int shareQuantity) {
		this.shareQuantity = shareQuantity;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	

}
