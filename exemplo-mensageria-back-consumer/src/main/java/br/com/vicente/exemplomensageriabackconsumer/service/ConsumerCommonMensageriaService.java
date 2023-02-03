package br.com.vicente.exemplomensageriabackconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerCommonMensageriaService {
	
	
	

	@RabbitListener(queues = "filaProduto")
	public void selecionarProduto() {

		System.out.println("Selecionei o produto");
	
		try {
			System.out.println("Estou verificando se tem em estoque");
			Thread.sleep(5000);
			System.out.println("Produto Adicionando no carrinho");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	@RabbitListener(queues = "filaPagamento")
	public void efetuarPagamento() {
		System.out.println("Recebi o pagamento");
	
		try {
			System.out.println("Estou processando o pagamento");
			Thread.sleep(5000);
			System.out.println("Pagamento Realizado");
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	@RabbitListener(queues = "filaAvaliacao")
	public void realizarAvaliacao() {
		System.out.println("Fiz a avaliação");
		
		try {
			System.out.println("Estou salvando a avaliação");
			Thread.sleep(5000);
			System.out.println("Avaliação salva");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
