package com.napier.Coursework;

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
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract cities by descended population
//        ArrayList<City> city = a.getAllCities();

        // Extract cities in continent by descended population
        ArrayList<City> city = a.getAllCitiesInContinent();

        // Print all the city information
        a.printCityInfo(city);

        // Disconnect from database
        a.disconnect();
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
                cty.ID = rset.getInt("city.ID");
                cty.Name = rset.getString("city.Name");
                cty.CountryCode = rset.getString("city.CountryCode");
                cty.District = rset.getString("city.District");
                cty.Population = rset.getInt("city.Population");
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
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent " +
                            "FROM city, country WHERE city.CountryCode = country.Code and country.Continent = 'Asia' " +
                            "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {

                City cty = new City();
                cty.ID = rset.getInt("city.ID");
                cty.Name = rset.getString("city.Name");
                cty.CountryCode = rset.getString("city.CountryCode");
                cty.District = rset.getString("city.District");
                cty.Population = rset.getInt("city.Population");
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
     * Prints a list of cities.
     * @param city The list of cities to print.
     */
    public void printCityInfo(ArrayList<City> city)
    {
        // Print header
        System.out.println("Here is a report of cities by descending their populations");
        System.out.println(String.format("%-20s %-50s %-20s %-50s %-50s %-20s", "City ID", "Name", "Country Code", "District", "Population", "Continent" ));
        // Loop over all employees in the list
        for (City cty : city)
        {
            String cty_string =
                    String.format("%-20s %-50s %-20s %-50s %-50s %-20s",
                            cty.ID, cty.Name, cty.CountryCode, cty.District, cty.Population, cty.Continent);
            System.out.println(cty_string);
        }
    }
}