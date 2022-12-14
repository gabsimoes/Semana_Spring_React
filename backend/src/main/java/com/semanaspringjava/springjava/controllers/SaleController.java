package com.semanaspringjava.springjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semanaspringjava.springjava.entities.Sale;
import com.semanaspringjava.springjava.services.SaleService;
import com.semanaspringjava.springjava.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Sale> findSales(
			/*value="minDate", default = "" - nome que vai ter o parâmetro na hora de chamar na web e, se não for informado o parâmetro na hora de mandar a requisição, considera-se o texto vazio*/
			@RequestParam(value="minDate", defaultValue = "") String minDate,  
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
		/*trás resultado paginado*/
		
	}
	
	/*configuração de envio de sms, de acordo com o smsservice*/
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
