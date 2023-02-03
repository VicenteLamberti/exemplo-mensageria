package br.com.vicente.exemplomensageriabackconsumer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.DirectExchangeRoutingKeyConfigurer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerAMQPConfiguration {
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

	@Bean
	public Queue filaProduto() {
		return QueueBuilder.nonDurable("filaProduto")
				.build();
	}
	
	@Bean
	public Binding  bindExchangeComFilaProduto() {
		return BindingBuilder.bind(filaProduto())
				.to(directExchange())
				.with("filaProduto");
				
	}
	
	
	
	@Bean
	public Queue filaPagamento() {
		return QueueBuilder.nonDurable("filaPagamento")
				.build();
	}
	
	@Bean
	public Binding bindExchangeComFilaPagamento() {
		return BindingBuilder.bind(filaPagamento())
				.to(directExchange())
				.with("filaPagamento");
	}
	
	@Bean
	public Queue filaAvaliacao() {
		return QueueBuilder.nonDurable("filaAvaliacao")
				.build();
	}
	
	@Bean
	public Binding bindExchangeComFilaAvaliacao() {
		return BindingBuilder.bind(filaAvaliacao())
				.to(directExchange())
				.with("filaAvaliacao");
	}
	
}
