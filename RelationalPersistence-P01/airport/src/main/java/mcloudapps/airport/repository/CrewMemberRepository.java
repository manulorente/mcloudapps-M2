package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mcloudapps.airport.dto.NameSurnameCrewMemberAndDepartureDateTimeCityByEmployeeCodeDTO;
import mcloudapps.airport.entity.CrewMember;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {
    
    @Query("SELECT new mcloudapps.airport.dto.NameSurnameCrewMemberAndDepartureDateTimeCityByEmployeeCodeDTO(c.name, c.surname, f.departureDateTime, a.city) "
            + "FROM CrewMember c, Flight f, Airport a "
            + "WHERE c.employeeCode like :employeeCode "
            + "AND f.departureAirport.id = a.id")
    List<NameSurnameCrewMemberAndDepartureDateTimeCityByEmployeeCodeDTO> findAllCrewMembersDepartureDataByEmployeeCode(@Param("employeeCode") String employeeCode);
}
