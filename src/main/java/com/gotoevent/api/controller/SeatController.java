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

import com.gotoevent.api.entity.Seat;
import com.gotoevent.api.service.SeatService;


@RestController
@RequestMapping(value = "/seat")
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	//@Autowired
	//private CategoryService categoryService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/", consumes = "application/json")
	public ResponseEntity add(@RequestBody List<Seat> seats) {
		
		// Ante la duda siempre es un error
		ResponseEntity status = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			for(Seat seat : seats) {
				
				// Deberia setear aca otro service (FK)
				
				if(!seat.validateNullEmpty()) {
					this.seatService.newObject(seat);
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
    public ResponseEntity<Seat> update(@RequestBody Seat value){

        ResponseEntity<Seat> status = new ResponseEntity<Seat>(HttpStatus.NO_CONTENT);

        try {

            if (!value.validateNullEmpty()) {
                this.seatService.newObject(value);
                status = new ResponseEntity<Seat>(HttpStatus.OK);
            }
  
        } catch(Exception e) {
            status = new ResponseEntity<Seat>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<Seat>> getAll() {

        ResponseEntity<List<Seat>> status = new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);

        try {
            List<Seat> seats = new ArrayList<Seat>();
            seats = this.seatService.getAll();

            if (!seats.isEmpty()) {
                status = new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
            }
        } catch (Exception e) {
            status = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<Seat> getByOneSeat(@RequestParam("seat_type") String seat_type) {

        ResponseEntity<Seat> status = new ResponseEntity<Seat>(HttpStatus.NO_CONTENT);
        Seat seat = null;

        try {
            if(seat_type != null) {
            	seat = this.seatService.getByAttributeType(seat_type);

                if(seat != null){
                    status = new ResponseEntity<Seat>(seat, HttpStatus.OK);
                }
            }
        } catch(Exception e) {
            status = new ResponseEntity<Seat>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

}
