package org.jpm.stocks.data;


import org.apache.log4j.Logger;
import org.jpm.stocks.constants.StockConstants;

/**
 * Class Stock contains all the stock objects
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 * 
 */
public class Stock {
	
	private Logger logger = Logger.getLogger(Stock.class);
	
	private String stock = null;
	
	private String type= null;
	private double lastDividend = 0.0;
	
	private double fixedDividend = 0.0;
	
	private double parValue = 0.0;
		
	private double stockPrice = 0.0; 
	
	public Stock(){
		
	}
	/**
	 * construction injection of member variables
	 * @param stockSymbol
	 * @param type
	 * @param lastDividend
	 * @param fixedDividend
	 * @param parValue
	 * @param stockPrice
	 */
	public Stock(String stockSymbol, String type, double lastDividend, double fixedDividend, double parValue, double stockPrice)
	{
		this.stock = stockSymbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.stockPrice = stockPrice;
	}
	public String getStock() {
		return stock;
	}

	public void setStock(String stockSymbol) {
		this.stock = stockSymbol;
	}


	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	/**
	 * This method calculatess the dividend yield by applying different formulas for COMMON and PREFFERED stock type
	 * COMMON = dividendYield = lastDividend / stockPrice;
	 * PREFERRED = dividendYield = (fixedDividend * parValue ) / stockPrice;
	 * @return double dividend value
	 */
	public double getDividendYield() {
		double dividendYield = -1.0;
		if(stockPrice > 0.0){
			logger.info("fixedDividend"+fixedDividend);
			logger.info("parValue"+parValue);
			logger.info("lastDividend"+lastDividend);
			logger.info("type"+type);
			if(type.equals(StockConstants.COMMON)){
				dividendYield = lastDividend / stockPrice;
				logger.info("common dividenyield"+dividendYield);
			}else{
				dividendYield = (fixedDividend * parValue ) / stockPrice;
				logger.info("preferred dividenyield"+dividendYield);
			}
		}
		return dividendYield;
	}

	/**
	 * this returns the PERatio for a given stock, the formula is PERatio = stockPrice / getDividendYield();
	 * @return double PERatio
	 */
	public double getPERatio() {
		double PERatio = -1.0;
		
		if(stockPrice > 0.0){
			PERatio = stockPrice / getDividendYield();	
		}
		
		return PERatio;
	}

	public double getStockPrice() {
		return stockPrice;
	}
	
	
	public void setStockPrice(double stockPrice) {
		logger.debug("stock price to be updated is : "+stockPrice);
		this.stockPrice = stockPrice;
		logger.debug("stock price for "+stock+" is : "+stockPrice);

	}
	
	@Override
	public String toString() {
		String pattern = "Stock Object [stockSymbol: %s, type: %s, lastDividend: %7.0f, fixedDividend: %7.2f, parValue: %7.2f]";
		return String.format(pattern, stock, type, lastDividend, fixedDividend, parValue);
	}
	
}
