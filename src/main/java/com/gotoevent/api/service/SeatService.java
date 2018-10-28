package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.Seat;
import com.gotoevent.api.repository.IRepositoryMethods;
import com.gotoevent.api.repository.SeatRepository;

@Service
public class SeatService implements IRepositoryMethods<Seat> {
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<Seat> getAll() throws Exception {
		return this.seatRepository.findAll();
	}

	@Override
	public Seat getByAttributeType(String value) throws Exception {
		return this.seatRepository.getAttribute(Integer.parseInt(value));
	}

	@Override
	public Seat getById(Long id) throws Exception {
		Seat seat = null;
		Optional<Seat> seatOptional = this.seatRepository.findById(id);
		
		if(seatOptional.isPresent()) {
			seat = seatOptional.get();
		}
		
		return seat;
	}

	@Override
	public Seat newObject(Seat value) throws Exception {
		if(value != null) {
			this.seatRepository.save(value);
		}
		return value;
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.seatRepository.deleteById(id);		
	}

}
