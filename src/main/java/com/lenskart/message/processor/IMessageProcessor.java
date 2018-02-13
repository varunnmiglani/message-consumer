package com.lenskart.message.processor;

import java.util.Map;

/**
 * The Interface IMessageProcessor.
 * 
 * @author varunn
 */
@FunctionalInterface
public interface IMessageProcessor {

	/**
	 * Process.
	 *
	 * @param message the message
	 * @param headers the headers
	 */
	void process(String message, Map<String, Object> headers);
}
