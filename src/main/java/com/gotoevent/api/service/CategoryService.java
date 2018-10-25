package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.Category;
import com.gotoevent.api.repository.CategoryRepository;
import com.gotoevent.api.repository.IRepositoryMethods;

@Service
public class CategoryService implements IRepositoryMethods<Category> {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() throws Exception {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category getByAttributeType(String value) throws Exception {
		return this.categoryRepository.getAttribute(value);
	}

	@Override
	public Category getById(Long id) throws Exception {
		Category category = null;
		Optional<Category> eventOptional = this.categoryRepository.findById(id);
		
		if(eventOptional.isPresent()) {
			category = eventOptional.get();
		}
		
		return category;
	}

	@Override
	public Category newObject(Category value) throws Exception {
		if(value != null) {
			this.categoryRepository.save(value);
		}
		
		return value;
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.categoryRepository.deleteById(id);		
	}

}
