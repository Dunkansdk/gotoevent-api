package com.gotoevent.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "genres")
@NoArgsConstructor
public class Genre implements IValidation<Genre> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	public Genre(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Genre(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof Genre)) return false;

		Genre genre = (Genre) obj;
		
		return this.id == genre.getId() && this.name.equals(genre.getName());
	}
	
	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}	

	@Override
	public boolean validateNullEmpty() {
        if(id >= 0 && name != null && !(name.trim().equals(""))) {
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
