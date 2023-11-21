package br.com.pjtec.livraria.entidade.enums;

public enum Categoria {

	FANTASIA(0, "Fantasia"),
	FICCAO_CIENTIFICA(1, "Ficção científica"),
	DISTOPIA(2, "Distopia"),
	FICCAO_POLICIAL(3, "Ficção Policial"),
	ACAO_E_AVENTURA(4, "Ação e aventura"),
	HORROR_E_SUSPENSE (5, "Horror"),
	ROMANCE(6, "Romance"),
	CONTO(7, "Conto"),
	INFANTIL(8, "Infantil"),
	BIOGRAFIA(9,"Biografia"),
	GASTONOMIA(10, "Gastronomia"),
	AUTOAJUDA(11, "Autoajuda");
	
	

	private Integer codigo;
	private String categoria;
	private Categoria(Integer codigo, String categoria) { this.codigo = codigo;
	this.categoria = categoria; } public Integer getCodigo() { return codigo; }
	public String getDescricao() { return categoria; }
	
}
