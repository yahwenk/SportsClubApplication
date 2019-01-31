package nus.iss.team2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "booking")
public class Booking {
	
		public static final String APPROVED = "APPROVED";
		public static final String UPDATED = "UPDATED";
		public static final String CANCELLED = "CANCELLED";

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "bookingID")
		private int bookingID;
		
//		@Column(name = "userID")
//		private String userID;
//		@Column(name = "facilityID")
//		private int facilityID;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "bookingDate")
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private Date bookingDate;
		@Column(name = "bookingTime")
		private String bookingTime;
		@Column(name = "status")
		private String status;
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="userID")
		//, insertable=false, updatable=false)
		private User user;
		
		@ManyToOne(fetch=FetchType.EAGER)		 
		@JoinColumn(name="facilityId")		
		//insertable=false, updatable=false)
		private Facility fac;
		
		
				
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Facility getFac() {
			return fac;
		}
		public void setFac(Facility fac) {
			this.fac = fac;
		}
		public Booking(Facility facility, int bookingID, User user, Date bookingDate, String bookingTime,
				String status /*String userID*//*int facilityID,*/ ) {
			super();
			this.bookingID = bookingID;
			//this.userID = userID;
			//this.facilityID = fac.getFacilityID();
			this.bookingDate = bookingDate;
			this.bookingTime = bookingTime;
			this.status = status;
			this.fac = facility;
			this.user = user;
		}
		public Booking() {
		
		}
		public int getBookingID() {
			return bookingID;
		}
		public void setBookingID(int bookingID) {
			this.bookingID = bookingID;
		}
//		public String getUserID() {
//			return userID;
//		}
//		public void setUserID(String userID) {
//			this.userID = userID;
//		}
//		public int getFacilityID() {
//			return fac.getFacilityID();
//		}
//		public void setFacilityID(int facilityID) {
//			this.facilityID = facilityID;
//		}
		public Date getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(Date date) {
			this.bookingDate = date;
		}
		public String getBookingTime() {
			return bookingTime;
		}
		public void setBookingTime(String bookingTime) {
			this.bookingTime = bookingTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
			result = prime * result + ((bookingTime == null) ? 0 : bookingTime.hashCode());
			
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			
//			result = prime * result + ((userID == null) ? 0 : userID.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Booking other = (Booking) obj;
			if (bookingDate == null) {
				if (other.bookingDate != null)
					return false;
			} else if (!bookingDate.equals(other.bookingDate))
				return false;
			if (bookingTime == null) {
				if (other.bookingTime != null)
					return false;
			} else if (!bookingTime.equals(other.bookingTime))
				return false;
			
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			
//			if (userID == null) {
//				if (other.userID != null)
//					return false;
//			} else if (!userID.equals(other.userID))
//				return false;
			return true;
		}
		

		
}
