package com.cognizant.springrestallexercises;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CountryController {

    private final List<Country> countryList = new ArrayList<>();
    public CountryController() {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("DE", "Germany"));
        countryList.add(new Country("JP", "Japan"));
    }

    @GetMapping("/country")
    public Country getCountry() {
        return new Country("IN", "India");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryList;
    }

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        for (Country c : countryList) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping("/country")
    public Country addCountry(@RequestBody Country country) {
        countryList.add(country);
        return country;
    }
}
