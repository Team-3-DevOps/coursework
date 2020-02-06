package com.napier.coursework;

import org.apache.catalina.webresources.AbstractSingleArchiveResource;
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

    /** Example testing function */
    @Test
    void assertExampleTest()
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
            System.out.print("Example Function: Actual VS Expected Testing Passed!");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    /** Actual testing functions */
    @Test
    void testSetCountry()
    {
        try{
            ArrayList<Country> ctry = app.getAllCountries();
            for(Country ctry1 : ctry){
                assertEquals(ctry1.getContinent(),"Asia");
                assertEquals(ctry1.getName(),"China");
                assertEquals(ctry1.getCode(),"CHN");
                assertEquals(ctry1.getCapital(), 1891);
                assertEquals(ctry1.getPopulation(),1277558000);
                assertEquals(ctry1.getRegion(),"Eastern Asia");
                break;

            }
            System.out.print("Country Function: Actual VS Expected Testing Passed!");
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
            System.out.print("Country In Continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSetCountryInRegion()
    {
        try{
            ArrayList<Country> ctry = app.getAllCountriesInRegion("Eastern Asia");
            for(Country ctry1 : ctry){
                assertEquals(ctry1.getContinent(),"Asia");
                assertEquals(ctry1.getName(),"China");
                assertEquals(ctry1.getCode(),"CHN");
                assertEquals(ctry1.getCapital(), 1891);
                assertEquals(ctry1.getPopulation(),1277558000);
                assertEquals(ctry1.getRegion(),"Eastern Asia");
                break;

            }
            System.out.print("Country In Region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCountry()
    {
        try{
            ArrayList<Country> ctry = app.getTopPopCountriesInWorld(1);
            for(Country ctry1 : ctry){
                assertEquals(ctry1.getContinent(),"Asia");
                assertEquals(ctry1.getName(),"China");
                assertEquals(ctry1.getCode(),"CHN");
                assertEquals(ctry1.getCapital(), 1891);
                assertEquals(ctry1.getPopulation(),1277558000);
                assertEquals(ctry1.getRegion(),"Eastern Asia");

            }
            System.out.print("Top numbered Country Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCountryInContinent()
    {
        try{
            ArrayList<Country> ctry = app.getTopPopCountriesInContinent("Asia", 3);
            for(Country ctry1 : ctry){
                assertEquals(ctry1.getContinent(),"Asia");
                assertEquals(ctry1.getName(),"China");
                assertEquals(ctry1.getCode(),"CHN");
                assertEquals(ctry1.getCapital(), 1891);
                assertEquals(ctry1.getPopulation(),1277558000);
                assertEquals(ctry1.getRegion(),"Eastern Asia");
                break;

            }
            System.out.print("Top numbered Country in Continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCountryInRegion()
    {
        try{
            ArrayList<Country> ctry = app.getTopPopCountriesInContinent("Eastern Asia", 3);
            for(Country ctry1 : ctry){
                assertEquals(ctry1.getContinent(),"Asia");
                assertEquals(ctry1.getName(),"China");
                assertEquals(ctry1.getCode(),"CHN");
                assertEquals(ctry1.getCapital(), 1891);
                assertEquals(ctry1.getPopulation(),1277558000);
                assertEquals(ctry1.getRegion(),"Eastern Asia");
                break;
            }
            System.out.print("Top numbered Country in Region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCity()
    {
        try{
            ArrayList<City> city = app.getAllCities();
            for(City cty1 : city){
                assertEquals(cty1.getID(),1024);
                assertEquals(cty1.getName(),"Mumbai (Bombay)");
                assertEquals(cty1.getCountryCode(),"IND");
                assertEquals(cty1.getDistrict(),"Maharashtra");
                assertEquals(cty1.getPopulation(),10500000);
                break;
            }
            System.out.print("City Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCityInContinent()
    {
        try{
            ArrayList<City> city = app.getAllCitiesInContinent("Europe");
            for(City cty1 : city){
                assertEquals(cty1.getID(),3580);
                assertEquals(cty1.getName(),"Moscow");
                assertEquals(cty1.getCountryCode(),"RUS");
                assertEquals(cty1.getDistrict(),"Moscow (City)");
                assertEquals(cty1.getPopulation(),8389200);
                break;
            }
            System.out.print("City in Continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCityInRegion()
    {
        try{
            ArrayList<City> city = app.getAllCitiesInRegion("Eastern Asia");
            for(City cty1 : city){
                assertEquals(cty1.getID(),2331);
                assertEquals(cty1.getName(),"Seoul");
                assertEquals(cty1.getCountryCode(),"KOR");
                assertEquals(cty1.getDistrict(),"Seoul");
                assertEquals(cty1.getPopulation(),9981619);
                break;
            }
            System.out.print("City in Region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCityInDistrict()
    {
        try{
            ArrayList<City> city = app.getAllCitiesInDistrict("Hunan");
            for(City cty1 : city){
                assertEquals(cty1.getID(),1910);
                assertEquals(cty1.getName(),"Changsha");
                assertEquals(cty1.getCountryCode(),"CHN");
                assertEquals(cty1.getDistrict(),"Hunan");
                assertEquals(cty1.getPopulation(),1809800);
                break;
            }
            System.out.print("City in District Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCity()
    {
        try{
            ArrayList<City> city = app.getAllTopCities(3);
            for(City cty1 : city){
                assertEquals(cty1.getID(),1024);
                assertEquals(cty1.getName(),"Mumbai (Bombay)");
                assertEquals(cty1.getCountryCode(),"IND");
                assertEquals(cty1.getDistrict(),"Maharashtra");
                assertEquals(cty1.getPopulation(),10500000);
                break;
            }
            System.out.print("Top numbered City Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCityInContinent()
    {
        try{
            ArrayList<City> city = app.getAllTopCitiesInContinent("Europe", 3);
            for(City cty1 : city){
                assertEquals(cty1.getID(),3580);
                assertEquals(cty1.getName(),"Moscow");
                assertEquals(cty1.getCountryCode(),"RUS");
                assertEquals(cty1.getDistrict(),"Moscow (City)");
                assertEquals(cty1.getPopulation(),8389200);
                break;
            }
            System.out.print("Top numbered City in Continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCityInRegion()
    {
        try{
            ArrayList<City> city = app.getAllTopCitiesInRegion("Eastern Asia", 3);
            for(City cty1 : city){
                assertEquals(cty1.getID(),2331);
                assertEquals(cty1.getName(),"Seoul");
                assertEquals(cty1.getCountryCode(),"KOR");
                assertEquals(cty1.getDistrict(),"Seoul");
                assertEquals(cty1.getPopulation(),9981619);
                break;
            }
            System.out.print("Top numbered City in Region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testTopCityInCountry()
    {
        try{
            ArrayList<City> city = app.getAllTopCitiesInCountry("Myanmar", 3);
            for(City cty1 : city){
                assertEquals(cty1.getID(),2710);
                assertEquals(cty1.getName(),"Rangoon (Yangon)");
                assertEquals(cty1.getCountryCode(),"MMR");
                assertEquals(cty1.getDistrict(),"Rangoon [Yangon]");
                assertEquals(cty1.getPopulation(),3361700);
                break;
            }
            System.out.print("Top numbered City in Country Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testTopCityInDistrict()
    {
        try{
            ArrayList<City> city = app.getAllTopCitiesInDistrict("Hunan", 3);
            for(City cty1 : city){
                assertEquals(cty1.getID(),1910);
                assertEquals(cty1.getName(),"Changsha");
                assertEquals(cty1.getCountryCode(),"CHN");
                assertEquals(cty1.getDistrict(),"Hunan");
                assertEquals(cty1.getPopulation(),1809800);
                break;
            }
            System.out.print("Top numbered City in District Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testCapital()
    {
        try{
            ArrayList<CapitalCity> capty = app.getAllCapitalCities();
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"South Korea");
                assertEquals(ctry1.getName(),"Seoul");
                assertEquals(ctry1.getPopulation(),9981619);
                break;
            }
            System.out.print("Captial City Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCapitalInContinent()
    {
        try{
            ArrayList<CapitalCity> capty = app.getAllCapCitiesInContinent("Europe");
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"Russian Federation");
                assertEquals(ctry1.getName(),"Moscow");
                assertEquals(ctry1.getPopulation(),8389200);
                break;
            }
            System.out.print("Captial City in Continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCapitalInRegion()
    {
        try{
            ArrayList<CapitalCity> capty = app.getAllCapCitiesInRegion("Southeast Asia");
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"Indonesia");
                assertEquals(ctry1.getName(),"Jakarta");
                assertEquals(ctry1.getPopulation(),9604900);
                break;
            }
            System.out.print("Captial City in Region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCapital()
    {
        try{
            ArrayList<CapitalCity> capty = app.getTopPopCapitalCities(5);
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"South Korea");
                assertEquals(ctry1.getName(),"Seoul");
                assertEquals(ctry1.getPopulation(),9981619);
                break;
            }
            System.out.print("Top Captial City in world Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCapitalInContinent()
    {
        try{
            ArrayList<CapitalCity> capty = app.getTopPopCapCitiesInContinent("Asia", 3);
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"South Korea");
                assertEquals(ctry1.getName(),"Seoul");
                assertEquals(ctry1.getPopulation(),9981619);
                break;
            }
            System.out.print("Top Captial City in continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTopCapitalInRegion()
    {
        try{
            ArrayList<CapitalCity> capty = app.getTopPopCapCitiesInRegion("Southeast Asia", 3);
            for(CapitalCity ctry1 : capty){
                assertEquals(ctry1.getCountry(),"Indonesia");
                assertEquals(ctry1.getName(),"Jakarta");
                assertEquals(ctry1.getPopulation(),9604900);
                break;
            }
            System.out.print("Top Captial City in region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testGetPopulationInContinent()
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
            System.out.print("Get population in continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetPopulationInRegion()
    {
        try{
            ArrayList<Population> popu = app.getPopulationInRegion();
            for(Population ctry1 : popu){
                assertEquals(ctry1.getName(),"Caribbean");
                assertEquals(ctry1.getTotal(),38140000);
                assertEquals(ctry1.getLanguage_used_percent(),0.0);
                assertEquals(ctry1.getLiving_in_city(),11067550);
                assertEquals(ctry1.getNot_living_in_city(),27072450);
                assertEquals(ctry1.getLiving_in_city_percent(),29.018220901489258);
                assertEquals(ctry1.getNot_living_in_city_percent(),70.98178100585938);
                break;
            }
            System.out.print("Get population in region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetPopulationInCountry()
    {
        try{
            ArrayList<Population> popu = app.getPopulationInCountry();
            for(Population ctry1 : popu){
                assertEquals(ctry1.getName(),"Aruba");
                assertEquals(ctry1.getTotal(),103000);
                assertEquals(ctry1.getLanguage_used_percent(),0.0);
                assertEquals(ctry1.getLiving_in_city(),29034);
                assertEquals(ctry1.getNot_living_in_city(),73966);
                assertEquals(ctry1.getLiving_in_city_percent(),28.1883487701416);
                assertEquals(ctry1.getNot_living_in_city_percent(),71.81165313720703);
                break;
            }
            System.out.print("Get population in country Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testPopulation()
    {
        try{
            ArrayList<Population> popu = app.TotalPopuationInWorld();
            for(Population ctry1 : popu){
                assertEquals(ctry1.getTotal(),6078749450L);
                assertEquals(ctry1.getName(),"World");
                break;
            }
            System.out.print("Total population Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopulationInContinent()
    {
        try{
            ArrayList<Population> popu = app.TotalPopuationInaContinent("Asia");
            for(Population ctry1 : popu){
                assertEquals(ctry1.getTotal(),3705025700L);
                assertEquals(ctry1.getName(),"Asia");
                break;
            }
            System.out.print("Total population in a continent Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopulationInRegion()
    {
        try{
            ArrayList<Population> popu = app.TotalPopuationInaRegion("Southeast Asia");
            for(Population ctry1 : popu){
                assertEquals(ctry1.getTotal(),518541000L);
                assertEquals(ctry1.getName(),"Southeast Asia");
                break;
            }
            System.out.print("Total population in a region Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopulationInCountry()
    {
        try{
            ArrayList<Population> popu = app.TotalPopuationInaCountry("Myanmar");
            for(Population ctry1 : popu){
                assertEquals(ctry1.getTotal(),45611000);
                assertEquals(ctry1.getName(),"Myanmar");
                break;
            }
            System.out.print("Total population in a country Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopulationInDistrict()
    {
        try{
            ArrayList<Population> popu = app.TotalPopuationInaDistrict("Hunan");
            for(Population ctry1 : popu){
                assertEquals(ctry1.getTotal(),5439275);
                assertEquals(ctry1.getName(),"Hunan");
                break;
            }
            System.out.print("Total population in a district Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopulationInCity()
    {
        try{
            ArrayList<Population> popu = app.TotalPopuationInaCity("Mandalay");
            for(Population ctry1 : popu){
                assertEquals(ctry1.getTotal(),885300);
                assertEquals(ctry1.getName(),"Mandalay");
                break;
            }
            System.out.print("Total population in a city Function: Actual VS Expected Testing Passed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
