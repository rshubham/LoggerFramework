package com.LoggerFramework.loggers;

import com.LoggerFramework.configurations.LoggerConfiguration;
import com.LoggerFramework.enums.LoggerEnum;
import com.LoggerFramework.processors.ILogProcessor;
import com.LoggerFramework.processors.LogProcessor;


public class Logger implements ILogger {

    private ILogProcessor logProcessor;

    /* ------------------ Singleton Code -------------------- */

    private Logger(){
        this.logProcessor = new LogProcessor();
    }

    private static class LoggerHelper{
        private static Logger instance = new Logger();
    }

    public static Logger getLogger(){
        return LoggerHelper.instance;
    }

    /* ----------------------------------------------------- */

    @Override
    public void fatal(Object object,String text){
        if(!LoggerConfiguration.getInstance().isLoggingAllowed(LoggerEnum.FATAL_LOG_LEVEL.name())) return;
        logProcessor.process(LoggerEnum.FATAL_LOG_LEVEL,object.getClass().getName(),text);
    }

    @Override
    public void error(Object object,String text){
        if(!LoggerConfiguration.getInstance().isLoggingAllowed(LoggerEnum.ERROR_LOG_LEVEL.name())) return;
        logProcessor.process(LoggerEnum.ERROR_LOG_LEVEL,object.getClass().getName(),text);
    }

    @Override
    public void warn(Object object,String text){
        if(!LoggerConfiguration.getInstance().isLoggingAllowed(LoggerEnum.WARN_LOG_LEVEL.name())) return;
        logProcessor.process(LoggerEnum.WARN_LOG_LEVEL,object.getClass().getName(),text);
    }


    @Override
    public void info(Object object,String text){
        if(!LoggerConfiguration.getInstance().isLoggingAllowed(LoggerEnum.INFO_LOG_LEVEL.name())) return;
        logProcessor.process(LoggerEnum.INFO_LOG_LEVEL,object.getClass().getName(),text);
    }

    @Override
    public void debug(Object object,String text){
        if(!LoggerConfiguration.getInstance().isLoggingAllowed(LoggerEnum.DEBUG_LOG_LEVEL.name())) return;
        logProcessor.process(LoggerEnum.DEBUG_LOG_LEVEL,object.getClass().getName(),text);
    }


}
