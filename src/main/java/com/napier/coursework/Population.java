package com.napier.coursework;
/*
Represent a population
 */
public class Population {
    private String name;
    private long total;
    private long living_in_city;
    private float living_in_city_percent;
    private long not_living_in_city;
    private float not_living_in_city_percent;

    public float getLiving_in_city_percent() {
        return living_in_city_percent;
    }

    public void setLiving_in_city_percent(float living_in_city_percent) {
        this.living_in_city_percent = living_in_city_percent;
    }

    public float getNot_living_in_city_percent() {
        return not_living_in_city_percent;
    }

    public void setNot_living_in_city_percent(float not_living_in_city_percent) {
        this.not_living_in_city_percent = not_living_in_city_percent;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getLiving_in_city() {
        return living_in_city;
    }

    public void setLiving_in_city(long living_in_city) {
        this.living_in_city = living_in_city;
    }

    public long getNot_living_in_city() {
        return not_living_in_city;
    }

    public void setNot_living_in_city(long not_living_in_city) {
        this.not_living_in_city = not_living_in_city;
    }

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
