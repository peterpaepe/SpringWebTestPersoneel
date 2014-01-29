package be.vdab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemer")
class WerknemerController {
	private final WerknemerService werknemerService;
	
	@Autowired//met deze annotation injecteert Spring de parameter filiaalService met de bean die de interface FiliaalService implementeert: FiliaalServiceImpl
	WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView("werknemer",
				"werknemers", werknemerService.findAll());
	}
}