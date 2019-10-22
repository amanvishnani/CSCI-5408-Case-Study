package ca.dal.casestudy1.dto;

import java.util.List;

public class DataSummary <T> {
    private List<T> content;
    private Long fetchTime;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Long fetchTime) {
        this.fetchTime = fetchTime;
    }

    public DataSummary(List<T> content, Long fetchTime) {
        this.content = content;
        this.fetchTime = fetchTime;
    }
}
