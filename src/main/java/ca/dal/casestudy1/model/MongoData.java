package ca.dal.casestudy1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "MongoData")
public class MongoData {
    @Id
    private String id;

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
    private String refDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }
}
