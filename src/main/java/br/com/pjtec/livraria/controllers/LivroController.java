package br.com.pjtec.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pjtec.livraria.entidade.Livro;
import br.com.pjtec.livraria.repositore.LivroRepositore;

@Controller
public class LivroController {
	@Autowired
	private LivroRepositore livroRepositore;

	@GetMapping("/inserirLivros")
	public ModelAndView insertLivro(Livro livro) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Livro/formLivro");
		mv.addObject("livro", new Livro());
		return mv;
	}

	@PostMapping("InsertLivros")
	public ModelAndView inserirLivro(Livro livro) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/livros-adicionados");
		livroRepositore.save(livro);
		return mv;
	}
	@GetMapping("livros-adicionados")
	public ModelAndView listagemLivros() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Livro/listLivros");
		mv.addObject("listLivros", livroRepositore.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Livro/alterar");
		Livro livro = livroRepositore.findById(id).orElseThrow();
		mv.addObject("livro",livro);
		return mv;
	}
	@PostMapping("/alterar")
	public ModelAndView alterar(Livro livro) {
		ModelAndView mv =  new ModelAndView();
		livroRepositore.save(livro);
		mv.setViewName("redirect:/livros-adicionados");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirLivro(@PathVariable("id")Long id) {
		livroRepositore.deleteById(id);
		return"redirect:/livros-adicionados";
	}
}
