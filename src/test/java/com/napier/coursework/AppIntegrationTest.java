package com.napier.coursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * AppIntegrationTest Class for Integration Testing
 */
public class AppIntegrationTest {
    /**
     * Define static App
     */
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }


@Test
void testSetCity()
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
    assertEquals(cty.getID(),1);
    assertEquals(cty.getName(),"Kabul");
    assertEquals(cty.getCountryCode(),"AFG");
    assertEquals(cty.getDistrict(),"Kabol");
    assertEquals(cty.getPopulation(),1780000);
}


}
