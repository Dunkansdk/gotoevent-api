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
@Table(name = "seat_types")
@NoArgsConstructor
public class SeatType implements IValidation<SeatType> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "types", length = 50, nullable = false, unique = true)
	private String type;
	
	public SeatType(long id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public SeatType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SeatType [id=" + id + ", type=" + type + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof SeatType)) return false;

		SeatType seatType = (SeatType) obj;
		
		return this.id == seatType.getId() && this.type.equals(seatType.getType());
	}

	@Override
	public boolean validateNullEmpty() {
        if(id >= 0 && type != null && !(type.trim().equals(""))) {
            return false;
        }

        return true;
	}

	@Override
	public boolean validateNullEmptyIdentifier() {
        if(type != null && !(type.trim().equals(""))) {
            return false;
        }
        return true;
	}		

}
