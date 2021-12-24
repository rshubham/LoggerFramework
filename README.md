### Logging Framework

<hr>

#### Introduction

This project is created to implement a Logging Framework for any Java Application. It implements a Logging mechanism utilizing the configuration file. Chain of Responsibility Pattern is used to find out the correct execution of Logging Mechanism.

#### Usage

+ Valid Logging Levels: (LOG_LEVEL config)

    + FATAL_LOG_LEVEL (**highest level of logging**)
    + ERROR_LOG_LEVEL
    + WARN_LOG_LEVEL
    + INFO_LOG_LEVEL
    + DEBUG_LOG_LEVEL (**lowest level of Logging**)

+ Add the configurations in the resources/logger.properties file

    + LOG_LEVEL
    + ENABLE_WRITE_TO_FILE 
    
        + This config will enable the Log Mechanism to write a log at a desired location in your local.
        + **Valid Values**  - YES/NO
        + LOG_FILE_LOCATION : Provide the Log File root directory
        
    + ENABLE_SEND_TO_ELK 
    
        + This config will enable the Log Mechanism to send the log details to Logstash for ELK.
        + **Valid Values**  - YES/NO
        +  ELK_ENDPOINT
        + ELK_USER,
        + ELK_PASSWORD,

#### UML Design

 ![alt text](https://github.com/rshubham/LoggerFramework/blob/master/UML_Design.jpeg)
 



