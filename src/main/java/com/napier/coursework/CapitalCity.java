package com.napier.coursework;
/**
 * CapitalCity class for Capital City Report
 */
public class CapitalCity {
    /**
     * Capital City Name
     */
    private String Name;
    /**
     * Get method for Capital City Name
     */
    public String getName() {
        return Name;
    }
    /**
     * Set method for Capital City Name
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * Capital City's country
     */
    private String Country;
    /**
     * Get method for Capital City's country
     */
    public String getCountry() {
        return Country;
    }
    /**
     * Set method for Capital City's country
     */
    public void setCountry(String country) {
        Country = country;
    }
    /**
     * Capital City's population
     */
    private int Population;
    /**
     * Get method for Capital City's population
     */
    public int getPopulation() {
        return Population;
    }
    /**
     * Set method for Capital City's population
     */
    public void setPopulation(int population) {
        Population = population;
    }
    /**
     * Override method for Capital City Report
     */
    @Override
    public String toString() {
        return "CapitalCity{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Population=" + Population +
                '}';
    }




}

