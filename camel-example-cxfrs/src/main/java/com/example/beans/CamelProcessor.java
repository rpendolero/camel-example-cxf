package com.example.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CamelProcessor implements Processor {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public void process(Exchange exchange) throws Exception {
		// Get input from exchange
		String msg = exchange.getIn().getBody(String.class);
		
		logger.info(msg);
		// set output in exchange
		exchange.getOut().setBody("Hello World " + msg);

	}

}
