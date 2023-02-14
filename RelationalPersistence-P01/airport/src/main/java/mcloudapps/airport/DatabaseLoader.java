package mcloudapps.airport;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import mcloudapps.airport.dto.FlightByOriginDTO;
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
import mcloudapps.airport.repository.FlightCrewMemberRepository;
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

    @Autowired
    private FlightCrewMemberRepository flightCrewMemberRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            populateDatabase();
            launchQueries();
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            deleteDatabase();
        }
    }

    private void launchQueries() {
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

    private void findFlightsOrderedByHour() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 2: Find flights ordered by hour");
        System.out.println("--------------------------------------------------------------------------------");
        List<FlightByOriginDTO> flightsOrderedByHour = this.airportRepository.findAllFlightsGivenCityAndDateOrderedByDepartureTime("London", LocalDate.of(2019, Month.DECEMBER, 27));
        for (FlightByOriginDTO flight : flightsOrderedByHour) {
            System.out.println(flight.toString());
        }
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
        //this.flightCrewMemberRepository.findAllCrewMembersNumberOfHoursAndFlights().stream().forEach(System.out::println);
    }

    private void populateDatabase() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("POPULATING DATABASE");
        System.out.println("--------------------------------------------------------------------------------");

        Plane plane1 = new Plane("1234", "Boeing", "Boeing 747", new BigDecimal(200));
        Plane plane2 = new Plane("5678", "Airbus", "Airbus A380", new BigDecimal(300));

        this.planeRepository.save(plane1);
        this.planeRepository.save(plane2);

        Technician technician1 = new Technician("AF1234", "John", "Doe", "Vueling", 2012, Education.HIGH.getEducation());
        Technician technician2 = new Technician("AF5678", "Jane", "Doe", "Vueling", 2013, Education.UNIVERSITY.getEducation());
        Technician technician3 = new Technician("AF9012", "John", "Smith", "Ryanair", 2014, Education.PRIMARY.getEducation());
        Technician technician4 = new Technician("AF3456", "Jane", "Smith", "TAP Portugal", 2015, Education.SECONDARY.getEducation());

        this.technicianRepository.save(technician1);
        this.technicianRepository.save(technician2);
        this.technicianRepository.save(technician3);
        this.technicianRepository.save(technician4);

        LocalDateTime startDateOverhaul1 = LocalDateTime.of(2016, Month.APRIL, 15, 10, 00);
        LocalDateTime endDateOverhaul1 = LocalDateTime.of(2016, Month.APRIL, 15, 12, 00);
        LocalDateTime startDateOverhaul2 = LocalDateTime.of(2016, Month.JULY, 15, 12, 00);
        LocalDateTime endDateOverhaul2 = LocalDateTime.of(2016, Month.JULY, 15, 14, 00);
        LocalDateTime startDateOverhaul3 = LocalDateTime.of(2016, Month.APRIL, 15, 14, 00);
        LocalDateTime endDateOverhaul3 = LocalDateTime.of(2016, Month.APRIL, 15, 16, 00);
        LocalDateTime startDateOverhaul4 = LocalDateTime.of(2016, Month.DECEMBER, 15, 16, 00);
        LocalDateTime endDateOverhaul4 = LocalDateTime.of(2016, Month.DECEMBER, 15, 18, 00);

        Airport airport1 = new Airport("BCN", "El prat", "Barcelona", "Spain");
        Airport airport2 = new Airport("MAD", "Barajas", "Madrid", "Spain");
        Airport airport3 = new Airport("LHR", "Heathrow", "London", "United Kingdom");
        Airport airport4 = new Airport("CDG", "Charles de Gaulle", "Paris", "France");

        this.airportRepository.save(airport1);
        this.airportRepository.save(airport2);
        this.airportRepository.save(airport3);
        this.airportRepository.save(airport4);

        Overhaul overhaul1 = new Overhaul(plane1, startDateOverhaul1, endDateOverhaul1, new BigDecimal(2), 
                                    technician1, TypeRevision.PERIODICAL.getTypeRevision(), 
                                    "Description", airport1);
        Overhaul overhaul2 = new Overhaul(plane1, startDateOverhaul2, endDateOverhaul2, new BigDecimal(1), 
                                    technician2, TypeRevision.PERIODICAL.getTypeRevision(), 
                                    "Description", airport2);
        Overhaul overhaul3 = new Overhaul(plane2, startDateOverhaul3, endDateOverhaul3, new BigDecimal(2), 
                                    technician3, TypeRevision.EXTRAORDINARY.getTypeRevision(), 
                                    "Description", airport3);
        Overhaul overhaul4 = new Overhaul(plane2, startDateOverhaul4, endDateOverhaul4, new BigDecimal(1),
                                    technician4, TypeRevision.PERIODICAL.getTypeRevision(), 
                                    "Description", airport4);
        
        this.overhaulRepository.save(overhaul1);  
        this.overhaulRepository.save(overhaul2);
        this.overhaulRepository.save(overhaul3);
        this.overhaulRepository.save(overhaul4);

        CrewMember crewMember1 = new CrewMember("CM4568", "Pepito", "Grillo", "Pilot", "Vueling");
        CrewMember crewMember2 = new CrewMember("CM9012", "Pepita", "Grillo", "Copilot", "Vueling");
        CrewMember crewMember3 = new CrewMember("CM3456", "Elva", "Ginon", "Cabin crew", "Ryanair");
        CrewMember crewMember4 = new CrewMember("CM7890", "Aitor", "Menta", "Cabin crew", "Ryanair");

        this.crewMemberRepository.save(crewMember1);
        this.crewMemberRepository.save(crewMember2);
        this.crewMemberRepository.save(crewMember3);
        this.crewMemberRepository.save(crewMember4);

        LocalDateTime departureTime1 = LocalDateTime.of(2019, Month.DECEMBER, 27, 10, 00);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2019, Month.DECEMBER, 27, 12, 00);

        LocalDateTime departureTime2 = LocalDateTime.of(2019, Month.DECEMBER, 27, 12, 00);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2019, Month.DECEMBER, 27, 14, 00);

        LocalDateTime departureTime3 = LocalDateTime.of(2019, Month.DECEMBER, 27, 18, 00);
        LocalDateTime arrivalTime3 = LocalDateTime.of(2019, Month.DECEMBER, 27, 20, 00);

        Flight flight1 = new Flight("VY2256", "Vueling", airport3, airport4, departureTime1, arrivalTime1, new BigDecimal(2), plane1);
        Flight flight2 = new Flight("FR6589", "Ryanair", airport1, airport2, departureTime2, arrivalTime2, new BigDecimal(2), plane1);
        Flight flight3 = new Flight("TP1234", "TAP Portugal", airport3, airport4, departureTime3, arrivalTime3, new BigDecimal(2), plane2);
        this.flightRepository.save(flight1);
        this.flightRepository.save(flight2);
        this.flightRepository.save(flight3);
        
        List<FlightCrewMember> flightCrewMemberList1 = new ArrayList<>();
        flightCrewMemberList1.add(new FlightCrewMember(flight1, crewMember1));
        flightCrewMemberList1.add(new FlightCrewMember(flight1, crewMember2));
        flight1.setCrewMember(flightCrewMemberList1);

        List<FlightCrewMember> flightCrewMemberList2 = new ArrayList<>();
        flightCrewMemberList2.add(new FlightCrewMember(flight2, crewMember3));
        flightCrewMemberList2.add(new FlightCrewMember(flight2, crewMember4));
        flight2.setCrewMember(flightCrewMemberList2);

        this.crewMemberRepository.save(crewMember1);
        this.crewMemberRepository.save(crewMember2);

        this.flightRepository.save(flight1);
        this.flightRepository.save(flight2);

    }

    private void deleteDatabase() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("DELETING DATABASE");
        System.out.println("--------------------------------------------------------------------------------");
        this.flightCrewMemberRepository.deleteAll();        
        this.overhaulRepository.deleteAll();
        this.crewMemberRepository.deleteAll();
        this.technicianRepository.deleteAll();
        this.flightRepository.deleteAll();
        this.airportRepository.deleteAll();
        this.planeRepository.deleteAll();
    }
}
    
