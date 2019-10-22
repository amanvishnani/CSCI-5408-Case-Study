package ca.dal.casestudy1.rest;

import ca.dal.casestudy1.dto.DataDetail;
import ca.dal.casestudy1.dto.DataSummary;
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

import java.util.Date;
import java.util.List;

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
    public DataSummary<DataDetail> getMysqlData(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "ALL") String geography
    ) {
        Pageable request = PageRequest.of(pageNumber, pageSize);
        Geography geo = null;
        if(!geography.equals("ALL")) {
            geo = mysqlGeographyRepository.findFirstByMemberName(geography);
        }
        Date d1 = new Date();
        List<Data> list;
        if(geo==null) {
            list = dataRepository.findAll();
        } else {
            list = dataRepository.findAllByGeographyEquals(geo);
        }
        Date d2 = new Date();
        return new DataSummary<DataDetail>(DataDetail.from(list),d2.getTime()-d1.getTime());
    }

    @GetMapping("mongo")
    public DataSummary<MongoData> getMongoData(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "ALL") String geography
    ) {
        List<MongoData> data;
        Pageable request = PageRequest.of(pageNumber, pageSize);
        Date d1 = new Date();
        if(geography.equals("ALL")) {
            data = mongoDataRepository.findAll();
        } else {
            data = mongoDataRepository.findAllByGeography(geography);
        }
        Date d2 = new Date();
        return new DataSummary<MongoData>(data,d2.getTime()-d1.getTime());
    }
}
