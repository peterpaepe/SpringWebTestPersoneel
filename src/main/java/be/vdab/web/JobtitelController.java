package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		return new ModelAndView("jobtitels/jobtitel", "jobtitels", jobtitelService.findAll());
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)//@RequestMapping(method = RequestMethod.GET, params="id")
	ModelAndView read(@PathVariable long id) {//	ModelAndView read(long id) {
		ModelAndView modelAndView = new ModelAndView("jobtitels/jobtitel", "jobtitels", jobtitelService.findAll());
		modelAndView.addObject("jobtitel", jobtitelService.read(id));
		return modelAndView;
	}
}