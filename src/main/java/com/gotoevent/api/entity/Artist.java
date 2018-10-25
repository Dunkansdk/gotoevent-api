package com.gotoevent.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artists")
@NoArgsConstructor
public class Artist implements IValidation<Artist> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@JoinColumn(name = "genre", nullable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Genre genre;

	public Artist(long id, String name, Genre genre) {
		this.id = id;
		this.name = name;
		this.genre = genre;
	}
	
	public Artist(String name, Genre genre) {
		this.name = name;
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof Event)) return false;

		Artist artist = (Artist) obj;
		
		return this.id == artist.getId() && this.name.equals(artist.getName()) && this.genre.equals(artist.getGenre());
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", genre=" + genre + "]";
	}

	@Override
	public boolean validateNullEmpty() {
        if(id >= 0 && name != null && !(name.trim().equals("")) && genre != null && !(genre.validateNullEmpty())) {
            return false;
        }

        return true;
	}

	@Override
	public boolean validateNullEmptyIdentifier() {
        if(name != null && !(name.trim().equals(""))) {
            return false;
        }
        return true;
	}		

}
