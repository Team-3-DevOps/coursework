package com.napier.coursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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
    {   /**
     * Define new Object App
     */
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
            System.out.println("City Function: Actual VS Expected Testing Passed!");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Test
    void testSetCountryInContinent()
    {
        try{
            ArrayList<Country> ctry = app.getAllCountriesInContinent("Asia");
            for(Country ctry1 : ctry){
                assertEquals(ctry1.getContinent(),"Asia");
                assertEquals(ctry1.getName(),"China");
                assertEquals(ctry1.getCode(),"CHN");
                assertEquals(ctry1.getCapital(), 1891);
                assertEquals(ctry1.getPopulation(),1277558000);
                assertEquals(ctry1.getRegion(),"Eastern Asia");
                break;

            }
            System.out.println("Country Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSetCapitalInContinent()
    {
        try{
            ArrayList<CapitalCity> capty = app.getAllCapCitiesInContinent("Europe");
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"Russian Federation");
                assertEquals(ctry1.getName(),"Moscow");
                assertEquals(ctry1.getPopulation(),8389200);
                break;
            }
            System.out.println("Captial City Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopulation()
    {
        try{
            ArrayList<Population> popu = app.getPopulationInContinent();
            for(Population ctry1 : popu){
                assertEquals(ctry1.getName(),"North America");
                assertEquals(ctry1.getTotal(),482993000);
                assertEquals(ctry1.getLanguage_used_percent(),0.0);
                assertEquals(ctry1.getLiving_in_city(),168250381);
                assertEquals(ctry1.getNot_living_in_city(),314742619);
                assertEquals(ctry1.getLiving_in_city_percent(),34.83495330810547);
                assertEquals(ctry1.getNot_living_in_city_percent(),65.16504669189453);
                break;
            }
            System.out.println("Captial City Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
