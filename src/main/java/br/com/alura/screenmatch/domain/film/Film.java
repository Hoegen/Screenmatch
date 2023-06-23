package br.com.alura.screenmatch.domain.film;

import br.com.alura.screenmatch.domain.FilmDto;

/**
 * Simple class representing a film
 */
public class Film {
    private String name;
    private Integer length;
    private Integer year;
    private String genre;

    /**
     * Constructor for Film class from a FilmDto
     * @param filmDto a DataTransferObject
     */
    public Film(FilmDto filmDto) {
        this.name = filmDto.name();
        this.length = filmDto.length();
        this.year = filmDto.year();
        this.genre = filmDto.genre();
    }
    
    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }

    @SuppressWarnings("javadoc")
	public String getName() {
        return name;
    }
    
    @SuppressWarnings("javadoc")
    public Integer getLength() {
        return length;
    }

    @SuppressWarnings("javadoc")
    public Integer getYear() {
        return year;
    }

    @SuppressWarnings("javadoc")
    public String getGenre() {
        return genre;
    }
}