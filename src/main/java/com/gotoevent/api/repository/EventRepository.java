package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
	@Query(value="SELECT * FROM events a WHERE a.name = :name", nativeQuery = true)
    public Event getAttribute(@Param("name")String name);

}
