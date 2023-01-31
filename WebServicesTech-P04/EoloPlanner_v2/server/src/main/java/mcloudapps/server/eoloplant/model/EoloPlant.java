package mcloudapps.server.eoloplant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
public class EoloPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
    private int progress;
    private boolean completed;
    private String planning;

    public EoloPlant() {
    }

    public EoloPlant(String city) {
        this.city = city;
    }

    public EoloPlant(String city, String planning) {
        this.city = city;
        this.planning = planning;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
    }

    public static EoloPlant fromJson(String json) throws Exception {
        return new ObjectMapper().readValue(json, EoloPlant.class);
    }

    @Override
    public String toString() {
        return "EoloPlant [city=" + city + ", completed=" + completed + ", id=" + id + ", planning=" + planning
                + ", progress=" + progress + "]";
    }
}
