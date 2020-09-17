package com.khsiung.repository;
import java.util.List;
 
import com.khsiung.model.DowJones;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DowJonesRepository extends MongoRepository<DowJones, String> {

    List<DowJones> findByStock(String stock);
}