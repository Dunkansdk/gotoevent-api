package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.Event;
import com.gotoevent.api.repository.EventRepository;
import com.gotoevent.api.repository.IRepositoryMethods;

@Service
public class EventService implements IRepositoryMethods<Event> {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAll() throws Exception {
		return this.eventRepository.findAll();
	}

	@Override
	public Event getByAttributeType(String value) throws Exception {
		return this.eventRepository.getAttribute(value);
	}

	@Override
	public Event getById(Long id) throws Exception {
		Event event = null;
		Optional<Event> eventOptional = this.eventRepository.findById(id);
		
		if(eventOptional.isPresent()) {
			event = eventOptional.get();
		}
		
		return event;
	}

	@Override
	public Event newObject(Event value) throws Exception {
		if(value != null) {
			this.eventRepository.save(value);
		}
		
		return value;
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.eventRepository.deleteById(id);		
	}

}
