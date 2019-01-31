package nus.iss.team2.model;

	import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



	@Entity
	@Table(name = "facility")
	public class Facility {
		
		public static final String ACTIVE = "ACTIVE";
		public static final String INACTIVE = "INACTIVE";
		    
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name="facilityID")
			private int facilityID;
		    
		    @Column(name = "facilityName")		    
			private String facilityName;
		    
			@Column(name = "status")
			private String status;
			
			@OneToMany(targetEntity=Booking.class, mappedBy="fac")
			//@JoinColumn(name = "facilityId")
			private List<Booking> trans = new ArrayList<Booking>();

			
			public List<Booking> getTrans() {
				return trans;
			}

			public void setTrans(List<Booking> trans) {
				this.trans = trans;
				//this.trans.addAll(trans);
			}

			public Facility() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Facility(int facilityID, String facilityName, String status, List<Booking> booking) {
				super();
				this.facilityID = facilityID;
				this.facilityName = facilityName;
				this.status = status;
				this.trans = booking;
			}

			public int getFacilityID() {
				return facilityID;
			}

			public void setFacilityID(int facilityID) {
				this.facilityID = facilityID;
			}

			public String getFacilityName() {
				return facilityName;
			}

			public void setFacilityName(String facilityName) {
				this.facilityName = facilityName;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

		
			
			
			
		

	}

