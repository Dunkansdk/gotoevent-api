package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoevent.api.entity.Artist;
import com.gotoevent.api.repository.ArtistRepository;
import com.gotoevent.api.repository.IRepositoryMethods;

@Service
public class ArtistService implements IRepositoryMethods<Artist> {
	
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public List<Artist> getAll() throws Exception {
		return this.artistRepository.findAll();
	}

	@Override
	public Artist getByAttributeType(String value) throws Exception {
		return this.artistRepository.getAttribute(value);
	}

	@Override
	public Artist getById(Long id) throws Exception {
		Artist artist = null;
		Optional<Artist> artistOptional = this.artistRepository.findById(id);
		
		if(artistOptional.isPresent()) {
			artist = artistOptional.get();
		}
		
		return artist;
	}

	@Override
	public Artist newObject(Artist value) throws Exception {
		if(value != null) {
			this.artistRepository.save(value);
		}
		return value;
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.artistRepository.deleteById(id);		
	}
	
	

}
