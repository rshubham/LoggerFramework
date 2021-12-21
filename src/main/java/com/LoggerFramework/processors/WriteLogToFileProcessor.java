package com.LoggerFramework.processors;

import com.LoggerFramework.configurations.LoggerConfiguration;
import com.LoggerFramework.enums.LoggerEnum;

public class WriteLogToFileProcessor extends LogProcessor {

    LoggerConfiguration config;
    ILogProcessor logProcessor;

    /* ------------------ Singleton Code -------------------- */

    private WriteLogToFileProcessor(){
        config = LoggerConfiguration.getInstance();
    }

    private static class WriteLogToFileProcessorHelper{
        private static WriteLogToFileProcessor instance = new WriteLogToFileProcessor();
    }

    public static WriteLogToFileProcessor getProcessor(){
        return WriteLogToFileProcessorHelper.instance;
    }

    /* ----------------------------------------------------- */

    @Override
    public void process(LoggerEnum loggerEnum,String className,String text) {
        if(LoggerEnum.YES.name().equals(config.getConfig(LoggerEnum.ENABLE_WRITE_TO_FILE.name()))) {

            // do process

        }
        if(getNextProcessor() != null) getNextProcessor().process(loggerEnum,className,text);

    }

    @Override
    protected void setNextProcessor(ILogProcessor logProcessor) {
        this.logProcessor = SendLogToELKProcessor.getProcessor();
    }

    @Override
    protected ILogProcessor getNextProcessor() {
        return this.logProcessor;
    }
}
