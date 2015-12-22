package org.jpm.stocks.data;

import java.util.HashMap;

/**
 * Class StockCollections contains collection (HashMap) of all the bean managed stock objects
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public class StockCollections {
	

	private HashMap<String, Stock> stockCollections = null;

	
	public StockCollections()
	{
		setStockCollections(new HashMap<String, Stock>());
	}


	public HashMap<String, Stock> getStockCollections() {
		return stockCollections;
	}


	public void setStockCollections(HashMap<String, Stock> stockCollections) {
		this.stockCollections = stockCollections;
	}

}
