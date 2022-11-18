package com.semanaspringjava.springjava.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*anotation - código especial que se coloca perto de uma classe, 
um atributo, um elemento de uma classe, 
para que seja feito um pré processamento na hora de compilar o projeto e gerar o programa executável
preparação do código para que seja equivalente à uma tabela do banco*/

@Entity 
@Table(name = "tb_sales")
public class Sale {
	
	/*declaração das variáveis*/
	
	@Id /*identificação de dado único*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sellerName;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	/*criação do construtor - função*/
	
	public Sale(){
		
	}
	
	/*métodos de acesso*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
