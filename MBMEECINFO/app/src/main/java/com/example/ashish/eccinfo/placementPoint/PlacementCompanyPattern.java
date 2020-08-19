package com.example.ashish.eccinfo.placementPoint;

import java.io.Serializable;

/**
 * Created by Ashish on 8/21/2017.
 */

public class PlacementCompanyPattern implements Serializable {

    private String roundId;
    private String roundName;
    private String roundDetail;

    public PlacementCompanyPattern() {
    }

    public PlacementCompanyPattern(String roundId, String roundName, String roundDetail) {
        this.roundId = roundId;
        this.roundName = roundName;
        this.roundDetail = roundDetail;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public String getRoundDetail() {
        return roundDetail;
    }

    public void setRoundDetail(String roundDetail) {
        this.roundDetail = roundDetail;
    }

    @Override
    public String toString() {
        return this.getRoundName();
    }
}
