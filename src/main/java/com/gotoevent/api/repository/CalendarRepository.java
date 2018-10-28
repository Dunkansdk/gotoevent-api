package com.gotoevent.api.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotoevent.api.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
	
	@Query(value="SELECT * FROM calendars a WHERE a.date = :date", nativeQuery = true)
    public Calendar getAttribute(@Param("date")LocalDate date);

}
