package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Race;
import es.salesianos.service.Service;

@Controller
public class ListRaceController {

	@Autowired
	@Qualifier("raceService")
	private Service<Race> service;

	@PostMapping(path = "/listraces")
	private ModelAndView listAllRaces() {
		List<Race> races = service.listAll();
		ModelAndView model = new ModelAndView("ListRaces");
		model.addObject("listOfRaces", races);
		return model;
	}
	
}