package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Country;

@Service
public class CountryService {

    public List<Country> getCountries() {
        return Arrays.asList(
                new Country("IN", "India"),
                new Country("US", "United States"));
    }
}
