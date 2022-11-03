package org.example.mdoel.dto;

public class DecathlonPerformanceDTO {

    private String athleteName;
    private double oneHundredMetres;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double fourHundredMetres;
    private double oneHundredTenMetresHurdles;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private String oneThousandFiveHundredMetres;

    public DecathlonPerformanceDTO() {
    }

    public DecathlonPerformanceDTO(String athleteName, double oneHundredMetres, double longJump, double shotPut, double highJump, double fourHundredMetres, double oneHundredTenMetresHurdles, double discusThrow, double poleVault, double javelinThrow, String oneThousandFiveHundredMetres) {
        this.athleteName = athleteName;
        this.oneHundredMetres = oneHundredMetres;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.fourHundredMetres = fourHundredMetres;
        this.oneHundredTenMetresHurdles = oneHundredTenMetresHurdles;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.oneThousandFiveHundredMetres = oneThousandFiveHundredMetres;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public double getOneHundredMetres() {
        return oneHundredMetres;
    }

    public void setOneHundredMetres(double oneHundredMetres) {
        this.oneHundredMetres = oneHundredMetres;
    }

    public double getLongJump() {
        return longJump;
    }

    public void setLongJump(double longJump) {
        this.longJump = longJump;
    }

    public double getShotPut() {
        return shotPut;
    }

    public void setShotPut(double shotPut) {
        this.shotPut = shotPut;
    }

    public double getHighJump() {
        return highJump;
    }

    public void setHighJump(double highJump) {
        this.highJump = highJump;
    }

    public double getFourHundredMetres() {
        return fourHundredMetres;
    }

    public void setFourHundredMetres(double fourHundredMetres) {
        this.fourHundredMetres = fourHundredMetres;
    }

    public double getOneHundredTenMetresHurdles() {
        return oneHundredTenMetresHurdles;
    }

    public void setOneHundredTenMetresHurdles(double oneHundredTenMetresHurdles) {
        this.oneHundredTenMetresHurdles = oneHundredTenMetresHurdles;
    }

    public double getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(double discusThrow) {
        this.discusThrow = discusThrow;
    }

    public double getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(double poleVault) {
        this.poleVault = poleVault;
    }

    public double getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(double javelinThrow) {
        this.javelinThrow = javelinThrow;
    }

    public String getOneThousandFiveHundredMetres() {
        return oneThousandFiveHundredMetres;
    }

    public void setOneThousandFiveHundredMetres(String oneThousandFiveHundredMetres) {
        this.oneThousandFiveHundredMetres = oneThousandFiveHundredMetres;
    }
}
