package br.com.vicente.exemplomensageriaback.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerAMQPConfiguration {

	@Bean
	public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
		return new RabbitAdmin(conn);
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
		return event -> rabbitAdmin.initialize();
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory conn, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(conn);
		rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
		return rabbitTemplate;
	}
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("pagamentos.ex");
	}
}
