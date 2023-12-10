package br.com.pjtec.livraria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.pjtec.livraria.entidade.enums.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome")
	@Size(min = 5, max = 35, message = "É Obrigatorio nome e sobrenome")
	@NotBlank(message = "É Obrigatorio preencher o campo")
	private String nome;
	@Column(name = "autor")
	@Size(min = 5, message = "É Obrigatorio o nome do Autor")
	@NotBlank(message = "É Obrigatorio preencher o campo")
	private String autor;
	@Column(name = "quantidade")
	@NotNull(message = "É Obrigatorio preencher o campo")
	private Integer quantidade;
	@Column(name = "preco")
	private Double preco;
	@Column(name = "categoria")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
