package com.gotoevent.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotoevent.api.entity.Calendar;
import com.gotoevent.api.service.CalendarService;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@PostMapping(value = "/" , consumes = "application/json")
    public ResponseEntity<Calendar> add(@RequestBody List<Calendar> calendars) {

    	ResponseEntity<Calendar> status = new ResponseEntity<Calendar>(HttpStatus.NO_CONTENT);

        try {
            for(Calendar calendar : calendars) {
                if (!calendar.validateNullEmpty()) {
                    this.calendarService.newObject(calendar);
                    status = new ResponseEntity<Calendar>(HttpStatus.OK);

                } else {
                    status = new ResponseEntity<Calendar>(HttpStatus.NO_CONTENT);
                    break;
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Calendar>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }	
	
	@PutMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Calendar> update(@RequestBody Calendar calendar){

    	ResponseEntity<Calendar> status = new ResponseEntity<Calendar>(HttpStatus.NO_CONTENT);

        try {
            if(calendar != null && !(calendar.validateNullEmpty())) {
            	Calendar calendarDB = this.calendarService.getById(calendar.getId());

                if(calendarDB != null) {
                    this.calendarService.newObject(calendar);
                    status = new ResponseEntity<Calendar>(HttpStatus.OK);
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Calendar>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@DeleteMapping(value = "/")
    public ResponseEntity<Calendar> remove(@RequestParam("id") Long id){

    	ResponseEntity<Calendar> status = new ResponseEntity<Calendar>(HttpStatus.NO_CONTENT);

        try {
            if(id != null && id > 0){
                this.calendarService.removeObject(id);
                status = new ResponseEntity<Calendar>(HttpStatus.OK);
            }
        } catch(Exception e) {
            status = new ResponseEntity<Calendar>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<Calendar>> getAll() {

    	ResponseEntity<List<Calendar>> status = new ResponseEntity<List<Calendar>>(HttpStatus.NO_CONTENT);
        List<Calendar> calendars = new ArrayList<Calendar>();

        try{
        	calendars = this.calendarService.getAll();
           if(!calendars.isEmpty()){
               status = new ResponseEntity<List<Calendar>>(calendars, HttpStatus.OK);
           }
        } catch(Exception e){
            status = new ResponseEntity<List<Calendar>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<Calendar> getByOneCalendar(@RequestParam("date") String date){

    	ResponseEntity<Calendar> status = new ResponseEntity<Calendar>(HttpStatus.NO_CONTENT);
    	Calendar calendar = null;

        try{
            if(date != null) {
            	calendar = this.calendarService.getByAttributeType(date);

                if(calendar != null) {
                    status = new ResponseEntity<Calendar>(calendar, HttpStatus.OK);

                }
            }
        } catch(Exception e) {
           status = new ResponseEntity<Calendar>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }	 

}

