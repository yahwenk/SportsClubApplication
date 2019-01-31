package nus.iss.team2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nus.iss.team2.model.Booking;
import nus.iss.team2.model.Facility;


public interface FacilityRepository extends JpaRepository<Facility, String> 
{
	
	@Query("SELECT f FROM Facility f where f.facilityID = :facid")
	Facility findFacility(@Param("facid") int facid);

}
