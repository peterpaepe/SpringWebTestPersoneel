package be.vdab.controllers;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import be.vdab.dao.CreateDAOBeans;
import be.vdab.services.CreateServiceBeans;

public class Initializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {//Je class erft van AbstractAnnotationConfigDispatcherServletInitializer. Deze class registreert de DispatcherServlet als servlet bij de webserver.

	@Override
	protected String[] getServletMappings() {//Je associeert in deze method de DispatcherServlet met URL patronen. De webserver stuurt requests, waarvan de URL overeenkomt met één van deze URL patronen naar de DispatcherServlet
		return new String[] { "/" };//Het URL patroon / staat voor alle requests van je website. Je stuurt dus alle requests van je website naar de DispatcherServlet
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return  new Class<?>[] { CreateDAOBeans.class, CreateServiceBeans.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//Je geeft in deze method aan welke classes de Java Config code bevatten voor je controller beans
		// TODO Auto-generated method stub
		return new Class<?>[] { CreateControllerBeans.class };
	}

}
