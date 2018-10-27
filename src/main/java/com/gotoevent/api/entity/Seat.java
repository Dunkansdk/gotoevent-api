package com.gotoevent.api.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seats")
@NoArgsConstructor
public class Seat implements IValidation<Seat> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "number", length = 12, nullable = false)
	private String number;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@JoinColumn(name = "seat_type", nullable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private SeatType seatType;
	
	@JoinColumn(name = "calendar", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Calendar calendar;
	
	public Seat(long id, String number, BigDecimal price, SeatType seatType, Calendar calendar) {
		this.id = id;
		this.number = number;
		this.price = price;
		this.seatType = seatType;
		this.calendar = calendar;
	}
	
	public Seat(String number, BigDecimal price, SeatType seatType, Calendar calendar) {
		this.number = number;
		this.price = price;
		this.seatType = seatType;
		this.calendar = calendar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendar == null) ? 0 : calendar.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((seatType == null) ? 0 : seatType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof Seat)) return false;

		Seat seat = (Seat) obj;
		
		return this.id == seat.getId() && this.number.equals(seat.getNumber()) && this.price.equals(seat.getPrice()) && this.seatType.equals(seat.getSeatType()) && this.calendar.equals(seat.getCalendar());
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", number=" + number + ", price=" + price + ", seatType=" + seatType + ", calendar="
				+ calendar + "]";
	}

	@Override
	public boolean validateNullEmpty() {
        if(id >= 0 && number != null && !(number.trim().equals("")) && price != null && seatType.validateNullEmpty() && calendar.validateNullEmpty()) {
            return false;
        }

        return true;
	}

	@Override
	public boolean validateNullEmptyIdentifier() {
        return true;
	}		
	
}
