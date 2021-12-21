package com.LoggerFramework.configurations;

import java.io.*;
import java.util.Properties;

public class LoggerConfiguration {

    private Properties loggerProperties;
    private File loggingConfigFile;
    private static final String configFilePath = "src/main/resources/logger.properties";


    private LoggerConfiguration(){
        this.loggingConfigFile = new File(configFilePath);
        this.loggerProperties = new Properties();
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






}
