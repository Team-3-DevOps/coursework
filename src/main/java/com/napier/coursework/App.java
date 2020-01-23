package com.napier.coursework;

// main application for reports

import java.sql.*;
import java.util.ArrayList;


public class App
{      /**
 * Connection to MySQL database.
 */
private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "Team-3-DevOps-CW");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets all the countries in the world by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  " +
                    " FROM country " + "ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Gets all the countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountriesInContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Continent = 'Asia' "
                            + "ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Gets all the countries in a region by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountriesInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Region = 'Southeast Asia' "
                            + "ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Gets all the current cities in the world ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCities()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM `city` ORDER BY `Population` DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the current cities in the continent ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Continent='Asia' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();

            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);


            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    /**
     * Gets all the current cities in the region ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Region='Caribbean' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {

                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    /**
     * Gets all the current cities in the country ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Name='Myanmar' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {

                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInDistrict()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city WHERE city.District = 'Kabol' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */

    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println("Here is a report of countries by descending their populations");
        //System.out.println(String.format("%-10s %-60s %-20s %-30s %-15s %-10s", "Code", "Country", "Continent", "Region", "Population", "Capitals"));
        // Loop over all countries in the list
        for (Country ctry : countries)
        {
            //String ctry_string =
                  //  String.format("%-10s %-60s %-20s %-30s %-15s %-10s" , ctry.code, ctry.name, ctry.continent, ctry.region, ctry.population, ctry.capital);
            System.out.println(ctry);
        }
    }
    /**
     * Prints a list of cities.
     * @param city The list of cities to print.
     */
    public void printCityInfo(ArrayList<City> city)
    {
        // Print header
        System.out.println("Here is a report of cities by descending their populations");
        //System.out.println(String.format("%-20s %-50s %-20s %-50s %-50s", "City ID", "Name", "Country Code", "District", "Population"));
        // Loop over all employees in the list
        for (City cty : city)
        {
//            String cty_stringta =
//                    String.format("%-20s %-50s %-20s %-50s %-50s",
//                            cty.ID, cty.Name, cty.CountryCode, cty.District, cty.Population);
            System.out.println(cty);
        }
    }
    /**
     * Gets all the current cities in the world ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapitalCities()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM `city` INNER JOIN country ON country.Capital=city.ID ORDER BY `Population` DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("city.Country"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the current cities in the continent ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapCitiesInContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON country.Capital=city.ID = country.Code WHERE country.Continent='Asia' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("city.Country"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    /**
     * Gets all the current cities in the region ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapCitiesInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.Name, country.Name, city.Population  FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Region='Caribbean' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("city.Country"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Prints a list of cities.
     * @param city The list of cities to print.
     */
    public void printCapitalCityInfo(ArrayList<CapitalCity> Capcity)
    {
        // Print header
        System.out.println("Here is a report of cities by descending their populations");
        //System.out.println(String.format("%-20s %-50s %-20s %-50s %-50s", "City ID", "Name", "Country Code", "District", "Population"));
        // Loop over all employees in the list
        for (CapitalCity capcty : Capcity)
        {
//            String cty_stringta =
//                    String.format("%-20s %-50s %-20s %-50s %-50s",
//                            cty.ID, cty.Name, cty.CountryCode, cty.District, cty.Population);
            System.out.println(capcty);
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract country population information
        // Extract countries in the world by descending population
        // ArrayList<Country> countries = a.getAllCountries();

        // Extract countries in the continent by descending population
        // ArrayList<Country> countries = a.getAllCountriesInContinent();

        // Extract countries in the region by descending population
        // ArrayList<Country> countries = a.getAllCountriesInRegion();

        // Print format function for countries
        // a.printCountries(countries);

        // Test the size of the returned data - should be
        // System.out.println(countries.size());

        // Extract cities in the world by descending population
        // ArrayList<City> city = a.getAllCities();

        // Extract cities in continent by descending population
        // ArrayList<City> city = a.getAllCitiesInContinent();

        // Extract cities in region by descending population
        // ArrayList<City> city = a.getAllCitiesInRegion();

        // Extract cities in country by descending population
        // ArrayList<City> city = a.getAllCitiesInCountry();

        // Extract cities in district by descending population
        // ArrayList<City> city = a.getAllCitiesInDistrict();

        // Print format function for cities
        // a.printCityInfo(city);

        // Test the size of the returned data - should be
        // System.out.println(city.size());



        // Disconnect from database
        a.disconnect();
    }
}