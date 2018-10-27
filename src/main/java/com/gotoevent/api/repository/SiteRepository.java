package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long>{
	
	@Query(value="SELECT * FROM sites a WHERE a.name = :name", nativeQuery = true)
    public Site getAttribute(@Param("name")String name);

}