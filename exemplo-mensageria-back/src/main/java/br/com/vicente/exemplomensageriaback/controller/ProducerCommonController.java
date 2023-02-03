package br.com.vicente.exemplomensageriaback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/common")
public class ProducerCommonController {
	
	
	@GetMapping("/produtos")
	public String selecionarProduto() {
		String url = "http://localhost:8081/realizadorTarefas/produtos";
		RestTemplate rt =  new RestTemplate();
		return rt.getForObject(url, String.class);
	}
	
	
	@GetMapping("/pagamentos")
	public String efetuarPagamento() {
		String url = "http://localhost:8081/realizadorTarefas/pagamentos";
		RestTemplate rt =  new RestTemplate();
		return rt.getForObject(url, String.class);
	}
	
	@GetMapping("/avaliacao")
	public String realizarAvaliacao() {
		String url = "http://localhost:8081/realizadorTarefas/avaliacao";
		RestTemplate rt =  new RestTemplate();
		return rt.getForObject(url, String.class);
	}

}
