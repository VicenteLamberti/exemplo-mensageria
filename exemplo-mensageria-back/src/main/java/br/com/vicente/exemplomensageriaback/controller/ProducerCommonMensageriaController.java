package br.com.vicente.exemplomensageriaback.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/common/mensageria")
public class ProducerCommonMensageriaController {
	

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	
	
	@GetMapping("/produtos")
	public String selecionarProduto() {
		rabbitTemplate.convertAndSend("pagamentos.ex","filaProduto","Produto para checar no estoque");
		return "Mensagem back: Chegou a requisição de que você está querendo um produto, mas antes de pesquisar no estoque, já foi liberado pra você o pagamento";
	}
	
	
	@GetMapping("/pagamentos")
	public String efetuarPagamento() {
		rabbitTemplate.convertAndSend("pagamentos.ex","filaPagamento","Realizar verificação no pagamento");
		return "Mensagem back: Chegou a requisição de que você está querendo realizar o pagamento, mas antes de processar, já foi liberado pra você efetuar a avaliação";
	}
	
	@GetMapping("/avaliacao")
	public String realizarAvaliacao() {
		rabbitTemplate.convertAndSend("pagamentos.ex","filaAvaliacao","Realizar avaliação");
		return "Mensagem back: Chegou a requisição de que você está querendo realizar a avaliação, mas antes de processar, já foi finalizado todo o procedimento";
	}

}
