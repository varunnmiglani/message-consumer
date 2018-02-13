package com.lenskart.message.exception;

/**
 * The Class MessageProcessingFailedException.
 * 
 * @author varunn
 */
public class MessageProcessingFailedException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new message processing failed exception.
	 *
	 * @param mesage the mesage
	 */
	public MessageProcessingFailedException(String mesage) {
		super(mesage);
	}

	/**
	 * Instantiates a new message processing failed exception.
	 *
	 * @param e the e
	 */
	public MessageProcessingFailedException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new message processing failed exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public MessageProcessingFailedException(String message, Throwable e) {
		super(message, e);
	}

}
