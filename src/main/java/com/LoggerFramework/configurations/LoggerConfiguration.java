package com.LoggerFramework.configurations;

import com.LoggerFramework.enums.LoggerEnum;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoggerConfiguration {

    private Properties loggerProperties;
    private File loggingConfigFile;
    private Map<String,Integer> logLevelMap;
    private static final String configFilePath = "src/main/resources/logger.properties";


    private LoggerConfiguration(){
        this.loggingConfigFile = new File(configFilePath);
        this.loggerProperties = new Properties();
        fillLogLevelMap();
    }

    private static class LoggerConfigHelper {
        private static LoggerConfiguration instance = new LoggerConfiguration();
    }

    public static LoggerConfiguration getInstance(){
        return LoggerConfigHelper.instance;
    }

    public String getConfig(String key){
        String value = "";
        try {
            FileReader fileReader = new FileReader(configFilePath);
            this.loggerProperties.load(fileReader);
            value = this.loggerProperties.getProperty(key);
            fileReader.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public Properties getAllConfig(){
        try {
            FileReader fileReader = new FileReader(configFilePath);
            this.loggerProperties.load(fileReader);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.loggerProperties;
    }

    private void fillLogLevelMap(){
        this.logLevelMap = new HashMap<String, Integer>();
        this.logLevelMap.put(LoggerEnum.FATAL_LOG_LEVEL.name(),50000);
        this.logLevelMap.put(LoggerEnum.ERROR_LOG_LEVEL.name(),40000);
        this.logLevelMap.put(LoggerEnum.WARN_LOG_LEVEL.name(),30000);
        this.logLevelMap.put(LoggerEnum.INFO_LOG_LEVEL.name(),20000);
        this.logLevelMap.put(LoggerEnum.DEBUG_LOG_LEVEL.name(),10000);
        this.logLevelMap.put(LoggerEnum.ALL_LOG_LEVEL.name(),0);
    }

    private int getLogLevelValue(String logLevel){
        return this.logLevelMap.get(logLevel);
    }

    public boolean isLoggingAllowed(String currLogLevel){
        if(getLogLevelValue(currLogLevel) >= getLogLevelValue(getConfig(LoggerEnum.LOG_LEVEL.name()))){
            return true;
        }
        return false;
    }
}
