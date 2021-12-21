package com.LoggerFramework.processors;

import com.LoggerFramework.configurations.LoggerConfiguration;
import com.LoggerFramework.enums.LoggerEnum;

public class SendLogToELKProcessor extends LogProcessor {

    LoggerConfiguration config;
    ILogProcessor logProcessor;

    /* ------------------ Singleton Code -------------------- */

    private SendLogToELKProcessor(){
        config = LoggerConfiguration.getInstance();
    }

    private static class SendLogToELKProcessorHelper{
        private static SendLogToELKProcessor instance = new SendLogToELKProcessor();
    }

    public static SendLogToELKProcessor getProcessor(){
        return SendLogToELKProcessorHelper.instance;
    }

    /* ----------------------------------------------------- */

    @Override
    public void process(LoggerEnum loggerEnum,String className,String text) {
        if(LoggerEnum.YES.name().equals(config.getConfig(LoggerEnum.ENABLE_SEND_TO_ELK.name()))) {

            // do process

        }
        if(getNextProcessor() != null) getNextProcessor().process(loggerEnum,className,text);

    }

    @Override
    protected void setNextProcessor(ILogProcessor logProcessor) {
    }

    @Override
    protected ILogProcessor getNextProcessor() {
        return this.logProcessor;
    }


}
