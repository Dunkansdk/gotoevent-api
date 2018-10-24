package com.gotoevent.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Event")
@NoArgsConstructor
public class Event implements IValidation<Event> {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "image", nullable = false)
	private String image;
	
	public Event(long id, String name, String description, String image) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
	}
	
	public Event(String name, String description, String image) {
		this.name = name;
		this.description = description;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof Event)) return false;

		Event event = (Event) obj;
		
		return this.id == event.getId() && this.name.equals(event.getName()) && this.description.equals(event.getDescription()) && this.image.equals(event.getImage());
	}

	@Override
	public boolean validateNullEmpty() {
		return true;
	}

	@Override
	public boolean validateNullEmptyIdentifier() {
		return true;
	}
	
}
