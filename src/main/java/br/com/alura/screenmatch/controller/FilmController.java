package br.com.alura.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.screenmatch.domain.film.Film;
import br.com.alura.screenmatch.domain.film.FilmDto;
import br.com.alura.screenmatch.domain.film.FilmRepository;

/**
 * Controller for the /films URL
 */
@Controller
@RequestMapping("/films")
public class FilmController {
	
	@Autowired
	private FilmRepository repository;
	
	/**
	 * @param model for spring boot
	 * @return returns the path for the form
	 */
	@GetMapping
	public String loadListingPage(Model model) {
		model.addAttribute("list", repository.findAll());
		return "films/listing";
	}
	
	/**
	 * @return returns the path for the form
	 */
	@GetMapping("/form")
	public String loadFormPage() {
		return "films/form";
	}
	
	/**
	 * @param data the data that will be posted in the form page
	 * @return the same page (temporary)
	 */
	@PostMapping("/form")
	public String postFilm(FilmDto data) {
		repository.save(new Film(data));
		return "redirect:/films";
	}
	
}