package br.com.vicente.exemplomensageriaback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vicente.exemplomensageriaback.service.CommonService;

@RestController
@RequestMapping("/common")
public class CommonController {
	
	
	private final CommonService commomService;
	
	public CommonController(final CommonService commomService) {
		this.commomService = commomService;
	}
	
	@GetMapping("/produtos")
	public String selecionarProduto() {
		return commomService.selecioanrProduto();
	}
	
	
	@GetMapping("/pagamentos")
	public String efetuarPagamento() {
		return commomService.efetuarPagamento();
	}
	
	@GetMapping("/avaliacao")
	public String realizarAvaliacao() {
		return commomService.realizarAvaliacao();
	}

}
