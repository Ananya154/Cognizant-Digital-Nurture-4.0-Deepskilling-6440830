package com.cognizant.springresthandson2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {
	    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	    List<Country> countries = context.getBean("countryList", List.class);

	    return countries.stream()
	            .filter(c -> c.getCode().equalsIgnoreCase(code))
	            .findFirst()
	            .orElseThrow(() -> new CountryNotFoundException("Country not found"));
	}

}
