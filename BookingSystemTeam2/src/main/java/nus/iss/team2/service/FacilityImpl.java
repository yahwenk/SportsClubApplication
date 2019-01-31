package nus.iss.team2.service;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.team2.model.Facility;
import nus.iss.team2.repository.FacilityRepository;


@Service
public  class FacilityImpl implements FacilityService {
	
	@Resource 
	public FacilityRepository facilityRepository;
	
	@Override
	@Transactional
	public ArrayList<Facility> findAllFacility()
	{
		
			ArrayList<Facility> fac = (ArrayList<Facility>) facilityRepository.findAll();
			return fac;
		
	}
	

    @Override
    @Transactional
	public void removeFacility(Facility facility) 
    {
		facilityRepository.delete(facility);
	}

	@Override
	@Transactional
	public Facility findFacility(int facilityID)
	{
		return facilityRepository.findFacility(facilityID);
		
		
	}


	@Override
	@Transactional
	public Facility createFacility(Facility facility) {
		return facilityRepository.save(facility);
	}

	@Override
	@Transactional
	public Facility changeFacility(Facility facility) {
		return facilityRepository.saveAndFlush(facility);
	}
	

	@Override
	@Transactional
	public ArrayList<Facility> findAllFacilityBooking() {
		ArrayList<Facility> fc=(ArrayList<Facility>) facilityRepository.findAll();
		return fc;
	}

	@Override
	@Transactional
	public ArrayList<Facility> findFacilitywp(String s) {
		
		return (ArrayList<Facility>) facilityRepository.findAll();


	
	}


	@Override
	public ArrayList<Facility> findFacilityName(String s) {
		return (ArrayList<Facility>) facilityRepository.findAll();
	}
}


