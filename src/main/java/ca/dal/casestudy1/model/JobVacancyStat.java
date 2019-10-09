package ca.dal.casestudy1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobVacancyStat {
    @Id
    private Long memberId;

    private String memberName;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
