package com.napier.coursework;
/**
 * Country class for Country Report
 */
public class Country {
    /**
     * Country Code
     */
    private String code;

    /**
     * Country Name
     */
    private String name;

    /**
     * Country's Continent
     */
    private String continent;

    /**
     * Country's Region
     */
    private String region;

    /**
     * Country's Population
     */
    private int population;

    /**
     * Country's Capital
     */
    private int capital;
    /**
     * Override method for Country Report
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
    /**
     * Set method for Country Code
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * Set method for Country' Name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Set method for Country's Continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }
    /**
     * Set method for Country's Region
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * Set method for Country's population
     */
    public void setPopulation(int population) {
        this.population = population;
    }
    /**
     * Set method for Capital ID
     */
    public void setCapital(int capital) {
        this.capital = capital;
    }
    /**
     * Get method for Country Code
     */
    public String getCode() {
        return code;
    }
    /**
     * Get method for Country Name
     */
    public String getName() {
        return name;
    }
    /**
     * Get method for Country's Continent
     */
    public String getContinent() {
        return continent;
    }
    /**
     * Get method for Country's Region
     */
    public String getRegion() {
        return region;
    }
    /**
     * Get method for Country's population
     */
    public int getPopulation() {
        return population;
    }
    /**
     * Get method for Capital ID
     */
    public int getCapital() {
        return capital;
    }


}
