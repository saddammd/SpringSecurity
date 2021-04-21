package com.spring.demo.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInititializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class arr[] = {SpringDemoConfig.class, SpringSecurityConfig.class};
		
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		
		String mapping[] = {"/"};
		
		return mapping;
	}

}
