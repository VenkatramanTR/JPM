package org.jpm.stocks.service;

import java.util.ArrayList;

import org.jpm.stocks.transaction.StockTransaction;

/**
 * Stock Service interface to calculate the dividend yield, P/E Ratio, 
 * record trades with timestamp, shareQuantity, transactionIndiacator and traded price for a given stock, 
 * volume weighted stock price based on transactions in the past 15 minutes, GBCE all share index
 * 
 * @author Venkatraman thimmappa Ramamurthy
 *
 */
	
public interface IStockService {

	
		public double calculateDividendYield(String stockSymbol, int price) throws Exception;
		public double calculatePERatio(String stockSymbol, int price) throws Exception;
		public boolean recordTrade(StockTransaction stockTransaction) throws Exception;
		public double calculateStockPrice(String stockSymbol) throws Exception;
		public double calculateGBCEAllShareIndex(ArrayList<StockTransaction> stockTransactionList) throws Exception;
		
}
