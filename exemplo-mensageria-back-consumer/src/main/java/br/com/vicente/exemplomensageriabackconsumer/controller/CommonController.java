package br.com.vicente.exemplomensageriabackconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vicente.exemplomensageriabackconsumer.service.CommonService;

@RestController
@RequestMapping("/realizadorTarefas")
public class CommonController {

	private final CommonService commonService;
	
	public CommonController(CommonService commonService) {
		this.commonService = commonService;
	}
	
	@GetMapping("/produtos")
	public String selecionarProduto() {
		return commonService.selecionarProduto();
	}
	
	@GetMapping("/pagamentos")
	public String efetuarPagamento() {
		return commonService.efetuarPagamento();
	}
	
	@GetMapping("/avaliacao")
	public String realizarAvaliacao() {
		return commonService.realizarAvaliacao();
	}
}
