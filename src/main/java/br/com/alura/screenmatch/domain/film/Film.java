package br.com.alura.screenmatch.domain.film;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Simple class representing a film's metadata
 */
@Entity
@Table(name = "films")
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
    
    
    /**
     * Standard Java constructor necessary for JPA
     */
    public Film() {}
    
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

    @SuppressWarnings("javadoc")
	public Long getId() {
		return id;
	}

    @SuppressWarnings("javadoc")
	public void setId(Long id) {
		this.id = id;
	}
}