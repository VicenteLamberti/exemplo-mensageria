package br.com.vicente.exemplomensageriabackconsumer.service;

import org.springframework.stereotype.Service;


@Service
public class ConsumerCommonService {
	

	public String selecionarProduto() {

		System.out.println("Selecionei o produto");
	
		try {
			System.out.println("Estou verificando se tem em estoque");
			Thread.sleep(5000);
			System.out.println("Produto Adicionando no carrinho");
			return "Mensagem back: Chegou a requisição de que você está querendo um produto, mas foi necessário esperar 5 minutos para realizar o processo";
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return "Ocorreu um problema ao selecionar o produto";
		}
		
	}

	public String efetuarPagamento() {
		System.out.println("Recebi o pagamento");
	
		try {
			System.out.println("Estou processando o pagamento");
			Thread.sleep(5000);
			System.out.println("Pagamento Realizado");
			return "Mensagem back: Chegou a requisição de que você está querendo realizar o pagamento,  mas foi necessário esperar 5 minutos para realizar o processo";
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return "Ocorreu um problema ao efetuar o pagamento";
		}
		
	}

	public String realizarAvaliacao() {
		System.out.println("Fiz a avaliação");
		
		try {
			System.out.println("Estou salvando a avaliação");
			Thread.sleep(5000);
			System.out.println("Avaliação salva");
			return "Mensagem back: Chegou a requisição de que você está querendo realizar a avaliação, mas foi necessário esperar 5 minutos para realizar o processo";
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return "Ocorreu um problema salvar a avaliação";
		}
	}

}
