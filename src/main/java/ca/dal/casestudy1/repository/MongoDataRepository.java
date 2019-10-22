package ca.dal.casestudy1.repository;

import ca.dal.casestudy1.model.MongoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoDataRepository extends MongoRepository<MongoData, Long> {
    public List<MongoData> findAllByGeography(String geography);
}
