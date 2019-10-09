package ca.dal.casestudy1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedEntityGraph(name = "graph.data.*",
        attributeNodes = {
            @NamedAttributeNode("jobVacancyStat"), @NamedAttributeNode("geography"),
            @NamedAttributeNode("naics"), @NamedAttributeNode("uom")
        })
public class Data {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GEO_ID")
    private Geography geography;

    private String dguid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "JOB_VACANCY_STAT_ID")
    private JobVacancyStat jobVacancyStat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NAICS_ID")
    private Naics naics;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UOM_ID")
    private Uom uom;

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

    public Geography getGeography() {
        return geography;
    }

    public void setGeography(Geography geography) {
        this.geography = geography;
    }

    public String getDguid() {
        return dguid;
    }

    public void setDguid(String dguid) {
        this.dguid = dguid;
    }

    public JobVacancyStat getJobVacancyStat() {
        return jobVacancyStat;
    }

    public void setJobVacancyStat(JobVacancyStat jobVacancyStat) {
        this.jobVacancyStat = jobVacancyStat;
    }

    public Naics getNaics() {
        return naics;
    }

    public void setNaics(Naics naics) {
        this.naics = naics;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
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
}
