package ca.dal.casestudy1.repository;

import ca.dal.casestudy1.model.MongoData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDataRepository extends MongoRepository<MongoData, Long> {
}
