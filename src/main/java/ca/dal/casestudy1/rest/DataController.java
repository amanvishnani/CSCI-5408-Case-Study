package ca.dal.casestudy1.rest;

import ca.dal.casestudy1.dto.DataDetail;
import ca.dal.casestudy1.model.Data;
import ca.dal.casestudy1.model.Geography;
import ca.dal.casestudy1.model.MongoData;
import ca.dal.casestudy1.repository.DataRepository;
import ca.dal.casestudy1.repository.MongoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private MongoDataRepository mongoDataRepository;

    @GetMapping("mysql")
    public Page<DataDetail> getMysqlData(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize) {
        Pageable request = PageRequest.of(pageNumber, pageSize);
        Geography geo = new Geography();
        geo.setMemberId(1L);
        geo.setMemberName("Canada");
        Page<Data> page = dataRepository.findAllByGeographyEquals(geo, request);
        return new PageImpl<>(DataDetail.from(page.getContent()),request, page.getTotalElements());
    }

    @GetMapping("mongo")
    public Page<MongoData> getMongoData(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize) {
        Pageable request = PageRequest.of(pageNumber, pageSize);
        Page<MongoData> page = mongoDataRepository.findAll(request);
        return new PageImpl<>(page.getContent(),request, page.getTotalElements());
    }
}
