package com.semanaspringjava.springjava.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.semanaspringjava.springjava.entities.Sale;
import com.semanaspringjava.springjava.repositories.SaleRepository;

@Service
public class SaleService {
	/*componente responsável por fazer a operação com vendas*/

	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		/*criação da data com o dia de hoje*/
		
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate); 
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		/*converte a data na forma de texto para uma data na forma de localdate*/
		/*como se fosse um if - se o argumento de maxdate estiver vazio, retorna a data atual, senão ele converte e trás a data informada*/
		
		return repository.findSales(min, max, pageable);
	}
}

