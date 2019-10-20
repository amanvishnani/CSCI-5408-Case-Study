package ca.dal.casestudy1.rest;

import ca.dal.casestudy1.dto.DataDetail;
import ca.dal.casestudy1.model.Data;
import ca.dal.casestudy1.model.Geography;
import ca.dal.casestudy1.model.MongoData;
import ca.dal.casestudy1.repository.DataRepository;
import ca.dal.casestudy1.repository.MongoDataRepository;
import ca.dal.casestudy1.repository.MysqlGeographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private MongoDataRepository mongoDataRepository;

    @Autowired
    private MysqlGeographyRepository mysqlGeographyRepository;

    @GetMapping("mysql")
    public Page<DataDetail> getMysqlData(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "ALL") String geography
    ) {
        Pageable request = PageRequest.of(pageNumber, pageSize);
        Geography geo = null;
        if(!geography.equals("ALL")) {
            geo = mysqlGeographyRepository.findFirstByMemberName(geography);
        }
        Page<Data> page;
        if(geo==null) {
            page = dataRepository.findAll(request);
        } else {
            page = dataRepository.findAllByGeographyEquals(geo, request);
        }
        return new PageImpl<>(DataDetail.from(page.getContent()),request, page.getTotalElements());
    }

    @GetMapping("mongo")
    public Page<MongoData> getMongoData(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "ALL") String geography
    ) {
        Pageable request = PageRequest.of(pageNumber, pageSize);
        if(geography.equals("ALL")) {
            return mongoDataRepository.findAll(request);
        } else {
            return mongoDataRepository.findAllByGeography(geography, request);
        }
    }
}
