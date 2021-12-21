package com.LoggerFramework.loggers;

import com.LoggerFramework.processors.ILogProcessor;
import com.LoggerFramework.processors.LogProcessor;

public interface ILogger {
    public void fatal(Object object,String text);
    public void error(Object object,String text);
    public void warn(Object object,String text);
    public void info(Object object,String text);
    public void debug(Object object,String text);
}
