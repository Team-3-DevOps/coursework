package com.napier.coursework;

// main application for world population reports

import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{      /**
 * Connection to MySQL database.
 */
private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
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
            System.out.println("* Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "Team-3-DevOps-CW");
                System.out.println("* Successfully connected");
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
                System.out.println("* Sucessfully disconnected");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public Integer getINTInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int i = Integer.parseInt(s);
            return i;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get input");
            return null;
        }
    }

    public String getSTRInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            return s;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get inputs");
            return null;
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
    public ArrayList<Country> getAllCountriesInContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital FROM country WHERE country.Continent='"+str+"' ORDER BY country.Population DESC";
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
    public ArrayList<Country> getAllCountriesInRegion(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  FROM country WHERE country.Region='"+str+"' ORDER BY country.Population DESC";
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
     * Gets top N populated countries in the world by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getTopPopCountriesInWorld(Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  FROM country ORDER BY country.Population DESC LIMIT " + num;
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
                            + "ORDER BY country.Population DESC ";

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
     * Gets top N populated countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getTopPopCountriesInContinent(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Continent ='"+str+"' ORDER BY country.Population DESC LIMIT " + num;

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
     * Gets top N populated countries in a region by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getTopPopCountriesInRegion(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Region = '"+str+"' ORDER BY country.Population DESC LIMIT "+ num;

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
    public ArrayList<City> getAllCitiesInContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Continent='"+str+"' ORDER BY Population DESC";
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
    public ArrayList<City> getAllCitiesInRegion(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Region='"+str+"' ORDER BY Population DESC";
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
    public ArrayList<City> getAllCitiesInCountry(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Name='"+str+"' ORDER BY Population DESC";
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
    public ArrayList<City> getAllCitiesInDistrict(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE city.District='"+str+"' ORDER BY Population DESC";
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
    public ArrayList<City> getAllTopCities(Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city ORDER BY Population DESC LIMIT " + num;
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
    public ArrayList<City> getAllTopCitiesInContinent(String str,Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Continent='"+str+"' ORDER BY Population DESC LIMIT " + num;
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
    public ArrayList<City> getAllTopCitiesInRegion(String str, Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Region='"+str+"' ORDER BY Population DESC LIMIT " + num;
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
    public ArrayList<City> getAllTopCitiesInCountry(String str,Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Name='"+str+"' ORDER BY Population DESC LIMIT " + num;
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
    public ArrayList<City> getAllTopCitiesInDistrict(String str, Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE city.District='"+str+"' ORDER BY Population DESC LIMIT " + num;
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
     * Gets all the capital cities in the world ordering by population
     * @return A list of all capital city names, country name and city population, or null if there is an error.
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
                capcty.setCountry(rset.getString("country.Name"));
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
     * Gets all the capital cities in the world ordering by population
     * @return A list of all capital city names, country name and city  population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getTopPopCapitalCities(Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM `city` INNER JOIN country ON country.Capital=city.ID ORDER BY `Population` DESC LIMIT "+ num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
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
     * Gets all the current capital cities in the continent ordering by population
     * @return A list of all capital city names, country name and city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapCitiesInContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Continent='"+str+"' ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
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
     * Gets all the current capital cities in the continent ordering by population
     * @return A list of all capital city names, country name and city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getTopPopCapCitiesInContinent(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Continent='"+str+"' ORDER BY city.Population DESC LIMIT "+ num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
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
     * Gets all the current capital cities in the region ordering by population
     * @return A list of all capital city names, country name, city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapCitiesInRegion(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.Name, country.Name, city.Population  FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Region='"+str+"' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
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
     * Gets all the current capital cities in the region ordering by population
     * @return A list of all city names, country name, city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getTopPopCapCitiesInRegion(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.Name, country.Name, city.Population  FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Region='"+str+"' ORDER BY Population DESC LIMIT "+ num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
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
     * Prints a list of capital cities.
     * @param Capcity The list of capital cities to print.
     */
    public void printCapitalCityInfo(ArrayList<CapitalCity> Capcity)
    {
        // Check capital cities is not null
        if (Capcity == null)
        {
            System.out.println("No capital cities");
            return;
        }
        // Print header
        System.out.println("Here is a report of capital cities by descending their populations");
        System.out.println(String.format("%-50s %-50s %-50s", "City Name", "Country Name", "Population"));
        // Loop over all capital cities in the list
        for (CapitalCity capcty : Capcity)
        {
            if (capcty == null)
                continue;
            String capty_string =
                    String.format("%-50s %-50s %-50s",
                            capcty.getName(), capcty.getCountry(), capcty.getPopulation());
            System.out.println(capty_string);
        }
        System.out.println("number of capital cities - " + Capcity.size());
    }

    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<Country> countries)
    {
        // Check countries is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.println("Here is a report of countries by descending their populations");
        System.out.println(String.format("%-10s %-60s %-20s %-30s %-15s %-10s", "Code", "Country", "Continent", "Region", "Population", "Capitals"));
        // Loop over all countries in the list
        for (Country ctry : countries)
        {
            if (ctry == null)
                continue;
            String ctry_string =
            String.format("%-10s %-60s %-20s %-30s %-15s %-10s" , ctry.getCode(), ctry.getName(), ctry.getContinent(), ctry.getRegion(), ctry.getPopulation(), ctry.getCapital());
            System.out.println(ctry_string);
        }
        System.out.println("number of countries - " + countries.size());
    }
    /**
     * Prints a list of cities.
     * @param city The list of cities to print.
     */
    public void printCityInfo(ArrayList<City> city)
    {
        // Check cities is not null
        if (city == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println("Here is a report of cities by descending their populations");
        System.out.println(String.format("%-20s %-50s %-20s %-50s %-50s", "City ID", "Name", "Country Code", "District", "Population"));
        // Loop over all cities in the list
        for (City cty : city)
        {
            if (cty == null)
                continue;
            String cty_string =
                    String.format("%-20s %-50s %-20s %-50s %-50s",
                            cty.getID(), cty.getName(), cty.getCountryCode(), cty.getDistrict(), cty.getPopulation());
            System.out.println(cty_string);
        }
        System.out.println("number of cities - " + city.size());
    }

    /**
     * @return The population of people, people living in cities, and people not living in cities in each continent.
     */
    public ArrayList<Population> getPopulationInContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(country.Population) , country.Continent from country GROUP By country. Continent" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                String strSelect1 = "SELECT SUM(city.population)  from city Inner JOIN country ON city.CountryCode= country.Code AND country.Continent = '"+rset.getString(2)+"'";
                // Execute SQL statement
                ResultSet rset1 = stmt1.executeQuery(strSelect1);
                // Extract city information
                while(rset1.next()) {
                    Popu.setLiving_in_city(rset1.getLong(1));
                    //Number of people lving in cities
                    Popu.setNot_living_in_city(rset.getLong(1)-rset1.getLong(1));
                    //Number of people not living in cities
                    if (rset.getLong(1)!=0) {
                        Popu.setLiving_in_city_percent( (rset1.getLong(1)*100f / rset.getLong(1)));
                        //Percentage of people lving in cities
                        Popu.setNot_living_in_city_percent((float)(rset.getLong(1)-rset1.getLong(1))*100/rset.getLong(1));
                        //Percentage of people not living in cities
                    }

                }
//
                population.add(Popu);
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * @return The population of people, people living in cities, and people not living in cities in each region.
     */
    public ArrayList<Population> getPopulationInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(country.Population) , country.Region from country GROUP By country. Region" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                String strSelect1 = "SELECT SUM(city.population)  from city Inner JOIN country ON city.CountryCode= country.Code AND country.Region = '"+rset.getString(2)+"'";
                // Execute SQL statement
                ResultSet rset1 = stmt1.executeQuery(strSelect1);
                // Extract city information
                while(rset1.next()) {
                    Popu.setLiving_in_city(rset1.getLong(1));
                    //Number of people lving in cities
                    Popu.setNot_living_in_city(rset.getLong(1)-rset1.getLong(1));
                    //Number of people not living in cities
                    if (rset.getLong(1)!=0) {
                        Popu.setLiving_in_city_percent( (rset1.getLong(1)*100f / rset.getLong(1)));
                        //Percentage of people lving in cities
                        Popu.setNot_living_in_city_percent((float)(rset.getLong(1)-rset1.getLong(1))*100/rset.getLong(1));
                        //Percentage of people not living in cities
                    }

                }
//
                population.add(Popu);
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * @return The population of people, people living in cities, and people not living in cities in each region.
     */
    public ArrayList<Population> getPopulationInCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(country.Population) , country.Name from country GROUP By country.Name" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                String strSelect1 = "SELECT SUM(city.population)  from city Inner JOIN country ON city.CountryCode= country.Code AND country.Name = '"+rset.getString(2)+"'";
                // Execute SQL statement
                ResultSet rset1 = stmt1.executeQuery(strSelect1);
                // Extract city information
                while(rset1.next()) {
                    Popu.setLiving_in_city(rset1.getLong(1));
                    //Number of people lving in cities
                    Popu.setNot_living_in_city(rset.getLong(1)-rset1.getLong(1));
                    //Number of people not living in cities
                    if (rset.getLong(1)!=0) {
                        Popu.setLiving_in_city_percent( (rset1.getLong(1)*100f / rset.getLong(1)));
                        //Percentage of people lving in cities
                        Popu.setNot_living_in_city_percent((float)(rset.getLong(1)-rset1.getLong(1))*100/rset.getLong(1));
                        //Percentage of people not living in cities
                    }

                }
//
                population.add(Popu);
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of continents with population who live in cities and not.
     * @param population The list of population details to print.
     */
    public void printPopulationInfo(ArrayList<Population> population)
    {
        // Check population is not null
        if (population == null)
        {
            System.out.println("No populations");
            return;
        }
        // Print header
        System.out.println("Here is a report of Population");
        System.out.println(String.format("%-40s %-20s %-20s %-35s %-30s %-32s", "Name", "Total Population", "Population in Cities", "Percentage of Population in Cities","Population not in Cities", "Percentage of Population not in Cities"));
        // Loop over all the answer in the list
        for (Population popul : population)
        {
            if (popul == null)
                continue;
            String popul_string =
                    String.format("%-40s %-20s %-20s %-35s %-30s %-32s",
                            popul.getName(), popul.getTotal(), popul.getLiving_in_city(), popul.getLiving_in_city_percent()+"%",popul.getNot_living_in_city(),popul.getNot_living_in_city_percent()+"%");
            System.out.println(popul_string);
        }
        System.out.println("number of populations - " + population.size());
    }
    public ArrayList<Population> TotalPopuationInWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName("World");
                population.add(Popu);
            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
    public ArrayList<Population> TotalPopuationInaContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population), country.Continent FROM country WHERE country.Continent='"+str+"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                population.add(Popu);
            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
    public ArrayList<Population> TotalPopuationInaRegion(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population), country.Region FROM country WHERE country.Region='"+str+"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                population.add(Popu);
            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<Population> TotalPopuationInaCountry(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Population, country.Name FROM country WHERE country.Name='"+str+"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                population.add(Popu);
            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<Population> TotalPopuationInaDistrict(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) FROM city WHERE city.District='"+str+"'";
            System.out.println(str);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                System.out.println(rset.getLong(1));
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(str);
                population.add(Popu);
            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<Population> TotalPopuationInaCity(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Population, city.Name FROM city WHERE city.name='"+str+"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                Popu.setTotal(rset.getLong(1));
                Popu.setName(rset.getString(2));
                population.add(Popu);
            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public void printPopulationTotal(ArrayList<Population> population)
    {
        // Check population is not null
        if (population == null)
        {
            System.out.println("No populations");
            return;
        }
        // Print header
        System.out.println("Here is a Total population report");
        System.out.println(String.format("%-40s %-20s", "Name", "Total Population"));
        // Loop over all the answer in the list
        for (Population popul : population)
        {
            if (popul == null)
                continue;
            String popul_string =
                    String.format("%-40s %-20s",
                            popul.getName(), popul.getTotal());
            System.out.println(popul_string);
        }
        System.out.println("number of populations - " + population.size());
    }

    /**
     * @return The population of people, people living in cities, and people not living in cities in each region.
     */
    public ArrayList<Population> getLanguageUsageList()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT countrylanguage.Language, SUM(100*(country.Population *( countrylanguage.Percentage /100))/6078749450) from countrylanguage, country WHERE countrylanguage.CountryCode= country.Code GROUP By countrylanguage.Language ORDER By (SUM(100*(country.Population *( countrylanguage.Percentage /100))/6078749450)) DESC LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Population> population = new ArrayList<Population>();
            while (rset.next())
            {
                Population Popu = new Population();
                    Popu.setName(rset.getString(1));
                    Popu.setLanguage_used_percent(rset.getFloat(2));
                    population.add(Popu);

            }

            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public void printLanguageList(ArrayList<Population> population)
    {
        // Check population is not null
        if (population == null)
        {
            System.out.println("No populations");
            return;
        }
        // Print header
        System.out.println("Here is a Total population report");
        System.out.println(String.format("%-40s %-20s", "Name", "Percentage of world that used different language"));
        // Loop over all the answer in the list
        for (Population popul : population)
        {
            if (popul == null)
                continue;
            String popul_string =
                    String.format("%-40s %-20s",
                            popul.getName(), popul.getLanguage_used_percent()+"%");
            System.out.println(popul_string);
        }
        System.out.println("number of populations - " + population.size());
    }

    public static void main(String[] args)
    {
        try {
            // Create new Application
            App a = new App();

            // Connect to database
            if (args.length < 1)
            {
                a.connect("localhost:3306");
            }
            else
            {
                a.connect(args[0]);
            }

            String answer = "";
            do {
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-++-+-+-+-+-+-++-+-+-");
                System.out.println("-+-+-+-+-+-+-+-+-+-+(WORLD POPULATION)+-+-+-+-+-+-+-+-+-+-");
                System.out.println("= Reports are ordered by largest population to smallest =");
                System.out.println("1. COUNTRY REPORTS +-");
                System.out.println("2. CITY REPORTS +-");
                System.out.println("3. CAPITAL CITY REPORTS +-");
                System.out.println("4. Population REPORTS of people living in cities and not living in the cities +-");
                System.out.println("5. Access the population information");
                System.out.println("6. Population of people that used different languages");
                System.out.print("Choose an option: ");
                Integer selector1 = a.getINTInput();
                if(selector1 == 1)
                {
                    try{
                        System.out.println("1. Rank all countries in the world");
                        System.out.println("2. Rank all countries in a continent");
                        System.out.println("3. Rank all countries in a region");
                        System.out.println("4. Rank top <N> countries in the world");
                        System.out.println("5. Rank top <N> countries in a continent");
                        System.out.println("6. Rank top <N> countries in a region");
                        System.out.print("Choose an option: ");
                        Integer selector2 = a.getINTInput();


                        if(selector2 == 1)
                        {
                            // Extract countries in the world by descending population
                            ArrayList<Country> countries = a.getAllCountries();
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 2)
                        {
                            System.out.print("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            // Extract countries in the continent by descending population
                            ArrayList<Country> countries = a.getAllCountriesInContinent(str);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 3)
                        {
                            System.out.print("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllCountriesInRegion(str);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 4)
                        {
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getTopPopCountriesInWorld(num);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 5)
                        {
                            System.out.print("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getTopPopCountriesInContinent(str, num);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else{
                            System.out.print("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getTopPopCountriesInRegion(str, num);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else if (selector1 == 2)
                {
                    try
                    {
                        System.out.println("1. Rank all cities in the world");
                        System.out.println("2. Rank all cities in a continent");
                        System.out.println("3. Rank all cities in a region");
                        System.out.println("4. Rank all cities in a country");
                        System.out.println("5. Rank all cities in a district");
                        System.out.println("6. Rank top <N> countries in the world");
                        System.out.println("7. Rank top <N> countries in a continent");
                        System.out.println("8. Rank top <N> countires in a region");
                        System.out.println("9. Rank top <N> countires in a country");
                        System.out.println("10. Rank top <N> countires in a district");
                        System.out.print("Choose an option: ");
                        Integer selector2 = a.getINTInput();
                        if (selector2 == 1)
                        {
                            // Extract cities in the world by descending population
                            ArrayList<City> city = a.getAllCities();
                            // Print format function for cities
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 2)
                        {
                            System.out.print("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInContinent(str);
                            // Print format function for cities
                            a.printCityInfo(city);

                        }
                        else if (selector2 == 3)
                        {
                            System.out.print("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInRegion(str);
                            // Print format function for cities
                            a.printCityInfo(city);

                        }
                        else if (selector2 == 4)
                        {
                            System.out.print("= ENTER a country name - ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInCountry(str);
                            // Print format function for cities
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 5)
                        {
                            System.out.print("= ENTER a district name - ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInDistrict(str);
                            // Print format function for cities
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 6)
                        {
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<City> city = a.getAllTopCities(num);
                            // Print format function for countries
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 7)
                        {
                            System.out.print("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<City> city = a.getAllTopCitiesInContinent(str, num);
                            // Print format function for countries
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 8)
                        {
                            System.out.print("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<City> city = a.getAllTopCitiesInRegion(str, num);
                            // Print format function for countries
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 9)
                        {
                            System.out.print("= ENTER a country name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<City> city = a.getAllTopCitiesInCountry(str, num);
                            // Print format function for countries
                            a.printCityInfo(city);
                        }
                        else
                        {
                            System.out.print("= ENTER a district name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<City> city = a.getAllTopCitiesInDistrict(str, num);
                            // Print format function for countries
                            a.printCityInfo(city);
                        }


                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else if (selector1 == 3)
                {
                    try{
                        System.out.println("1. Rank all capital cities in the world");
                        System.out.println("2. Rank all capital cities in a continent");
                        System.out.println("3. Rank all capital cities in a region");
                        System.out.println("4. Rank top <N> capital cities in the world");
                        System.out.println("5. Rank top <N> capital cities in a continent");
                        System.out.println("6. Rank top <N> capital cities in a region");
                        System.out.print("Choose an option: ");
                        Integer selector2 = a.getINTInput();
                        if(selector2 == 1)
                        {
                            // Extract captial cities in the world by descending population
                            ArrayList<CapitalCity> Capcity = a.getAllCapitalCities();
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                        else if(selector2 == 2)
                        {
                            System.out.print("= ENTER a continent name -  ");
                            String str = a.getSTRInput();
                            // Extract capital cities in the continent by descending population
                            ArrayList<CapitalCity> Capcity = a.getAllCapCitiesInContinent(str);
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                        else if(selector2 == 3)
                        {
                            System.out.print("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            // Extract capital citeis in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getAllCapCitiesInRegion(str);
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                        else if(selector2 == 4)
                        {
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract capital cities in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getTopPopCapitalCities(num);
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                        else if(selector2 == 5)
                        {
                            System.out.print("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract capital cities in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getTopPopCapCitiesInContinent(str, num);
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                        else{
                            System.out.print("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            System.out.print("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract capital cities in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getTopPopCapCitiesInRegion(str, num);
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else if (selector1 == 4)
                {
                    try{
                        System.out.println("1. The population of people, people living in cities, and people not living in cities in each continent.");
                        System.out.println("2. The population of people, people living in cities, and people not living in cities in each region.");
                        System.out.println("3. The population of people, people living in cities, and people not living in cities in each country");
                        System.out.print("Choose an option: ");
                        Integer selector2 = a.getINTInput();
                        if(selector2 == 1)
                        {
                            // Extract population of living in cities and not
                            ArrayList<Population> population = a.getPopulationInContinent();
                            // Print format function for population living and not living in cities
                            a.printPopulationInfo(population);
                        }
                        else if(selector2 == 2)
                        {
                            // Extract population of living in cities and not
                            ArrayList<Population> population = a.getPopulationInRegion();
                            // Print format function for population living and not living in cities
                            a.printPopulationInfo(population);
                        }
                        else if(selector2 == 3)
                        {
                            // Extract population of living in cities and not
                            ArrayList<Population> population = a.getPopulationInCountry();
                            // Print format function for population living and not living in cities
                            a.printPopulationInfo(population);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else if (selector1 == 5)
                {
                    try{
                        System.out.println("1. The population of the world");
                        System.out.println("2. The population of a continent");
                        System.out.println("3. The population of a region");
                        System.out.println("4. The population of a country");
                        System.out.println("5. The population of a district");
                        System.out.println("6. The population of a city");
                        System.out.print("Choose an option: ");
                        Integer selector2 = a.getINTInput();
                        if(selector2 == 1)
                        {
                            // Extract Total population of the world
                            ArrayList<Population> population = a.TotalPopuationInWorld();
                            // Print format function for population living and not living in cities
                            a.printPopulationTotal(population);
                        }
                        if(selector2 == 2)
                        {
                            System.out.print("= ENTER a continent name -  ");
                            String str = a.getSTRInput();
                            // Extract Total population of a continent
                            ArrayList<Population> population = a.TotalPopuationInaContinent(str);
                            // Print format function for population living and not living in cities
                            a.printPopulationTotal(population);
                        }
                        if(selector2 == 3)
                        {
                            System.out.print("= ENTER a region name -  ");
                            String str = a.getSTRInput();
                            // Extract Total population of a region
                            ArrayList<Population> population = a.TotalPopuationInaRegion(str);
                            // Print format function for population living and not living in regions
                            a.printPopulationTotal(population);
                        }
                        if(selector2 == 4)
                        {
                            System.out.print("= ENTER a country name -  ");
                            String str = a.getSTRInput();
                            // Extract Total population of a continent
                            ArrayList<Population> population = a.TotalPopuationInaCountry(str);
                            // Print format function for population living and not living in cities
                            a.printPopulationTotal(population);
                        }
                        if(selector2 == 5)
                        {
                            System.out.print("= ENTER a district name -  ");
                            String str = a.getSTRInput();
                            // Extract Total population of a continent
                            ArrayList<Population> population = a.TotalPopuationInaDistrict(str);
                            // Print format function for population living and not living in cities
                            a.printPopulationTotal(population);
                        }
                        if(selector2 == 6)
                        {
                            System.out.print("= ENTER a city name -  ");
                            String str = a.getSTRInput();
                            // Extract Total population of a city
                            ArrayList<Population> population = a.TotalPopuationInaCity(str);
                            // Print format function for population living and not living in cities
                            a.printPopulationTotal(population);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else if (selector1==6)
                {
                    try{
                        // Extract population of living in cities and not
                        ArrayList<Population> population = a.getLanguageUsageList();
                        // Print format function for population living and not living in cities
                        a.printLanguageList(population);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                System.out.print("- Do you want to continue <y or n>? ");
                answer = a.getSTRInput();
            } while(answer.equals("y"));



            // Disconnect from database
            System.out.println("- Disconnecting database ---> ");
            a.disconnect( );

        }
        catch(Exception e)
        {
            System.out.println("Main function failure!");
        }






    }

}