package com.napier.coursework;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCountriesNull()
    {
        app.printCountries(null);
    }

    @Test
    void printCityInfoNull()
    {
        app.printCityInfo(null);
    }

    @Test
    void printCapitalCityInfoNull()
    {
        app.printCapitalCityInfo(null);
    }

    @Test
    void printCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    @Test
    void printCityInfoEmpty()
    {
        ArrayList<City> city = new ArrayList<City>();
        app.printCityInfo(city);
    }

    @Test
    void printCapitalCityInfoEmpty()
    {
        ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
        app.printCapitalCityInfo(Capcity);
    }

    @Test
    void printCountriesContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCityInfoContainsNull()
    {
        ArrayList<City> city = new ArrayList<City>();
        city.add(null);
        app.printCityInfo(city);
    }
    @Test
    void printCapitalCityInfoContainsNull()
    {
        ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
        Capcity.add(null);
        app.printCapitalCityInfo(Capcity);
    }

    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country crty = new Country();
        crty.setCode("MMR");
        crty.setName("Myanmar");
        crty.setContinent("Asia");
        crty.setRegion("Southeast Asia");
        crty.setPopulation(45611000);
        crty.setCapital(2710);
        countries.add(crty);
        app.printCountries(countries);
    }
    @Test
    void printCities()
    {
        ArrayList<City> city = new ArrayList<City>();
        City cty = new City();
        cty.setID(1);
        cty.setName("Kabul");
        cty.setCountryCode("AFG");
        cty.setDistrict("Kabol");
        cty.setPopulation(1780000);
        city.add(cty);
        app.printCityInfo(city);
    }

    @Test
    void printCapitalCities()
    {
        ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
        CapitalCity capcty = new CapitalCity();
        capcty.setName("Kabul");
        capcty.setCountry("Afghanistan");
        capcty.setPopulation(1780000);
        Capcity.add(capcty);
        app.printCapitalCityInfo(Capcity);
    }
}
