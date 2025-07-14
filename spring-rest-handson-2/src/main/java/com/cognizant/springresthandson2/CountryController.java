package com.cognizant.springresthandson2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CountryController {
    private ApplicationContext context;

	@RequestMapping("/country")
    public Country getCountryIndia() {
        context = new ClassPathXmlApplicationContext("country.xml");
        return context.getBean("in", Country.class);
    }
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
	    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	    return context.getBean("countryList", List.class);
	}
	@Autowired
	private CountryService countryService;

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
	    return countryService.getCountry(code);
	}



}
