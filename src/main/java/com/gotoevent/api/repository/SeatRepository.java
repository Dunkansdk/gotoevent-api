package com.gotoevent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	@Query(value="SELECT * FROM seats a WHERE a.seat_type = :seat_type", nativeQuery = true)
    public Seat getAttribute(@Param("seat_type")Integer seat_type);

}
