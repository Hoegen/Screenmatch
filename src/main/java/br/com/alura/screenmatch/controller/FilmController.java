package br.com.alura.screenmatch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.screenmatch.domain.FilmDto;
import br.com.alura.screenmatch.domain.film.Film;

/**
 * Controller for the /films URL
 */
@Controller
@RequestMapping("/films")
public class FilmController {
	
	private List<Film> films = new ArrayList<Film>();
	
	/**
	 * @return returns the path for the form
	 */
	@GetMapping
	public String loadFormPage() {
		return "films/form";
	}
	
	
	/**
	 * @param data the data that will be posted in the form page
	 * @return the same page (temporary)
	 */
	@PostMapping
	public String postFilm(FilmDto data) {
		films.add(new Film(data));
		System.out.println(films);
		return "films/form";
	}
	
}