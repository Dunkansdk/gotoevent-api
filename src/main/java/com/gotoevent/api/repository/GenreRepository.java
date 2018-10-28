package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	@Query(value="SELECT * FROM genres a WHERE a.name = :name", nativeQuery = true)
    public Genre getAttribute(@Param("name")String name);

}
