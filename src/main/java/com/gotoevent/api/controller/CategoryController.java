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

import com.gotoevent.api.entity.Category;
import com.gotoevent.api.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/" , consumes = "application/json")
    public ResponseEntity<Category> add(@RequestBody List<Category> categories) {

    	ResponseEntity<Category> status = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);

        try {
            for(Category category : categories) {
                if (!category.validateNullEmpty()) {
                    this.categoryService.newObject(category);
                    status = new ResponseEntity<Category>(HttpStatus.OK);

                } else {
                    status = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
                    break;
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @PutMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Category> update(@RequestBody Category category){

    	ResponseEntity<Category> status = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);

        try {
            if(category != null && !(category.validateNullEmpty())) {
                Category categoryDB = this.categoryService.getById(category.getId());

                if(categoryDB != null) {
                    this.categoryService.newObject(category);
                    status = new ResponseEntity<Category>(HttpStatus.OK);
                }
            }
        } catch(Exception e){
            status = new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<Category> remove(@RequestParam("id") Long id){

    	ResponseEntity<Category> status = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);

        try {
            if(id != null && id > 0){
                this.categoryService.removeObject(id);
                status = new ResponseEntity<Category>(HttpStatus.OK);
            }
        } catch(Exception e) {
            status = new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {

    	ResponseEntity<List<Category>> status = new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        List<Category> categories = new ArrayList<Category>();

        try{
        	categories = this.categoryService.getAll();
           if(!categories.isEmpty()){
               status = new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
           }
        } catch(Exception e){
            status = new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }

    @GetMapping(value= "/")
    public ResponseEntity<Category> getByOneCategory(@RequestParam("name") String name){

    	ResponseEntity<Category> status = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
        Category category = null;

        try{
            if(name != null) {
            	category= this.categoryService.getByAttributeType(name);

                if(category != null) {
                    status = new ResponseEntity<Category>(category, HttpStatus.OK);

                }
            }
        } catch(Exception e) {
           status = new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return status;
    }
}