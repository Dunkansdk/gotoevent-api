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

import com.gotoevent.api.entity.Genre;
import com.gotoevent.api.service.GenreService;


@RestController
@RequestMapping(value = "/genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/", consumes = "application/json")
	public ResponseEntity add(@RequestBody List<Genre> genres) {
		
		// Ante la duda siempre es un error
		ResponseEntity status = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			for(Genre genre : genres) {
				
				// Deberia setear aca otro service (FK)
				
				if(!genre.validateNullEmpty()) {
					this.genreService.newObject(genre);
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
    public ResponseEntity<Genre> update(@RequestBody Genre value){

        ResponseEntity<Genre> status = new ResponseEntity<Genre>(HttpStatus.NO_CONTENT);

        try {

            if (!value.validateNullEmpty()) {
                this.genreService.newObject(value);
                status = new ResponseEntity<Genre>(HttpStatus.OK);
            }
  
        } catch(Exception e) {
            status = new ResponseEntity<Genre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<Genre>> getAll() {

        ResponseEntity<List<Genre>> status = new ResponseEntity<List<Genre>>(HttpStatus.NO_CONTENT);

        try {
            List<Genre> genres = new ArrayList<Genre>();
            genres = this.genreService.getAll();

            if (!genres.isEmpty()) {
                status = new ResponseEntity<List<Genre>>(genres, HttpStatus.OK);
            }
        } catch (Exception e) {
            status = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<Genre> getByOneAirport(@RequestParam("name") String name) {

        ResponseEntity<Genre> status = new ResponseEntity<Genre>(HttpStatus.NO_CONTENT);
        Genre genre = null;

        try {
            if(name != null) {
            	genre = this.genreService.getByAttributeType(name);

                if(genre != null){
                    status = new ResponseEntity<Genre>(genre, HttpStatus.OK);
                }
            }
        } catch(Exception e) {
            status = new ResponseEntity<Genre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

}
