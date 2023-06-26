package br.com.alura.screenmatch.domain.film;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Film repository class that implements the Film class table via Spring interface
 */
public interface FilmRepository extends JpaRepository<Film, Long> {}