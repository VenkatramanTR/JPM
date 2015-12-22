package org.jpm.stocks.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.jpm.stocks.data.Stock;
import org.jpm.stocks.data.collection.DataEntityImpl;
import org.jpm.stocks.transaction.StockTransaction;


/**
 * Class StockServiceImpl implements all the service methods defined in the 
 * IStockService Interface, this class implements IStockService Interface
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public class StockServiceImpl implements IStockService {
	
	private DataEntityImpl dataImpl = null;
	private Logger logger = Logger.getLogger(StockServiceImpl.class);
	Calendar dateRange = null;

	/**
	 * This method takes String stockSymbol as parameter and int stockPrice and calculates the dividendYield 
	 * @return double dividendYield
	 */
	public double calculateDividendYield(String stockSymbol, int stockPrice) {
		double dividendYield = -1.0;
		Stock stock = null;
		try{
			stock = dataImpl.getStockBySymbol(stockSymbol);
			
			// If the stock is not supported the a exception is raised
			if(stock==null){
				throw new Exception("The stock symbol ["+stockSymbol+"] is not supported by the Super Simple Stock system.");
			}
			stock.setStockPrice(stockPrice);

			// Ticker price with value zero does not make any sense and could produce a zero division
			if(stock.getStockPrice() <= 0.0){
				logger.info("value lesser than or equal to 0");
				throw new Exception("The ticker price for the stock ["+stockSymbol+"] should be greater than zero (0).");
			}
			dividendYield = stock.getDividendYield();

			logger.info("Dividend Yield calculated: "+dividendYield);
			logger.info("Dividend Yield calculated: "+dividendYield);

		}catch(Exception exception){
			logger.info("catching exception");
			logger.error("Error calculating Dividend Yield for the stock symbol: "+stockSymbol+".", exception);
		}
		return dividendYield;
	}
	
	/**
	 * This method takes String stockSymbol as parameter and int stockPrice and calculates the PERatio 
	 * @return double PERatio
	 */
	public double calculatePERatio(String stockSymbol, int stockPrice){
		double PERatio = -1.0;
		Stock stock = null;
		try{
			stock = dataImpl.getStockBySymbol(stockSymbol);
			
			// If the stock is not supported the a exception is raised
			if(stock==null){
				throw new Exception("The stock symbol ["+stockSymbol+"] is not supported by the Super Simple Stock system.");
			}
			stock.setStockPrice(stockPrice);

			// Ticker price with value zero does not make any sense and could produce a zero division
			if(stock.getStockPrice() <= 0.0){
				logger.info("value lesser than or equal to 0");
				throw new Exception("The stock price for the stock ["+stockSymbol+"] should be greater than zero (0).");
			}
			PERatio = stock.getPERatio();

			logger.info("PE Ratio calculated: "+PERatio);
			logger.info("PE Ratio calculated: "+PERatio);

		}catch(Exception exception){
			System.err.println("catching exception");
			logger.error("Error calculating PE Ratio for the stock symbol: "+stockSymbol+".", exception);
		}
		return PERatio;
	}
	
	/**
	 * This method takes StockTransaction stockTransaction as parameter and records the trade to the system 
	 * @return boolean true if added successfully 
	 */
	public boolean recordTrade(StockTransaction stockTransaction) throws Exception {
		boolean recordResult = false;
		int sizeBeforeAdd = 0;
		int sizeAfterAdd = 0;
		try{
			
			if(stockTransaction==null){
				throw new Exception("Transaction object is null.");
			}

			// stock should be an object
			if(stockTransaction.getStock()==null){
				throw new Exception("A transaction should be associated with a stock and the stock for the trade is null.");
			}

			// shares quantity should be greater than zero
			if(stockTransaction.getShareQuantity()<=0){
				throw new Exception("Shares quantity should be greater than cero.");
			}

			// shares price should be greater than zero
			if(stockTransaction.getSharePrice()<=0.0){
				throw new Exception("Shares price should be greater than cero.");
			}
			sizeBeforeAdd = dataImpl.getStockTransactions().getStockTransactionsList().size();
			dataImpl.getStockTransactions().recordTrade(stockTransaction);
			sizeAfterAdd = dataImpl.getStockTransactions().getStockTransactionsList().size();
			logger.info("before trade size::: "+sizeBeforeAdd);
			logger.info("before trade size::: "+sizeAfterAdd);
			if(sizeBeforeAdd < sizeAfterAdd)
			{
				recordResult = true;
			}


		}catch(Exception exception){
			logger.error("Error when trying to record a trade.", exception);
			throw new Exception("Error when trying to record a trade.", exception);
		}
		return recordResult;
	}
	
	/**
	 * This method takes String stockSymbol as parameter and gives the stoock price range for the last 15 minutes 
	 * @return double stockPrice 
	 */
	public double calculateStockPrice(String stockSymbol) throws Exception {
		double stockPrice = 0.0;

		try {
			logger.info("Calculating Stock Price for the stock symbol: " + stockSymbol);
			Stock stock = dataImpl.getStockBySymbol(stockSymbol);

			// If the stock is not supported the a exception is raised
			if (stock == null) {
				throw new Exception(
						"The stock symbol [" + stockSymbol + "] is not supported by the Super Simple Stock system.");
			}
			stockPrice = calculateStockPriceinRange(stockSymbol, 15);

			logger.debug(" Stock Price calculated: " + stockPrice);

		} catch (Exception exception) {
			System.err.println("Error calculating P/E Ratio for the stock symbol: " + stockSymbol);

		}

		return stockPrice;
	}

	private double calculateStockPriceinRange(final String stockSymbol, int mins) {
		double stockPrice = 0.0;

		
		if( mins > 0 ){
			dateRange = Calendar.getInstance();
			dateRange.add(Calendar.MINUTE, -mins);
		}
		ArrayList<StockTransaction> transactionList = (ArrayList<StockTransaction>) dataImpl.getStockTransactions().getStockTransactionsList();
		logger.info("transaction list size ::: "+transactionList.size());
		CollectionUtils.filter( transactionList, new Predicate(){
	         public boolean evaluate( Object input ) {
	        	 
	        	 
	        	 StockTransaction transaction = (StockTransaction) input;
	 			boolean shouldBeInclude = transaction.getStock().getStock().equals(stockSymbol);
	 			if(shouldBeInclude && dateRange != null){
	 				//logger.info(transaction.getCorrectDate().toString());
	 				shouldBeInclude = dateRange.getTime().compareTo(transaction.getCorrectDate())<=0;
	 				//logger.info("date range ::" +dateRange.getTime().toString()+" transaction.getCorrectDate() "+transaction.getCorrectDate().toString());
	 			}
	 			return shouldBeInclude;
	         }
	      } );
		logger.info("transaction list size ::: "+transactionList.size());
		

		// Calculate the summation
		double shareQuantityAcum = 0.0;
		double tradePriceAcum = 0.0;
		for(StockTransaction transaction : transactionList){
			// Calculate the summation of Trade Price x Quantity
			tradePriceAcum += (transaction.getSharePrice() * transaction.getShareQuantity());
			// Acumulate Quantity
			shareQuantityAcum += transaction.getShareQuantity();
		}

		// calculate the stock price
		if(shareQuantityAcum > 0.0){
			stockPrice = tradePriceAcum / shareQuantityAcum;	
		}


		return stockPrice;
	}

	/**
	 * This method takes stockTransactionList, the entire stock list and calculates the mean of all the stock prices
	 * @return double allShareIndex
	 */
	public double calculateGBCEAllShareIndex(ArrayList<StockTransaction> stockTransactionList) throws Exception{
		logger.info("total transactions::: "+stockTransactionList.size());
		// Calculate stock price for all stock in the system
		HashMap<String, Stock> stocks = dataImpl.getStocks().getStockCollections();
		logger.info("stock types:: "+stocks.size());
		ArrayList<Double> stockPrices = new ArrayList<Double>();
		double N= stockTransactionList.size();
		double allShareIndex = 1.0;
		for(StockTransaction stock:stockTransactionList)
		{
		    
			allShareIndex = allShareIndex * stock.getSharePrice();
		    
		}
		allShareIndex=Math.pow(allShareIndex,(1/N));
		
		return allShareIndex;
	}

	public DataEntityImpl getDataImpl() {
		return dataImpl;
	}

	public void setDataImpl(DataEntityImpl dataImpl) {
		this.dataImpl = dataImpl;
	}
	
	

}
