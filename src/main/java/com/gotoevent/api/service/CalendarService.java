package com.gotoevent.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.Calendar;
import com.gotoevent.api.repository.CalendarRepository;
import com.gotoevent.api.repository.IRepositoryMethods;

@Service
public class CalendarService implements IRepositoryMethods<Calendar> {

	@Autowired
	private CalendarRepository calendarRepository;
	
	@Override
	public List<Calendar> getAll() throws Exception {
		return this.calendarRepository.findAll();
	}

	@Override
	public Calendar getByAttributeType(String value) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");		
		return this.calendarRepository.getAttribute(LocalDate.parse(value, formatter));
	}

	@Override
	public Calendar getById(Long id) throws Exception {
		Calendar calendar = null;
		Optional<Calendar> calendarOptional = this.calendarRepository.findById(id);
		
		if(calendarOptional.isPresent()) {
			calendar = calendarOptional.get();
		}
		
		return calendar;
	}

	@Override
	public Calendar newObject(Calendar value) throws Exception {
		return this.calendarRepository.save(value);
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.calendarRepository.deleteById(id);		
	}

}
