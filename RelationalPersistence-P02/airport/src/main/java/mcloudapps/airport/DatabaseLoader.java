package mcloudapps.airport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import mcloudapps.airport.entity.Airport;
import mcloudapps.airport.entity.CrewMember;
import mcloudapps.airport.entity.Education;
import mcloudapps.airport.entity.Flight;
import mcloudapps.airport.entity.FlightCrewMember;
import mcloudapps.airport.entity.Overhaul;
import mcloudapps.airport.entity.Plane;
import mcloudapps.airport.entity.Technician;
import mcloudapps.airport.entity.TypeRevision;
import mcloudapps.airport.repository.AirportRepository;
import mcloudapps.airport.repository.CrewMemberRepository;
import mcloudapps.airport.repository.FlightRepository;
import mcloudapps.airport.repository.OverhaulRepository;
import mcloudapps.airport.repository.PlaneRepository;
import mcloudapps.airport.repository.TechnicianRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private AirportRepository airportRepository;
    
    @Autowired
    private CrewMemberRepository crewMemberRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private OverhaulRepository overhaulRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            loadDatabase();
            launchQueries();
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            deleteDatabase();
        }
    }

    private void launchQueries() throws ParseException {
        findTechnicians();
        findFlightsOrderedByHour();
        findCrewMembersDepartureDataByEmployeeCode();
        findNumberOfHoursAndFlightsPerCrewMember();
    }

    private void findTechnicians() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 1: Find technicians per plane");
        System.out.println("--------------------------------------------------------------------------------");
        this.planeRepository.findAllPlanesByTechnicianAndOverhaul().stream().forEach(System.out::println);
    }

    private void findFlightsOrderedByHour() throws ParseException {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 2: Find flights ordered by hour");
        System.out.println("--------------------------------------------------------------------------------");
        this.flightRepository.findAllFlightsGivenCityAndDateOrderedByDepartureTime("London", "27/12/2019").stream().forEach(System.out::println);
    }

    private void findCrewMembersDepartureDataByEmployeeCode() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 3: Find crew members departure data by employee code");
        System.out.println("--------------------------------------------------------------------------------");
        this.crewMemberRepository.findAllCrewMembersDepartureDataByEmployeeCode("CM4568")
        .stream().forEach(System.out::println);
    }

    private void findNumberOfHoursAndFlightsPerCrewMember() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 4: Find number of hours and flights per crew member");
        System.out.println("--------------------------------------------------------------------------------");
        this.crewMemberRepository.findAllCrewMembersNumberOfHoursAndFlights().stream().forEach(System.out::println);
    }

    private void loadDatabase() throws ParseException {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("POPULATING DATABASE");

        Plane plane1 = new Plane("1234", "Boeing", "747", 5000L);
        Plane plane2 = new Plane("5678", "Airbus", "A380", 10000L);
        Plane plane3 = new Plane("9876", "Airbus", "A330", 15000L);
        Plane plane4 = new Plane("5432", "Boeing", "737", 20000L);
        Plane plane5 = new Plane("1111", "Airbus", "A320", 20000L);
        this.planeRepository.saveAll(Arrays.asList(plane1, plane2, plane3, plane4, plane5));

        Airport airport1 = new Airport("BCN", "El prat", "Barcelona", "Spain");
        Airport airport2 = new Airport("MAD", "Barajas", "Madrid", "Spain");
        Airport airport3 = new Airport("LHR", "Heathrow", "London", "United Kingdom");
        Airport airport4 = new Airport("CDG", "Charles de Gaulle", "Paris", "France");
        Airport airport5 = new Airport("AMS", "Schiphol", "Amsterdam", "Netherlands");
        this.airportRepository.saveAll(Arrays.asList(airport1, airport2, airport3, airport4, airport5));

        CrewMember crewMember1 = new CrewMember("CM4568", "Alex", "Cremento", "Pilot", "Vueling");
        CrewMember crewMember2 = new CrewMember("CM9012", "Pepita", "Grillo", "Copilot", "Vueling");
        CrewMember crewMember3 = new CrewMember("CM3456", "Elva", "Ginon", "Cabin crew", "Ryanair");
        CrewMember crewMember4 = new CrewMember("CM7890", "Aitor", "Menta", "Cabin crew", "Ryanair");
        CrewMember crewMember5 = new CrewMember("CM1234", "Alex", "Cremento", "Pilot", "Vueling");

        Flight flight1 = new Flight("VY2256", "Vueling", plane1, airport3, airport4,
                                    new SimpleDateFormat("dd/MM/yyyy").parse("27/12/2019"), 
                                    2.0);
        List<FlightCrewMember> flightCrewMemberList1 = Arrays.asList(new FlightCrewMember(flight1, crewMember1), new FlightCrewMember(flight1, crewMember2));                          
        flight1.setCrewMember(flightCrewMemberList1);
        Flight flight2 = new Flight("FR6589", "Ryanair", plane1, airport1, airport2, 
                                    new SimpleDateFormat("dd/MM/yyyy").parse("13/11/2019"), 
                                    2.0);
        List<FlightCrewMember> flightCrewMemberList2 = Arrays.asList(new FlightCrewMember(flight2, crewMember3), new FlightCrewMember(flight2, crewMember4));
        flight2.setCrewMember(flightCrewMemberList2);
        Flight flight3 = new Flight("TP1234", "TAP Portugal", plane2, airport3, airport4, 
                                    new SimpleDateFormat("dd/MM/yyyy").parse("27/12/2019"), 
                                    2.0);
        List<FlightCrewMember> flightCrewMemberList3 = Arrays.asList(new FlightCrewMember(flight3, crewMember5));
        flight3.setCrewMember(flightCrewMemberList3);
        this.flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

        Technician technician1 = new Technician("AF1234", "John", "Doe", "Vueling", 2012, Education.HIGH.getEducation());
        Technician technician2 = new Technician("AF5678", "Jane", "Doe", "Vueling", 2013, Education.UNIVERSITY.getEducation());
        Technician technician3 = new Technician("AF9012", "John", "Smith", "Ryanair", 2014, Education.PRIMARY.getEducation());
        Technician technician4 = new Technician("AF3456", "Jane", "Smith", "TAP Portugal", 2015, Education.SECONDARY.getEducation());
        this.technicianRepository.saveAll(Arrays.asList(technician1, technician2, technician3, technician4));
        
        Overhaul overhaul1 = new Overhaul(plane1, 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2019"), 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019"), 
                                            15.0, 
                                            technician1, 
                                            TypeRevision.PERIODICAL.getTypeRevision(), 
                                            "Description", 
                                            airport1);
        Overhaul overhaul2 = new Overhaul(plane1, 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2019"), 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("18/07/2019"),
                                            30.0, 
                                            technician2, 
                                            TypeRevision.PERIODICAL.getTypeRevision(), 
                                            "Description", 
                                            airport2);
        Overhaul overhaul3 = new Overhaul(plane2, 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2019"), 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("18/12/2019"),
                                            10.0, 
                                            technician3, 
                                            TypeRevision.EXTRAORDINARY.getTypeRevision(), 
                                            "Description", 
                                            airport3);
        Overhaul overhaul4 = new Overhaul(plane2,
                                            new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2019"), 
                                            new SimpleDateFormat("dd/MM/yyyy").parse("18/09/2019"),
                                            50.0, 
                                            technician4, 
                                            TypeRevision.PERIODICAL.getTypeRevision(), 
                                            "Description", 
                                            airport4);
        this.overhaulRepository.saveAll(Arrays.asList(overhaul1, overhaul2, overhaul3, overhaul4));
        
        System.out.println("--------------------------------------------------------------------------------");

        printDatabase();
    }

    private void printDatabase(){
        System.out.println("Planes:");
        this.planeRepository.findAll().forEach(System.out::println);
        System.out.println("Airports:");
        this.airportRepository.findAll().forEach(System.out::println);
        System.out.println("Flights:");
        this.flightRepository.findAll().forEach(System.out::println);
        System.out.println("Crew members:");
        this.crewMemberRepository.findAll().forEach(System.out::println);
        System.out.println("Technicians:");
        this.technicianRepository.findAll().forEach(System.out::println);
        System.out.println("Overhauls:");
        this.overhaulRepository.findAll().forEach(System.out::println);
    }

    private void deleteDatabase(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("DELETING DATABASE");
        this.overhaulRepository.deleteAll();
        this.technicianRepository.deleteAll();
        this.crewMemberRepository.deleteAll();
        this.flightRepository.deleteAll();
        this.airportRepository.deleteAll();
        this.planeRepository.deleteAll();
        System.out.println("--------------------------------------------------------------------------------");
    }
}
    
