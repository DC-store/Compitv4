package com.CompitApplication.Logger;

import org.apache.logging.log4j.ThreadContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtils
{
	
	Logger logger;
	public LoggingUtils(String className)
	{
		this.logger = LogManager.getLogger(className);
	}
	public void info(String logMessage)
	{
		logger.info(logMessage);
	}
	public void debug(String logMessage)
        {
                logger.debug(logMessage);
        }
	public void fatal(String logMessage)
        {
                logger.fatal(logMessage);
        }
        public void trace(String logMessage)
        {
                logger.trace(logMessage);
        }
        public void warn(String logMessage)
        {
                logger.warn(logMessage);
        }
        public void error(String logMessage)
        {
                logger.error(logMessage);
        }
	public void threadContextPut(String id,String ContextValue)
	{
		ThreadContext.put(id,ContextValue);
	}
	public String threadContextGet(String id)
	{
		return ThreadContext.get(id);
	}

}