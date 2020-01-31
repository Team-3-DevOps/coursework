package com.napier.coursework;

/**
 * City class for City Report
 */
public class City {
    /**
     * City ID
     */
    private int ID;

    /**
     * City Name
     */
    private String Name;

    /**
     * City's country code
     */
    private String CountryCode;

    /**
     * district of the city
     */
    private String District;

    /**
     * City population
     */
    private int Population;

    /**
     * Override method for City Report
     */
    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }
    /**
     * Get method for City's ID
     */
    public int getID() {
        return ID;
    }
    /**
     * Get method for City's Name
     */
    public String getName() {
        return Name;
    }
    /**
     * Get method for Country Code
     */
    public String getCountryCode() {
        return CountryCode;
    }
    /**
     * Get method for District
     */
    public String getDistrict() {
        return District;
    }
    /**
     * Get method for City's population
     */
    public int getPopulation() {
        return Population;
    }
    /**
     * Set method for City's ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    /**
     * Set method for City's Name
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * Set method for Country Code
     */
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    /**
     * Set method for District
     */
    public void setDistrict(String district) {
        District = district;
    }
    /**
     * Set method for City's population
     */
    public void setPopulation(int population) {
        Population = population;
    }
}