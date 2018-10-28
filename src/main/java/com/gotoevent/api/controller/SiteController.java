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

import com.gotoevent.api.entity.Site;
import com.gotoevent.api.service.SiteService;

@RestController
@RequestMapping(value = "/site")
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	@PostMapping(value = "/" , consumes = "application/json")
    public ResponseEntity<Site> add(@RequestBody List<Site> sites) {

    	ResponseEntity<Site> status = new ResponseEntity<Site>(HttpStatus.NO_CONTENT);

        try {
            for(Site site : sites) {
                if (!site.validateNullEmpty()) {
                    this.siteService.newObject(site);
                    status = new ResponseEntity<Site>(HttpStatus.OK);

                } else {
                    status = new ResponseEntity<Site>(HttpStatus.NO_CONTENT);
                    break;
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Site>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@PutMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Site> update(@RequestBody Site site){

    	ResponseEntity<Site> status = new ResponseEntity<Site>(HttpStatus.NO_CONTENT);

        try {
            if(site != null && !(site.validateNullEmpty())) {
            	Site siteDB = this.siteService.getById(site.getId());

                if(siteDB != null) {
                    this.siteService.newObject(site);
                    status = new ResponseEntity<Site>(HttpStatus.OK);
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Site>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@DeleteMapping(value = "/")
    public ResponseEntity<Site> remove(@RequestParam("id") Long id){

    	ResponseEntity<Site> status = new ResponseEntity<Site>(HttpStatus.NO_CONTENT);

        try {
            if(id != null && id > 0){
                this.siteService.removeObject(id);
                status = new ResponseEntity<Site>(HttpStatus.OK);
            }
        } catch(Exception e) {
            status = new ResponseEntity<Site>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping
    public ResponseEntity<List<Site>> getAll() {

    	ResponseEntity<List<Site>> status = new ResponseEntity<List<Site>>(HttpStatus.NO_CONTENT);
        List<Site> sites = new ArrayList<Site>();

        try {
        	sites = this.siteService.getAll();
           if(!sites.isEmpty()){
               status = new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
           }
        } catch(Exception e){
            status = new ResponseEntity<List<Site>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
	
	@GetMapping(value= "/")
    public ResponseEntity<Site> getByOneSiteName(@RequestParam("name") String name){

    	ResponseEntity<Site> status = new ResponseEntity<Site>(HttpStatus.NO_CONTENT);
        Site site = null;

        try {
            if(name != null) {
            	site = this.siteService.getByAttributeType(name);

                if(site != null) {
                    status = new ResponseEntity<Site>(site, HttpStatus.OK);

                }
            }
        } catch(Exception e) {
           status = new ResponseEntity<Site>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

}
