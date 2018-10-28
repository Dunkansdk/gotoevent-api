package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.SeatType;
import com.gotoevent.api.repository.IRepositoryMethods;
import com.gotoevent.api.repository.SeatTypeRepository;

@Service
public class SeatTypeService implements IRepositoryMethods<SeatType> {
	
	@Autowired
	private SeatTypeRepository seatTypeRepository;

	@Override
	public List<SeatType> getAll() throws Exception {
		return this.seatTypeRepository.findAll();
	}

	@Override
	public SeatType getByAttributeType(String value) throws Exception {
		return this.seatTypeRepository.getAttribute(value);
	}

	@Override
	public SeatType getById(Long id) throws Exception {
		SeatType seatType = null;
		Optional<SeatType> seatTypeOptional = this.seatTypeRepository.findById(id);
		
		if(seatTypeOptional.isPresent()) {
			seatType = seatTypeOptional.get();
		}
		return seatType;
	}

	@Override
	public SeatType newObject(SeatType value) throws Exception {
		return this.seatTypeRepository.save(value);
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.seatTypeRepository.deleteById(id);		
	}

}
