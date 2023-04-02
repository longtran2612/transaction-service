package com.example.transactionservice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 10:11 AM 06-Jan-23
 * Long Tran
 */
public class BaseObjectLoggable {
    protected final transient Logger logger = LogManager.getLogger(this.getClass());
    protected Logger getLogger() {
        return this.logger;
    }
}
