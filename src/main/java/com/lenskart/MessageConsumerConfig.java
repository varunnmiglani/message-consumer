package com.lenskart;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@EnableAutoConfiguration
@EnableBinding(Sink.class)
public class MessageConsumerConfig {
	
}
