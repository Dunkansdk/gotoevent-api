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

import com.gotoevent.api.entity.Artist;
import com.gotoevent.api.service.ArtistService;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@PostMapping(value = "/" , consumes = "application/json")
    public ResponseEntity<Artist> add(@RequestBody List<Artist> artists) {

    	ResponseEntity<Artist> status = new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);

        try {
            for(Artist artist : artists) {
                if (!artist.validateNullEmpty()) {
                    this.artistService.newObject(artist);
                    status = new ResponseEntity<Artist>(HttpStatus.OK);

                } else {
                    status = new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);
                    break;
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Artist>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }	
	
	@PutMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Artist> update(@RequestBody Artist artist){

    	ResponseEntity<Artist> status = new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);

        try {
            if(artist != null && !(artist.validateNullEmpty())) {
            	Artist artistDB = this.artistService.getById(artist.getId());

                if(artistDB != null) {
                    this.artistService.newObject(artist);
                    status = new ResponseEntity<Artist>(HttpStatus.OK);
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Artist>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@DeleteMapping(value = "/")
    public ResponseEntity<Artist> remove(@RequestParam("id") Long id){

    	ResponseEntity<Artist> status = new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);

        try {
            if(id != null && id > 0){
                this.artistService.removeObject(id);
                status = new ResponseEntity<Artist>(HttpStatus.OK);
            }
        } catch(Exception e) {
            status = new ResponseEntity<Artist>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<Artist>> getAll() {

    	ResponseEntity<List<Artist>> status = new ResponseEntity<List<Artist>>(HttpStatus.NO_CONTENT);
        List<Artist> artists = new ArrayList<Artist>();

        try{
        	artists = this.artistService.getAll();
           if(!artists.isEmpty()){
               status = new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
           }
        } catch(Exception e){
            status = new ResponseEntity<List<Artist>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<Artist> getByOneArtist(@RequestParam("name") String name){

    	ResponseEntity<Artist> status = new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);
    	Artist artist = null;

        try{
            if(name != null) {
            	artist = this.artistService.getByAttributeType(name);

                if(artist != null) {
                    status = new ResponseEntity<Artist>(artist, HttpStatus.OK);

                }
            }
        } catch(Exception e) {
           status = new ResponseEntity<Artist>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }	 

}
