package ca.dal.casestudy1.repository;

import ca.dal.casestudy1.model.Data;
import ca.dal.casestudy1.model.Geography;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    @EntityGraph(value = "graph.data.*", type = EntityGraph.EntityGraphType.LOAD)
    List<Data> findAllByGeographyEquals(Geography geography);

    @Override
    @EntityGraph(value = "graph.data.*", type = EntityGraph.EntityGraphType.LOAD)
    List<Data> findAll();
}
