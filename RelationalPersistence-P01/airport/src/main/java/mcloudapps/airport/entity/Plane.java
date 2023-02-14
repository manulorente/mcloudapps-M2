package mcloudapps.airport.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plate_number", unique = true, nullable = false)
    private String plate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "number_of_flight_hours", nullable = false)
    private BigDecimal numberOfFlightHours;

    @OneToMany(mappedBy = "plane")
    private List<Overhaul> overhauls = new ArrayList<>();

    public Plane() {
    }

    public Plane(String plate, String manufacturer, String model, BigDecimal numberOfFlightHours) {
        this.plate = plate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.numberOfFlightHours = numberOfFlightHours;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getNumberOfFlightHours() {
        return this.numberOfFlightHours;
    }

    public void setNumberOfFlightHours(BigDecimal numberOfFlightHours) {
        this.numberOfFlightHours = numberOfFlightHours;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", plate='" + getPlate() + "'" +
            ", manufacturer='" + getManufacturer() + "'" +
            ", model='" + getModel() + "'" +
            ", numberOfFlightHours='" + getNumberOfFlightHours() + "'" +
            "}";
    }

}
