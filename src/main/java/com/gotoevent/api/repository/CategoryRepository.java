package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value="SELECT * FROM categories a WHERE a.name = :name", nativeQuery = true)
    public Category getAttribute(@Param("name")String name);

}
