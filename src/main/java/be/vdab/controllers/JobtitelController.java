package be.vdab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.JobtitelService;

@Controller
@RequestMapping("/jobtitels")
class JobtitelController {
	private final JobtitelService jobtitelService;
	
	@Autowired // met deze annotation injecteert Spring de parameter filiaalService met de bean die de interface FiliaalService implementeert: FiliaalServiceImpl
	JobtitelController(JobtitelService jobtitelService) {
		this.jobtitelService = jobtitelService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView("jobtitels/jobtitels", "jobtitels", jobtitelService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, params="id")
	ModelAndView read(long id) {
		return new ModelAndView("jobtitels/jobtitels", "jobtitel", jobtitelService.read(id)); 
	}
}