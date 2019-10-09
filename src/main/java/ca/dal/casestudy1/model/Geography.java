package ca.dal.casestudy1.model;

import javax.persistence.*;

@Entity
public class Geography {

    @Id
    private Long memberId;

    private String memberName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_MEMBER_ID")
    private Geography parentMember;

    private String classificationCode;

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

    public Geography getParentMember() {
        return parentMember;
    }

    public void setParentMember(Geography parentMember) {
        this.parentMember = parentMember;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }
}
