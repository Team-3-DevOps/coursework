package com.napier.coursework;

public class CapitalCity {
    private String Name;

    /**
     * Capital City Name
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    private String Country;



    public String getCountry() {
        return Country;
    }
    /**
     * Capital City's country
     */

    public void setCountry(String country) {
        Country = country;
    }


    private int Population;

    /**
     * Capital City's population
     */
    public int getPopulation() {
        return Population;
    }

    @Override
    public String toString() {
        return "CapitalCity{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Population=" + Population +
                '}';
    }

    public void setPopulation(int population) {
        Population = population;
    }



}

