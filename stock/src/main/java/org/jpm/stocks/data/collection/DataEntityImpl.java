package org.jpm.stocks.data.collection;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.jpm.stocks.data.Stock;
import org.jpm.stocks.data.StockCollections;
import org.jpm.stocks.transaction.StockTransaction;
import org.jpm.stocks.transaction.StockTransactions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class DataEntityImpl contains StockCollection bean
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public class DataEntityImpl implements IDataEntity {
	
	private Logger logger = Logger.getLogger(DataEntityImpl.class);
	private StockCollections stocks = null;

	private StockTransactions stockTransactions = null;

	public boolean recordTrade(StockTransaction transaction) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<StockTransaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Stock getStockBySymbol(String stockSymbol) {
		Stock stock = null;
		HashMap<String, Stock> stockMap = null;
		try{
			if(stockSymbol!=null){
				stockMap = stocks.getStockCollections();
				if(stockMap != null)
				{
					stock = stockMap.get(stockSymbol);
				}
			}
		}catch(Exception exception){
			logger.error("An error has occurred recovering the stock object for the stock symbol: "+stockSymbol+".", exception);
		}
		return stock;
	}

	public StockTransactions getStockTransactions() {
		return stockTransactions;
	}
	
	@Autowired
	public void setStockTransactions(StockTransactions stockTransactions) {
		this.stockTransactions = stockTransactions;
	}

	public StockCollections getStocks() {
		return stocks;
	}
	@Autowired
	public void setStocks(StockCollections stocks) {
		this.stocks = stocks;
	}
	
	
}
