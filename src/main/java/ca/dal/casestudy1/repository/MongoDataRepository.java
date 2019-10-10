package ca.dal.casestudy1.repository;

import ca.dal.casestudy1.model.MongoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDataRepository extends MongoRepository<MongoData, Long> {
    public Page<MongoData> findAllByGeography(String geography, Pageable pageable);
}
