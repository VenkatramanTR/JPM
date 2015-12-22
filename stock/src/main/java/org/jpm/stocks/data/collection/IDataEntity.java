package org.jpm.stocks.data.collection;

import java.util.ArrayList;
import java.util.HashMap;

import org.jpm.stocks.data.Stock;
import org.jpm.stocks.transaction.StockTransaction;

/**
 * Interface IDataEntity for storing StockCollections Bean
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public interface IDataEntity {
	
public boolean recordTrade(StockTransaction transaction) throws Exception;
	
	/**
	 * Gets the array list that contains all the trades.
	 * 
	 * @return The array list that contains all the trades in the Super Simple Stocks application.
	 */
	public ArrayList<StockTransaction> getTransactions();
	
	/**
	 * 
	 * @param stockSymbol
	 * @return
	 */
	public Stock getStockBySymbol(String stockSymbol);
	
}
