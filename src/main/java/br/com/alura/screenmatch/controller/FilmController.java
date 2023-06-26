package br.com.alura.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.screenmatch.domain.film.EditFilm;
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
	 * @param id identifier for the film to be removed
	 * @return removes a movie from the database
	 */
	@DeleteMapping
	@Transactional
	public String removeFilm(Long id) {
		repository.deleteById(id);
		return "redirect:/films";
	}
	
	/**
	 * @return returns the path for the form
	 */
	@GetMapping("/form")
	public String loadFormPage(Long id, Model model) {
		if(id!=null) {
			var film = repository.getReferenceById(id);
			model.addAttribute("film", film);
		}
		return "films/form";
	}
	
	/**
	 * @param data the data that will be posted in the form page
	 * @return redirects to the listing page
	 */
	@PutMapping
	@Transactional
	public String putFilm(EditFilm data) {
		var film = repository.getReferenceById(data.id());
		film.updateData(data);
		return "redirect:/films";
	}
	
	/**
	 * @param data the data that will be posted in the form page
	 * @return redirects to the listing page
	 */
	@PostMapping
	@Transactional
	public String postFilm(FilmDto data) {
		repository.save(new Film(data));
		return "redirect:/films";
	}
	
}