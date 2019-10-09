package ca.dal.casestudy1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Uom {
    @Id
    private Long uomId;
    private String uom;
    private Long scalarId;
    private String scalarFactor;

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

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
