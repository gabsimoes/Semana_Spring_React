package com.semanaspringjava.springjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semanaspringjava.springjava.entities.Sale;
import com.semanaspringjava.springjava.repositories.SaleRepository;

@Service
public class SaleService {
	/*componente responsável por fazer a operação com vendas*/

	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSales() {
		return repository.findAll();
	}
}

