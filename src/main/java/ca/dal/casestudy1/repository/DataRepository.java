package ca.dal.casestudy1.repository;

import ca.dal.casestudy1.model.Data;
import ca.dal.casestudy1.model.Geography;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends PagingAndSortingRepository<Data, Long> {
    @EntityGraph(value = "graph.data.*", type = EntityGraph.EntityGraphType.LOAD)
    Page<Data> findAllByGeographyEquals(Geography geography, Pageable pageable);
}
