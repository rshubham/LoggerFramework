package com.LoggerFramework.processors;

import com.LoggerFramework.configurations.LoggerConfiguration;
import com.LoggerFramework.enums.LoggerEnum;

import java.sql.Timestamp;

public class LogProcessor implements ILogProcessor {

    ILogProcessor logProcessor;

    // implementation of Print
    private void printToConsole(LoggerEnum loggerEnum,String className,String text){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        String uuid = java.util.UUID.randomUUID().toString();
        String printableText = "[" + uuid + "] [" +
                currentTimestamp + "] ["+
                loggerEnum.name() + "] ["+
                className + "] "+
                text;
        System.out.println(printableText);
    }


    protected void setNextProcessor(ILogProcessor logProcessor){
        this.logProcessor = logProcessor;
    }


    protected ILogProcessor getNextProcessor(){
        return this.logProcessor;
    }


    @Override
    public void process(LoggerEnum loggerEnum,String className,String text) {
        printToConsole(loggerEnum,className,text);
        setNextProcessor(WriteLogToFileProcessor.getProcessor());
        getNextProcessor().process(loggerEnum,className,text);
    }
}
