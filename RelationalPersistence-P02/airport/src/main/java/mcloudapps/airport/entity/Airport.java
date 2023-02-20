package mcloudapps.airport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Airport")
public class Airport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 3)
    private String iata;

    private String name;

    private String city;

    private String country;

    public Airport() {
    }

    public Airport(String iata, String name, String city, String country) {
        this.iata = iata;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIata() {
        return this.iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", iata='" + getIata() + "'" +
            ", name='" + getName() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
