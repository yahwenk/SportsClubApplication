package nus.iss.team2.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


import nus.iss.team2.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, String>{
	
	@Query("SELECT t FROM Booking t join t.user u where u.userID = :userid")
	ArrayList<Booking> bookingHistory(@Param("userid") String userid);
	
	@Query("SELECT f.facilityID FROM Booking t join t.fac f join t.user u where u.userID = :userid")
	ArrayList<Booking> bookingHistoryByFacID(@Param("userid") String userid);
	
	@Query("SELECT b.bookingTime from Booking b join b.fac f WHERE f.facilityID=:facid AND b.bookingDate=:bd")
	List<String> getBookedTs (@Param("facid") int facid, @Param("bd") Date bd);

	@Query("SELECT t FROM Booking t where t.bookingID = :transid")
	Booking findBooking(@Param("transid") int transid);
	

}
