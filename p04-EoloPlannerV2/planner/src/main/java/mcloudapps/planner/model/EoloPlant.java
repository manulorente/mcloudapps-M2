package mcloudapps.planner.model;

public class EoloPlant {
    
    private Long id;

    private String city;
    private int progress;
    private boolean completed;
    private String planning;

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

    @Override
    public String toString() {
        return "EoloPlant [city=" + city + ", completed=" + completed + ", id=" + id + ", planning=" + planning
                + ", progress=" + progress + "]";
    }
}
