package org.jpm.stocks.context;

import org.apache.log4j.Logger;
import org.jpm.stocks.constants.StockConstants;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Implementation of the ContextLoader Interface, this is mainly used for initializing the Spring bean factory
 * and for loading the bean
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 *
 */
public class ContextLoaderImpl implements IContextLoader{
	
	private Logger logger = Logger.getLogger(ContextLoaderImpl.class);
	private AbstractApplicationContext springContext = null;
	private ContextLoaderImpl()
	{
		springContext = new ClassPathXmlApplicationContext(StockConstants.SPRING_CONTEXT);
		springContext.registerShutdownHook();
		logger.info(StockConstants.SPRING_CONTEXT_INITIATION_MSG);
	}

	public static IContextLoader getInstance() {
		return new ContextLoaderImpl();
	}

	public Object getBean(String beanName) {
		return springContext.getBean(beanName);
	}

}
