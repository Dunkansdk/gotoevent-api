package com.gotoevent.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotoevent.api.entity.Event;
import com.gotoevent.api.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@SuppressWarnings("rawtypes")
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
	
	@PutMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Event> update(@RequestBody Event value){

        ResponseEntity<Event> status = new ResponseEntity<Event>(HttpStatus.NO_CONTENT);

        try {

            if (!value.validateNullEmpty()) {
                this.eventService.newObject(value);
                status = new ResponseEntity<Event>(HttpStatus.OK);
            }
  
        } catch(Exception e) {
            status = new ResponseEntity<Event>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<Event>> getAll() {

        ResponseEntity<List<Event>> status = new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);

        try {
            List<Event> events = new ArrayList<Event>();
            events = this.eventService.getAll();

            if (!events.isEmpty()) {
                status = new ResponseEntity<List<Event>>(events, HttpStatus.OK);
            }
        } catch (Exception e) {
            status = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<Event> getByOneAirport(@RequestParam("name") String name) {

        ResponseEntity<Event> status = new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
        Event event = null;

        try{
            if(name != null) {
            	event = this.eventService.getByAttributeType(name);

                if(event != null){
                    status = new ResponseEntity<Event>(event, HttpStatus.OK);
                }
            }
        } catch(Exception e) {
            status = new ResponseEntity<Event>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	

}
