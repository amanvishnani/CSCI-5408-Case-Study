package ca.dal.casestudy1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScalarFactor {
    @Id
    private Long scalarId;

    private String scalarFactor;

    public Long getScalarId() {
        return scalarId;
    }

    public void setScalarId(Long scalarId) {
        this.scalarId = scalarId;
    }

    public String getScalarFactor() {
        return scalarFactor;
    }

    public void setScalarFactor(String scalarFactor) {
        this.scalarFactor = scalarFactor;
    }
}
