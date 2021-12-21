package com.LoggerFramework.processors;

import com.LoggerFramework.enums.LoggerEnum;

public interface ILogProcessor {
    public void process(LoggerEnum loggerEnum, String className, String text);
}
