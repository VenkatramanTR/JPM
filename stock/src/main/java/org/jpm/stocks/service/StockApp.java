package org.jpm.stocks.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jpm.stocks.context.IContextLoader;
import org.jpm.stocks.data.Stock;
import org.jpm.stocks.property.PropertyBean;
import org.jpm.stocks.transaction.StockTransaction;

public class StockApp {

	private static Logger logger = Logger.getLogger(StockApp.class);
	public static void main(String args[]) throws Exception
	{
		
		String stockSymbol;
		String stockType;
		String transactionType;
		double lastDividend;
		double fixedDividend;
		double parValue;
		int shareQuantity;
		double sharePrice;
		int timeOfPurchase;
		
		PropertyBean props = IContextLoader.INSTANCE.getBean("propertyBean");
		fixedDividend = props.getFixedDividend();
		lastDividend = props.getLastDividend();
		parValue = props.getParValue();
		sharePrice = props.getSharePrice();
		shareQuantity = props.getShareQuantity();
		stockSymbol = props.getStockSymbol();
		stockType = props.getStockType();
		transactionType = props.getTransactionType();
		timeOfPurchase = props.getTimeOfPurchase();
		StockServiceImpl stockService = IContextLoader.INSTANCE.getBean("StockService");
		
		
		ArrayList<StockTransaction> stockTransactionList = (ArrayList<StockTransaction>) stockService.getDataImpl().getStockTransactions().getStockTransactionsList();
		logger.info("all share index value ::: "+stockService.calculateGBCEAllShareIndex(stockTransactionList));
		logger.info(stockService.calculateDividendYield(stockSymbol, 44));
		logger.info(stockService.calculatePERatio("POP", 44));
		
		try {
			if(stockService.recordTrade(new StockTransaction(timeOfPurchase, new Stock(stockSymbol, stockType, lastDividend, fixedDividend, parValue, sharePrice), transactionType, shareQuantity, sharePrice)))
			{
				logger.info("Trade added sucessfully");
			}
			
			logger.info("this is the value for GIN"+stockService.calculateStockPrice("GIN"));
			
//			logger.info(stockService.calculateGBCEAllShareIndex());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
		

}
