package ca.dal.casestudy1.dto;

import ca.dal.casestudy1.model.Data;
import ca.dal.casestudy1.model.Naics;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDetail {
    private Long id;

    private String geography;

    private String dguid;

    private String jobVacancyStat;

    private String naics;

    private String uom;

    private String scalarFactor;
    private String vector;
    private String coordinate;
    private Double value;
    private String status;
    private Date refDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getDguid() {
        return dguid;
    }

    public void setDguid(String dguid) {
        this.dguid = dguid;
    }

    public String getJobVacancyStat() {
        return jobVacancyStat;
    }

    public void setJobVacancyStat(String jobVacancyStat) {
        this.jobVacancyStat = jobVacancyStat;
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getScalarFactor() {
        return scalarFactor;
    }

    public void setScalarFactor(String scalarFactor) {
        this.scalarFactor = scalarFactor;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRefDate() {
        return refDate;
    }

    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    public static DataDetail from(Data data) {
        DataDetail detail = new DataDetail();
        detail.setCoordinate(data.getCoordinate());
        detail.setDguid(data.getDguid());
        detail.setGeography(data.getGeography().getMemberName());
        detail.setId(data.getId());
        detail.setJobVacancyStat(data.getJobVacancyStat().getMemberName());
        detail.setNaics(data.getNaics().getMemberName());
        detail.setRefDate(data.getRefDate());
        detail.setUom(data.getUom().getUom());
        detail.setValue(data.getValue());
        detail.setVector(data.getVector());
        detail.setStatus(data.getStatus());
        detail.setScalarFactor(data.getUom().getScalarFactor());
        return detail;
    }

    public static List<DataDetail> from(List<Data> dataList) {
        ArrayList<DataDetail> list = new ArrayList<>();
        for (Data item:
             dataList) {
            list.add(DataDetail.from(item));
        }
        return list;
    }

}
