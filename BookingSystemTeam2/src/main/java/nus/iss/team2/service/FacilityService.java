package nus.iss.team2.service;

import java.util.ArrayList;

import nus.iss.team2.model.Facility;

public interface FacilityService {
ArrayList<Facility> findAllFacility();
	
	Facility createFacility(Facility facility); 
	
	void removeFacility(Facility facility);
	
	Facility findFacility(int facilityID);
	
	Facility changeFacility(Facility facility);
	
	ArrayList<Facility> findAllFacilityBooking();
	
	ArrayList<Facility> findFacilitywp(String s);
	
	ArrayList<Facility> findFacilityName(String s);


}
