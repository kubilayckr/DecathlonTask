package org.example.mdoel.dto;

public class ResultDTO {

    private String athleteName;
    private Integer totalPoint;

    public ResultDTO() {
    }

    public ResultDTO(String athleteName, Integer totalPoint) {
        this.athleteName = athleteName;
        this.totalPoint = totalPoint;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }
}
