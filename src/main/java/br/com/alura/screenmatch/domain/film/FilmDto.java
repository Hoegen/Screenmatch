package br.com.alura.screenmatch.domain.film;

/**
 * Simple dto for films
 * @param name Film's name
 * @param length Duration of the movie in minutes
 * @param year Year of first release
 * @param genre The film's categorization according to genre
 */
public record FilmDto(String name, Integer length, Integer year, String genre) {}