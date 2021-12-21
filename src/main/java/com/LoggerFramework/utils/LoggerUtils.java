package com.LoggerFramework.utils;

import com.LoggerFramework.configurations.LoggerConfiguration;
import com.LoggerFramework.enums.LoggerEnum;

import java.util.HashMap;
import java.util.Map;

public class LoggerUtils {

    private static Map<String,Integer> logLevelMap;

    /* ------------------ Singleton Code -------------------- */

    private LoggerUtils(){
        fillLogLevelMap();
    }

    private static class LoggerUtilsHelper{
        private static LoggerUtils instance = new LoggerUtils();
    }

    public static LoggerUtils getInstance(){
        return LoggerUtils.LoggerUtilsHelper.instance;
    }

    /* ----------------------------------------------------- */

    private void fillLogLevelMap(){
        logLevelMap = new HashMap<String, Integer>();
        logLevelMap.put(LoggerEnum.FATAL_LOG_LEVEL.name(),50000);
        logLevelMap.put(LoggerEnum.ERROR_LOG_LEVEL.name(),40000);
        logLevelMap.put(LoggerEnum.WARN_LOG_LEVEL.name(),30000);
        logLevelMap.put(LoggerEnum.INFO_LOG_LEVEL.name(),20000);
        logLevelMap.put(LoggerEnum.DEBUG_LOG_LEVEL.name(),10000);
    }

    private int getLogLevelValue(String logLevel){
        return logLevelMap.get(logLevel);
    }

    public boolean isLoggingAllowed(String currLogLevel){
        if(getLogLevelValue(currLogLevel) >= getLogLevelValue(LoggerConfiguration.getInstance().getConfig(LoggerEnum.LOG_LEVEL.name()))){
            return true;
        }
        return false;
    }


}
