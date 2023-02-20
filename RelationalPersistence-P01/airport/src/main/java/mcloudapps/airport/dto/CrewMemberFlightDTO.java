package mcloudapps.airport.dto;


public class CrewMemberFlightDTO {

    private String name;

    private String surname;

    private double sumFlightHours;

    private Long numberOfFlights;

    public CrewMemberFlightDTO(String name, String surname, Long numberOfFlights, double sumFlightHours) {
        this.name = name;
        this.surname = surname;
        this.sumFlightHours = sumFlightHours;
        this.numberOfFlights = numberOfFlights;
    }

    @Override
    public String toString() {
        return "CrewMemberFlightDTO [name=" + name + ", numberOfFlights=" + numberOfFlights + ", surname=" + surname
                + ", sumFlightHours=" + sumFlightHours + "]";
    }
    
}
