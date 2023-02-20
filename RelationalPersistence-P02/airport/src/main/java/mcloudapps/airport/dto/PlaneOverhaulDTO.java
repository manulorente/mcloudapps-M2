package mcloudapps.airport.dto;

public class PlaneOverhaulDTO {

    private String plate;

    private String technicianName;

    private String technicianSurname;

    public PlaneOverhaulDTO() {
    }

    public PlaneOverhaulDTO(String plate, String technicianName, String technicianSurname) {
        this.plate = plate;
        this.technicianName = technicianName;
        this.technicianSurname = technicianSurname;
    }

    @Override
    public String toString() {
        return "PlaneOverhaulDTO [plate=" + plate + ", technicianName=" + technicianName + ", technicianSurname="
                + technicianSurname + "]";
    }
    
}
