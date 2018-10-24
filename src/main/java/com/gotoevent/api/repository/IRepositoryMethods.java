package com.gotoevent.api.repository;

import java.util.List;

public interface IRepositoryMethods<T> {
	
	List<T> getAll() throws Exception;
    T getByAttributeType(String value) throws Exception;
    T getById(Long id) throws Exception;
    T newObject(T value) throws Exception;

    void removeObject(Long id) throws Exception;
    
}

