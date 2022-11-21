package com.semanaspringjava.springjava.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.semanaspringjava.springjava.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	/*jparepository - componente que busca dados no banco - salva, deleta e busca as vendas no bd*/

	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC") /*comando na linguagem jpql - parecida com o sql, adaptação para ficar aderente ao jpa*/
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
	/*função que faz uma pesquisa no banco de dados, recebendo as datas como argumento*/
	
}
