package com.napier.coursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.awt.image.AreaAveragingScaleFilter;
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
    void testSetCity()
    {
        try{
            ArrayList<City> city = app.getCity(1);
            for(City cty1 : city){
                assertEquals(cty1.getID(),1);
                assertEquals(cty1.getName(),"Kabul");
                assertEquals(cty1.getCountryCode(),"AFG");
                assertEquals(cty1.getDistrict(),"Kabol");
                assertEquals(cty1.getPopulation(),1780000);
            }
            System.out.println("Actual VS Expected Testing Passed!");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
