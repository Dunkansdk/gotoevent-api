package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
	
	@Query(value="SELECT * FROM artists a WHERE a.name = :name", nativeQuery = true)
    public Artist getAttribute(@Param("name")String name);

}
