package nus.iss.team2.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name = "timeslot")
public class timeslot {
	
	@Id
	@Basic(optional = false)
		
	@Column(name = "timeSlot")
	private String timeSlot;
	

	@JsonProperty
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	
	public timeslot() {
		super();
	}
	public timeslot(String timeSlot) {
		super();
		
		this.timeSlot = timeSlot;
	}
	
	
	
	


}
