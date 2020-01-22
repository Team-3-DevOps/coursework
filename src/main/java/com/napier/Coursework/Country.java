package com.napier.coursework;

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

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public int getCapital() {
        return capital;
    }


}

