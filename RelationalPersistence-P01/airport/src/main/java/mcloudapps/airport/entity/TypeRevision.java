package mcloudapps.airport.entity;

public enum TypeRevision {

    PERIODICAL("Periodical"), EXTRAORDINARY("Extraordinary"), REPARATION("Reparation");

    private String typeRevision;

    private TypeRevision(String typeRevision) {
        this.typeRevision = typeRevision;
    }

    public String getTypeRevision() {
        return this.typeRevision;
    }

    public void setTypeRevision(String typeRevision) {
        this.typeRevision = typeRevision;
    }
    
}
