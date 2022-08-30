package com.alti.bookmyevent.service;

import java.util.List;

import com.alti.bookmyevent.ORM.Event;

public interface EventService {
	Event saveEvent(Event event);
	
	List<Event> getAllEvents();
	
	Event getEventById(Integer id);
	
	void deleteEventById(Integer id);
	
	Event updateEvent(Event event);
	
	List<Event> getEventsByCategory(String category);
}
