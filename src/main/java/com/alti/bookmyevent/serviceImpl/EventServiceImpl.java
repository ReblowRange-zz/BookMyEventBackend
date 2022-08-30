package com.alti.bookmyevent.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alti.bookmyevent.ORM.Event;
import com.alti.bookmyevent.repository.EventJPARepository;
import com.alti.bookmyevent.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired EventJPARepository eventJPARepository;
	
	@Override
	public Event saveEvent(Event event) {
		Event reponse = eventJPARepository.save(event);
		return reponse;
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> response = eventJPARepository.findAll();
		return response;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Event getEventById(Integer id) {
		Event response = eventJPARepository.getById(id);
		return response;
	}

	@Override
	public void deleteEventById(Integer id) {
		eventJPARepository.deleteById(id);
	}

	@Override
	public Event updateEvent(Event event) {
		Event reponse = eventJPARepository.save(event);
		return reponse;
	}
	
	@Override
	public List<Event> getEventsByCategory(String category) {
		return eventJPARepository.getEventsByCategory(category);
	}

}
