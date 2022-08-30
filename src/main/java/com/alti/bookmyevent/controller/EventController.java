package com.alti.bookmyevent.controller;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alti.bookmyevent.ORM.Category;
import com.alti.bookmyevent.ORM.Event;
import com.alti.bookmyevent.service.EventService;

@RestController()
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventService eventService;

	@PostMapping()
	public ResponseEntity<Event> createEvent(@RequestBody Event model) {
		Event response = eventService.saveEvent(model);
		return new ResponseEntity<Event>(response, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Event>> getAllEvents() {
		List<Event> response = eventService.getAllEvents();
		return new ResponseEntity<List<Event>>(response, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Event> getEventById(@RequestParam Integer id) throws Exception {
		return new ResponseEntity<Event>(eventService.getEventById(id), HttpStatus.OK);
	}

	@GetMapping("/category")
	public ResponseEntity<List<Event>> getEventsByCategory(@RequestParam String category) {
		return new ResponseEntity<List<Event>>(eventService.getEventsByCategory(category), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Event> updateEent(@RequestBody Event event) {
		return new ResponseEntity<Event>(eventService.updateEvent(event), HttpStatus.OK);
	}

	@DeleteMapping()
	public void deleteEvent(@RequestParam Integer id) {
		eventService.deleteEventById(id);
	}
}
