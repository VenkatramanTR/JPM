package org.jpm.stocks.test;

import org.apache.log4j.Logger;
import org.jpm.stocks.context.IContextLoader;
import org.jpm.stocks.data.collection.DataEntityImpl;
import org.jpm.stocks.service.StockServiceImpl;
import org.junit.Assert;
import org.junit.Test;


public class TestStockService {
	
	
	Logger logger = Logger.getLogger(TestStockService.class);

	/**
	 * 
	 */
	@Test
	public void isStockServiceImplSingleton(){

		logger.info("Start  isStockServiceImplSingleton ...");

		StockServiceImpl stockServiceA = IContextLoader.INSTANCE.getBean("StockService");
		StockServiceImpl stockServiceB = IContextLoader.INSTANCE.getBean("StockService");

		Assert.assertNotNull(stockServiceA);
		Assert.assertNotNull(stockServiceB);

		Assert.assertTrue(stockServiceA.equals(stockServiceB));

		logger.info("Finish isStockServiceImplSingleton ...OK");

	}

	/**
	 * 
	 */
	@Test
	public void isDataEntityImplSingleTon(){

		logger.info("Start  isStockServicesASingleton ...");

		StockServiceImpl stockService = IContextLoader.INSTANCE.getBean("StockService");

		DataEntityImpl dataEntityImplA = stockService.getDataImpl();
		DataEntityImpl dataEntityImplB = stockService.getDataImpl();

		Assert.assertNotNull(dataEntityImplA);
		Assert.assertNotNull(dataEntityImplB);

		Assert.assertTrue(dataEntityImplA.equals(dataEntityImplB));

		logger.info("Finish isStockServicesASingleton ...OK");

	}

}
