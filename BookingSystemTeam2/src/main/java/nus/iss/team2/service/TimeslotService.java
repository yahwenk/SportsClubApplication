package nus.iss.team2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import nus.iss.team2.model.timeslot;



public interface TimeslotService {

	ArrayList<timeslot> findAllTimeSlot();

	timeslot createTimeslot(timeslot times);

	timeslot changeTimeslot(timeslot times);

	void removeTimeslot(timeslot times);
}
