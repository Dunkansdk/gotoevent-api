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
@Table(name = "sites")
@NoArgsConstructor
public class Site implements IValidation<Site> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
	
	@Column(name = "city", length = 50, nullable = false)
	private String city;
	
	@Column(name = "province", length = 50, nullable = false)
	private String province;
	
	@Column(name = "address", length = 80, nullable = false, unique = true)
	private String address;
	
	@Column(name = "capacity", length = 8, nullable = false)
	private int capacity;
	
	public Site(long id, String name, String city, String province, String address, int capacity) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.province = province;
		this.address = address;
		this.capacity = capacity;
	}
	
	public Site(String name, String city, String province, String address, int capacity) {
		this.name = name;
		this.city = city;
		this.province = province;
		this.address = address;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", city=" + city + ", province=" + province + ", address="
				+ address + ", capacity=" + capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + capacity;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || (obj instanceof Site)) return false;

		Site site = (Site) obj;
		
		return this.id == site.getId() && this.city.equals(site.getCity()) && this.province.equals(site.getProvince()) 
			&& this.address.equals(site.getAddress()) && this.capacity == site.getCapacity() && this.name.equals(site.getName());
	}

	@Override
	public boolean validateNullEmpty() {
        if(id >= 0 && name != null && !(name.trim().equals("")) && address != null && !(address.trim().equals(""))
        		   && city != null && !(city.trim().equals("")) && province != null && !(province.trim().equals(""))) {
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
