package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.Genre;
import com.gotoevent.api.repository.GenreRepository;
import com.gotoevent.api.repository.IRepositoryMethods;

@Service
public class GenreService implements IRepositoryMethods<Genre> {

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public List<Genre> getAll() throws Exception {
		return this.genreRepository.findAll();
	}

	@Override
	public Genre getByAttributeType(String value) throws Exception {
		return this.genreRepository.getAttribute(value);
	}

	@Override
	public Genre getById(Long id) throws Exception {
		Genre genre = null;
		Optional<Genre> genreOptional = this.genreRepository.findById(id);
		
		if(genreOptional.isPresent()) {
			genre = genreOptional.get();
		}
		
		return genre;
	}

	@Override
	public Genre newObject(Genre value) throws Exception {
		if(value != null) {
			this.genreRepository.save(value);
		}
		return value;
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.genreRepository.deleteById(id);		
	}

}
