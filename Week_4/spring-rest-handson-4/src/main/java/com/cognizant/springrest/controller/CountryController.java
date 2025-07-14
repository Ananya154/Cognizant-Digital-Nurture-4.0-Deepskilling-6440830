package com.cognizant.springrest.controller;

import com.cognizant.springrest.model.Country;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private static Map<String, Country> countryMap = new HashMap<>();
    @GetMapping
    public List<Country> getAllCountries() {
        return new ArrayList<>(countryMap.values());
    }
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryMap.get(code.toUpperCase());
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start addCountry");
        countryMap.put(country.getCode().toUpperCase(), country);
        return country;
    }

    @PutMapping
    public Country updateCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start updateCountry");
        countryMap.put(country.getCode().toUpperCase(), country);
        return country;
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        LOGGER.info("Start deleteCountry");
        countryMap.remove(code.toUpperCase());
    }
}
