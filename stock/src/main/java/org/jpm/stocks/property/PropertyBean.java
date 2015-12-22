package org.jpm.stocks.property;

/**
 * Class PropertyBean contains all the property values for running the application
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public class PropertyBean {

	
	private String stockSymbol;
	private String stockType;
	private String transactionType;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	private int shareQuantity;
	private double sharePrice;
	private int timeOfPurchase;
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
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
	public int getTimeOfPurchase() {
		return timeOfPurchase;
	}
	public void setTimeOfPurchase(int timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}
}
