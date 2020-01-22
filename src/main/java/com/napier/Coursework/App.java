package com.napier.coursework;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


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
     * Get input data from the User.
     */
    public void input()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter input text: ");
        String myString = input.next();
        System.out.println("Text entered = " + myString);
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
                ctry.code = rset.getString("country.code");
                ctry.name = rset.getString("country.name");
                ctry.continent = rset.getString("country.continent");
                ctry.region = rset.getString("country.region");
                ctry.population = rset.getInt("country.population");
                ctry.capital = rset.getInt("country.capital");
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
                ctry.code = rset.getString("country.code");
                ctry.name = rset.getString("country.name");
                ctry.continent = rset.getString("country.continent");
                ctry.region = rset.getString("country.region");
                ctry.population = rset.getInt("country.population");
                ctry.capital = rset.getInt("country.capital");
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
                ctry.code = rset.getString("country.code");
                ctry.name = rset.getString("country.name");
                ctry.continent = rset.getString("country.continent");
                ctry.region = rset.getString("country.region");
                ctry.population = rset.getInt("country.population");
                ctry.capital = rset.getInt("country.capital");
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
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-60s %-20s %-30s %-15s %-10s", "Code", "Country", "Continent", "Region", "Population", "Capitals"));
        // Loop over all countries in the list
        for (Country ctry : countries)
        {
            String ctry_string =
                    String.format("%-10s %-60s %-20s %-30s %-15s %-10s" , ctry.code, ctry.name, ctry.continent, ctry.region, ctry.population, ctry.capital);
            System.out.println(ctry_string);
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract country population information
        //ArrayList<Country> countries = a.getAllCountries();
        //ArrayList<Country> countries = a.getAllCountriesInContinent();
        ArrayList<Country> countries = a.getAllCountriesInRegion();
        a.printCountries(countries);

        // Test the size of the returned data - should be
        System.out.println(countries.size());

        // Disconnect from database
        a.disconnect();
    }
}
