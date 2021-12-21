package com.LoggerFramework;

import com.LoggerFramework.loggers.Logger;

public class LoggerClient {



    public static void main(String[] args){
        LoggerClient client = new LoggerClient();
        Logger logger = Logger.getLogger();
        logger.debug(client,"This is Debug Level Log!!");
        logger.info(client,"This is Info Level Log!!");
        logger.warn(client,"This is Warn Level Log!!");
        logger.error(client,"This is Error Level Log!!");
        logger.fatal(client,"This is Fatal Level Log!!");
    }


}
