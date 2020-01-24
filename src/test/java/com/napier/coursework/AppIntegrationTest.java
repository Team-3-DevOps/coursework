package com.napier.coursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCountry()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country crty = new Country();
        assertEquals(crty.getCode(),"MMR");
        assertEquals(crty.getName(),"Myanmar");
        assertEquals(crty.getContinent(),"Asia");
        assertEquals(crty.getRegion(),"Southeast Asia");
        assertEquals(crty.getPopulation(),45611000);
        assertEquals(crty.getCapital(),2710);
        countries.add(crty);
        app.printCountries(countries);
    }
    @Test
    void testGetCity()
    {
        ArrayList<City> city = new ArrayList<City>();
        City cty = new City();
        assertEquals(cty.getID(),1);
        assertEquals(cty.getName(),"Kabul");
        assertEquals(cty.getCountryCode(),"AFG");
        assertEquals(cty.getDistrict(),"Kabol");
        assertEquals(cty.getPopulation(),1780000);
        city.add(cty);
        app.printCityInfo(city);
    }

    @Test
    void testGetCapitalCity()
    {
        ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
        CapitalCity capcty = new CapitalCity();
        assertEquals(capcty.getName(),"Kabul");
        assertEquals(capcty.getCountry(),"Afghanistan");
        assertEquals(capcty.getPopulation(),1780000);
        Capcity.add(capcty);
        app.printCapitalCityInfo(Capcity);
    }
}
