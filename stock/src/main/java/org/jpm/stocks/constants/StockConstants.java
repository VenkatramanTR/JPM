package org.jpm.stocks.constants;


/**
 * Constants class for storing the application constants.
 * 
 * @author Venkataraman Thimmappa Ramamurthy
 *
 */
public class StockConstants {

	public static final String SPRING_CONTEXT = "classpath*:*jpm_stocks.xml";
	
	
	public static final String COMMON = "COMMON";
	public static final String PREFERRED = "PREFERRED";
	
	
	public static final String DISPLAY_STOCK_DETAILS = "Stock Object [stockSymbol: %s, stockType: %s, lastDividend: %7.0f, fixedDividend: %7.2f, parValue: %7.2f]";
	
	
	
	/*
	 * log messages
	 */
	
	public static final String SPRING_CONTEXT_INITIATION_MSG = "spring context initiated for the first time";
}
