package com.napier.coursework;
/**
 * Population class for Population Report
 */
public class Population {
    /**
     * Name of Continent, Region, Country, District, City.
     */
    private String name;
    /**
     * Total Population.
     */
    private long total;
    /**
     * Total Population in cities.
     */
    private long living_in_city;
    /**
     * Percentage of Total Population in cities.
     */
    private float living_in_city_percent;
    /**
     * Total Population not in cities.
     */
    private long not_living_in_city;
    /**
     * Percentage of Total Population not in cities.
     */
    private float not_living_in_city_percent;
    /**
     * Get method for Percentage of Total Population in cities.
     */
    public float getLiving_in_city_percent() {
        return living_in_city_percent;
    }
    /**
     * Set method for Percentage of Total Population in cities.
     */
    public void setLiving_in_city_percent(float living_in_city_percent) {
        this.living_in_city_percent = living_in_city_percent;
    }
    /**
     * Get method for Percentage of Total Population not in cities.
     */
    public float getNot_living_in_city_percent() {
        return not_living_in_city_percent;
    }
    /**
     * Set method for Percentage of Total Population not in cities.
     */
    public void setNot_living_in_city_percent(float not_living_in_city_percent) {
        this.not_living_in_city_percent = not_living_in_city_percent;
    }


    /**
     * Get method for Name of Continent, Region, Country, District, City.
     */
    public String getName() {
        return name;
    }
    /**
     * Set method for Name of Continent, Region, Country, District, City.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get method for Total Population.
     */
    public long getTotal() {
        return total;
    }
    /**
     * Set method for Total Population.
     */
    public void setTotal(long total) {
        this.total = total;
    }
    /**
     * Get method for Total Population in cities.
     */
    public long getLiving_in_city() {
        return living_in_city;
    }
    /**
     * Set method for Total Population in cities.
     */
    public void setLiving_in_city(long living_in_city) {
        this.living_in_city = living_in_city;
    }
    /**
     * Get method for Total Population not in cities.
     */
    public long getNot_living_in_city() {
        return not_living_in_city;
    }
    /**
     * Set method for Total Population not in cities.
     */
    public void setNot_living_in_city(long not_living_in_city) {
        this.not_living_in_city = not_living_in_city;
    }
    /**
     * Override method for Population Report
     */
    @Override
    public String toString() {
        return "Population{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", living_in_city=" + living_in_city +
                ", living_in_city_percent=" + living_in_city_percent +
                ", not_living_in_city=" + not_living_in_city +
                ", not_living_in_city_percent=" + not_living_in_city_percent +
                '}';
    }
}
