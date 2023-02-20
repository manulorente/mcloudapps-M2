package mcloudapps.airport.entity;

public enum Education {

    PRIMARY("Primary"), SECONDARY("Secondary"), HIGH("High"), UNIVERSITY("University");

    private String education;

    private Education(String education) {
        this.education = education;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
}
