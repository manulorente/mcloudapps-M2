package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import mcloudapps.airport.dto.ProvinceDTO;
import mcloudapps.airport.entity.Province;

public interface ProvinceRepository extends MongoRepository<Province, String>{

    @Aggregation(pipeline = { "{ $group: { _id:{ $ifNull: [\"$CA\", \"Sin comunidad\"]}, numOfProvinces: {$sum:1}}}" })
    List<ProvinceDTO> findAllAndCountProvinces();
}
