package ca.dal.casestudy1.repository;

import ca.dal.casestudy1.model.Geography;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MysqlGeographyRepository extends PagingAndSortingRepository<Geography, Long> {
    public Geography findFirstByMemberName(String memberName);
}
