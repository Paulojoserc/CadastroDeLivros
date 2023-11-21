package br.com.pjtec.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
