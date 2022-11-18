package com.semanaspringjava.springjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semanaspringjava.springjava.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	/*jparepository - componente que busca dados no banco - salva, deleta e busca as vendas no bd*/

}
