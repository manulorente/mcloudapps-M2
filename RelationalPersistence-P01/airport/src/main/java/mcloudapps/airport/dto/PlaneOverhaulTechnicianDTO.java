package mcloudapps.airport.dto;

public class PlaneOverhaulTechnicianDTO {

    private String plate;

    private String technicianName;

    private String technicianSurname;

    public PlaneOverhaulTechnicianDTO() {
    }

    public PlaneOverhaulTechnicianDTO(String plate, String technicianName, String technicianSurname) {
        this.plate = plate;
        this.technicianName = technicianName;
        this.technicianSurname = technicianSurname;
    }

    public String getId() {
        return this.plate;
    }

    public String getName() {
        return this.technicianName;
    }

    public String getSurname() {
        return this.technicianSurname;
    }

    @Override
    public String toString() {
        return "{" +
            " plate='" + getId() + "'" +
            ", technicianName='" + getName() + "'" +
            ", technicianSurname='" + getSurname() + "'" +
            "}";
    }
    
}
