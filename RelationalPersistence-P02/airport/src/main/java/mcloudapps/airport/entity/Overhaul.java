package mcloudapps.airport.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "Overhaul")
public class Overhaul {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "overhaul_type")
    private String type;

    @Column(name = "overhaul_description")
    private String description;

    @OneToOne
    private Plane plane;

    @OneToOne
    private Technician technician;

    @OneToOne
    private Airport airport;

    public Overhaul() {
    }

    public Overhaul(Plane plane, Date startDate, Date endDate, Double duration, Technician technician, String type,
            String description, Airport airport) {
        this.plane = plane;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.technician = technician;
        this.type = type;
        this.description = description;
        this.airport = airport;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Technician getTechnician() {
        return this.technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public String getTypeRevision() {
        return this.type;
    }

    public void setTypeRevision(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airport getAirport() {
        return this.airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", plane='" + getPlane() + "'" + ", startDate='" + getStartDate() + "'"
                + ", endDate='" + getEndDate() + "'" + ", duration='" + getDuration() + "'" + ", technician='"
                + getTechnician() + "'" + ", type='" + getTypeRevision() + "'" + ", description='"
                + getDescription() + "'" + ", airport='" + getAirport() + "'" + "}";
    }
}
