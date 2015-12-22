package org.jpm.stocks.transaction;

import java.util.List;

/**
 * Class StockTransactions contains all the StockTransaction objects in a list 
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */

public class StockTransactions {
	
	private List<StockTransaction> stockTransactionsList = null;

	public List<StockTransaction> getStockTransactionsList() {
		return stockTransactionsList;
	}

	public void setStockTransactionsList(List<StockTransaction> stockTransactionsList) {
		this.stockTransactionsList = stockTransactionsList;
	}
	
	public boolean recordTrade(StockTransaction stockTransaction) throws Exception{
		boolean result = false;
		try{
			result = stockTransactionsList.add(stockTransaction);
		}catch(Exception exception){
			throw new Exception("An error has occurred recording a trade in the system's backend.", exception);
		}
		return result;
	}

}
