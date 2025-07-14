package com.cognizant.springlearn.controller;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Map<String, String>> getCountries() {
        List<Map<String, String>> countries = new ArrayList<>();

        countries.add(createCountry("US", "United States"));
        countries.add(createCountry("DE", "Germany"));
        countries.add(createCountry("IN", "India"));
        countries.add(createCountry("JP", "Japan"));

        return countries;
    }

    private Map<String, String> createCountry(String code, String name) {
        Map<String, String> country = new HashMap<>();
        country.put("code", code);
        country.put("name", name);
        return country;
    }
}
