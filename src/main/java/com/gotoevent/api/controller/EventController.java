package com.gotoevent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotoevent.api.entity.Event;
import com.gotoevent.api.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping(value = "/", consumes = "application/json")
	public ResponseEntity add(@RequestBody List<Event> events) {
		
		// Ante la duda siempre es un error
		ResponseEntity status = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			for(Event event : events) {
				
				// Deberia setear aca otro service (FK)
				
				if(!event.validateNullEmpty()) {
					this.eventService.newObject(event);
					status = new ResponseEntity(HttpStatus.OK);
				} else {
					status = new ResponseEntity(HttpStatus.NO_CONTENT);
					break;
				}
				
			}
		} catch(Exception e) {
			status = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return status;
	}
	

}
