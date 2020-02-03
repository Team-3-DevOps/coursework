package com.napier.coursework;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


/**
 * AppTest Class for Unit Testing
 */
public class AppTest {
    /**
     * Define static App
     */
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
    void printPopulationInfoNull()
    {
        app.printPopulationInfo(null);
    }

    @Test
    void printPopulationTotalNull()
    {
        app.printPopulationTotal(null);
    }

    @Test
    void printLanguageListNull()
    {
        app.printLanguageList(null);
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
    void printPopulationInfoEmpty()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        app.printPopulationInfo(populations);
    }

    @Test
    void printPopulationTotalEmpty()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        app.printPopulationTotal(populations);
    }

    @Test
    void printLanguageListEmpty()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        app.printLanguageList(populations);
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
    void printPopulationInfoContainsNull()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        populations.add(null);
        app.printPopulationInfo(populations);
    }

    @Test
    void printPopulationTotalContainsNull()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        populations.add(null);
        app.printPopulationTotal(populations);
    }

    @Test
    void printLanguageListContainsNull()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        populations.add(null);
        app.printLanguageList(populations);
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

    @Test
    void printPopulationInfo()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population popul = new Population();
        popul.setName("North America");
        popul.setTotal(482993000);
        popul.setLiving_in_city(168250381);
        popul.setLiving_in_city_percent(34);
        popul.setNot_living_in_city(314742619);
        popul.setNot_living_in_city_percent(65);
        populations.add(popul);
        app.printPopulationInfo(populations);
    }

    @Test
    void printPopulationTotal()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population popul = new Population();
        popul.setName("Oceania");
        popul.setTotal(30401150);
        populations.add(popul);
        app.printPopulationTotal(populations);
    }

    @Test
    void printLanguageList()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population popul = new Population();
        popul.setName("Chinese");
        popul.setTotal(1191843539);
        popul.setLanguage_used_percent(19);
        populations.add(popul);
        app.printLanguageList(populations);
    }
}
