package com.gotoevent.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "calendars")
@NoArgsConstructor
public class Calendar implements IValidation<Calendar> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;	
	
	@Column(name = "description", length = 65535, columnDefinition = "TEXT", nullable = false)
	private String description;

	@Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();
	
	@Column(name = "time", nullable = false)
    private LocalDateTime time = LocalDateTime.now();
		
	@JoinColumn(name = "site", nullable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Site site;
	
	@JoinColumn(name = "event", nullable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Event event;
	
	@JoinColumn(name = "artists", nullable = false)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Artist> artists;

	public Calendar(long id, String description, LocalDate date, LocalDateTime time, Site site, Event event, List<Artist> artists) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.time = time;
		this.site = site;
		this.event = event;
		this.artists = artists;
	}
	
	public Calendar(String description, LocalDate date, LocalDateTime time, Site site, Event event, List<Artist> artists) {
		this.description = description;
		this.date = date;
		this.time = time;
		this.site = site;
		this.event = event;
		this.artists = artists;
	}
	
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", description=" + description + ", date=" + date + ", time="
				+ time + ", site=" + site + ", event=" + event + ", artists=" + artists + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artists == null) ? 0 : artists.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof Calendar)) return false;

		Calendar calendar = (Calendar) obj;
		
		return this.id == calendar.getId() && this.date.equals(calendar.getDate()) && this.time.equals(calendar.getTime()) && this.event.equals(calendar.getEvent())
											&& this.site.equals(calendar.getSite()) && this.description.equals(calendar.getDescription());
	}

	@Override
	public boolean validateNullEmpty() {
		if(id >= 0 && date != null && time != null && description != null && !(description.trim().equals("")) && site != null && !(site.validateNullEmpty()) && event != null && event.validateNullEmpty() && artists != null && artists.isEmpty()) {
            return false;
        }

        return true;
	}

	@Override
	public boolean validateNullEmptyIdentifier() {
		if(date != null && time != null) {			
            return false;
        }
        return true;
	}
	
}
