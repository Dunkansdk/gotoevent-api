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

import com.gotoevent.api.entity.SeatType;
import com.gotoevent.api.service.SeatTypeService;

@RestController
@RequestMapping(value = "/seattype")
public class SeatTypeController {
	
	@Autowired
	private SeatTypeService seatTypeService;
	
	//@Autowired
	//private CategoryService categoryService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/", consumes = "application/json")
	public ResponseEntity add(@RequestBody List<SeatType> seatTypes) {
		
		// Ante la duda siempre es un error
		ResponseEntity status = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			for(SeatType seatType : seatTypes) {
				
				// Deberia setear aca otro service (FK)
				
				if(!seatType.validateNullEmpty()) {
					this.seatTypeService.newObject(seatType);
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
    public ResponseEntity<SeatType> update(@RequestBody SeatType value){

        ResponseEntity<SeatType> status = new ResponseEntity<SeatType>(HttpStatus.NO_CONTENT);

        try {

            if (!value.validateNullEmpty()) {
                this.seatTypeService.newObject(value);
                status = new ResponseEntity<SeatType>(HttpStatus.OK);
            }
  
        } catch(Exception e) {
            status = new ResponseEntity<SeatType>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<SeatType>> getAll() {

        ResponseEntity<List<SeatType>> status = new ResponseEntity<List<SeatType>>(HttpStatus.NO_CONTENT);

        try {
            List<SeatType> seatTypes = new ArrayList<SeatType>();
            seatTypes = this.seatTypeService.getAll();

            if (!seatTypes.isEmpty()) {
                status = new ResponseEntity<List<SeatType>>(seatTypes, HttpStatus.OK);
            }
        } catch (Exception e) {
            status = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<SeatType> getByOneSeatType(@RequestParam("seatType_type") String type) {

        ResponseEntity<SeatType> status = new ResponseEntity<SeatType>(HttpStatus.NO_CONTENT);
        SeatType seatType = null;

        try {
            if(type != null) {
            	seatType = this.seatTypeService.getByAttributeType(type);

                if(seatType != null){
                    status = new ResponseEntity<SeatType>(seatType, HttpStatus.OK);
                }
            }
        } catch(Exception e) {
            status = new ResponseEntity<SeatType>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

}

