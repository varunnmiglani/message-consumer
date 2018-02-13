package com.lenskart.message.consumer;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.lenskart.message.exception.MessageProcessingFailedException;
import com.lenskart.message.processor.IMessageProcessor;

/**
 * The Class MessageConsumer.
 * 
 * @author varunn
 */
@Component
public class MessageConsumer {

	/** The Constant LOG. */
	public static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

	/** The processor. */
	@Autowired
	private IMessageProcessor processor;

	/**
	 * Consume.
	 *
	 * @param message the message
	 */
	@StreamListener(value = Sink.INPUT)
	public void consume(Message<String> message) {
		final Map<String, Object> headers = new HashMap<>();
		if(message.getHeaders() != null && !message.getHeaders().isEmpty()) {
			message.getHeaders().entrySet().forEach(entry -> headers.put(entry.getKey(), entry.getValue()));
		}
		
		try {
			processor.process(message.getPayload(), headers);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new MessageProcessingFailedException(e.getMessage(), e);
		}
	}
}