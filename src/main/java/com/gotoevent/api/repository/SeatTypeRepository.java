package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.SeatType;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
	
	@Query(value="SELECT * FROM seat_types a WHERE a.type = :type", nativeQuery = true)
    public SeatType getAttribute(@Param("type")String type);

}
