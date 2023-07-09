package org.example.problem3;

import java.util.Date;

public class City {
    private long uniqueId;
    private final String name;
    private final Date dateFounded;
    private final String country;

    public long getUniqueId() {
        return uniqueId;
    }

    public City(String name, Date dateFounded, String country, long uniqueId) {
        this.name = name;
        this.dateFounded = dateFounded;
        this.country = country;
        this.uniqueId = uniqueId;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    private static long index = 0;

    public static City of(String name, Date dateFounded, String country) {
        return new City(name, dateFounded, country, index++);
    }

}
