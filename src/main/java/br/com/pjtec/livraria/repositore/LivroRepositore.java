package br.com.pjtec.livraria.repositore;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pjtec.livraria.entidade.Livro;

public interface LivroRepositore extends JpaRepository<Livro, Integer> {

}
