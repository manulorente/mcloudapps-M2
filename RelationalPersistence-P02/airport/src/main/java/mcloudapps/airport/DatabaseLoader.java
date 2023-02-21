package mcloudapps.airport;

import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import mcloudapps.airport.repository.AirportRepository;
import mcloudapps.airport.repository.CrewMemberRepository;
import mcloudapps.airport.repository.FlightRepository;
import mcloudapps.airport.repository.OverhaulRepository;
import mcloudapps.airport.repository.PlaneRepository;
import mcloudapps.airport.repository.TechnicianRepository;
import mcloudapps.airport.repository.ProvinceRepository;

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
    private ProvinceRepository provinceRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            printDatabase();
            launchQueries();
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void launchQueries() throws ParseException {
        findTechnicians();
        findFlightsOrderedByHour();
        findCrewMembersDepartureDataByEmployeeCode();
        findNumberOfHoursAndFlightsPerCrewMember();
        findTechniciansPerPlaneJson();
        findCrewMembersStatisticsJson();
        findAllProvincesData();
        findAllAndCountProvinces();
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
        this.flightRepository.findAllFlightsGivenCityAndDateOrderedByDepartureTime("London", "27/12/2019")
        .stream().forEach(System.out::println);
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

    private void findTechniciansPerPlaneJson() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 5: Find technicians per plane (JSON)");
        System.out.println("--------------------------------------------------------------------------------");
        List<Object> list = this.planeRepository.findAllPlanesByTechnicianAndOverhaulJson();
        for (Object object : list) {
            Object[] array = (Object[]) object;
            System.out.println("Plate: " + array[0] + " - Technician: " + array[1] + " " + array[2]);
        }
    }

    private void findCrewMembersStatisticsJson() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 6: Find crew members statistics (JSON)");
        System.out.println("--------------------------------------------------------------------------------");
        List<Object> list = this.crewMemberRepository.findAllCrewMembersNumberOfHoursAndFlightsJson();
        for (Object object : list) {
            Object[] array = (Object[]) object;
            System.out.println("Employee code: " + array[0] + " " + array[1] + " - Number of flights: " + array[2] + " - Number of hours: " + array[3]);
        }
    }

    private void findAllProvincesData() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 7: Find all provinces data");
        System.out.println("--------------------------------------------------------------------------------");
        this.provinceRepository.findAll().stream().forEach(System.out::println);
    }

    private void findAllAndCountProvinces() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Query 8: Find and count all provinces");
        System.out.println("--------------------------------------------------------------------------------");
        this.provinceRepository.findAllAndCountProvinces().stream().forEach(System.out::println);
    }

    private void printDatabase(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("DATABASE");
        System.out.println("--------------------------------------------------------------------------------");
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
}
    
