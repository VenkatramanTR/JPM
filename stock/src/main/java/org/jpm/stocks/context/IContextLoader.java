package org.jpm.stocks.context;

/**
 * Interface Context Loader.
 * 
 * @author Venkatraman Thimmappa Ramamurthy
 *
 */
public interface IContextLoader {
	
	public IContextLoader INSTANCE = ContextLoaderImpl.getInstance();	

	/**
	 * Gets an object of the bean configured in the Spring context with the name <i>beanName</i> and representing for the class <i>objectClass</i>.
	 * 
	 * @param beanName	The id for the bean in the Spring context.
	 * @param objectClass The class of the bean configured with the name <i>beanName</i> in the Spring context.
	 * 
	 * @return Return an object corresponding to the bean configured in the Spring context with the name <i>beanName</i> and represented for the class <i>objectClass</i>.
	 */
	public <T extends Object> T getBean(String beanName);

}
