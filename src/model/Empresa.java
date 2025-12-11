package model;

public class Empresa {

    private static final int HIGH_RISK_LEVEL= 3;
    private String id;
    private String name;
    private int riskLevel;
    private double roi;
    private double investmentAmount;
    private double investmentTimePeriod;

    public Empresa(String id, String name, int riskLevel, double roi, double investmentAmount, double investmentTimePeriod) {
        this.id = id;
        this.name = name;
        this.riskLevel = riskLevel;
        this.roi = roi; 
        this.investmentAmount = investmentAmount; 
        this.investmentTimePeriod = investmentTimePeriod;
    }

    public static int getHighRiskLevel() {
        return HIGH_RISK_LEVEL;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public double getInvestmentTimePeriod() {
        return investmentTimePeriod;
    }

    public void setInvestmentTimePeriod(double investmentTimePeriod) {
        this.investmentTimePeriod = investmentTimePeriod;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", name=" + name + ", riskLevel=" + riskLevel + ", roi=" + roi
                + ", investmentAmount=" + investmentAmount + ", investmentTimePeriod=" + investmentTimePeriod + "]";
    }
}
