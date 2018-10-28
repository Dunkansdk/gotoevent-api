package com.gotoevent.api.service;

import java.util.List;
import java.util.Optional;

import com.gotoevent.api.entity.Site;
import com.gotoevent.api.repository.IRepositoryMethods;
import com.gotoevent.api.repository.SiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService implements IRepositoryMethods<Site> {
	
	@Autowired
	private SiteRepository siteRepository;

	@Override
	public List<Site> getAll() throws Exception {
		return this.siteRepository.findAll();
	}

	@Override
	public Site getByAttributeType(String value) throws Exception {
		return this.siteRepository.getAttribute(value);
	}

	@Override
	public Site getById(Long id) throws Exception {
		Optional<Site> siteOptional = this.siteRepository.findById(id);
		
		if(siteOptional.isPresent()) {
			return siteOptional.get();
		}		
		return null;
	}

	@Override
	public Site newObject(Site value) throws Exception {
		if(value != null) {
			this.siteRepository.save(value);
		}
		
		return value;
	}

	@Override
	public void removeObject(Long id) throws Exception {
		this.siteRepository.deleteById(id);		
	}	

}
