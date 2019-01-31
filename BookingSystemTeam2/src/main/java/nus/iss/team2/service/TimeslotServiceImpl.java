package nus.iss.team2.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.team2.model.timeslot;
import nus.iss.team2.repository.TimeslotRepository;


@Service
public class TimeslotServiceImpl implements TimeslotService{
	
	@Resource
	private TimeslotRepository timeSlotRepo;

	@Override
	@Transactional
	public ArrayList<timeslot> findAllTimeSlot() {
		
		return (ArrayList<timeslot>) timeSlotRepo.findAll();
	}

	@Override
	@Transactional
	public timeslot createTimeslot(timeslot times) {
		
		return timeSlotRepo.saveAndFlush(times);
	}

	@Override
	@Transactional
	public timeslot changeTimeslot(timeslot times) {
		
		return timeSlotRepo.saveAndFlush(times);
	}

	@Override
	@Transactional
	public void removeTimeslot(timeslot times) {
		
		timeSlotRepo.delete(times);
		
	}
	
	
	


}
