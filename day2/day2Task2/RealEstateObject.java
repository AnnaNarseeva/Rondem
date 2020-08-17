package day2Task2;

public class RealEstateObject {

    double objectSquare;
    double meterPrice;
    double fullPrice;

    public RealEstateObject() {
    }

    public RealEstateObject(double objectSquare, double meterPrice, double fullPrice) {
        this.objectSquare = objectSquare;
        this.meterPrice = meterPrice;
        this.fullPrice = fullPrice;
    }

    public double getObjectSquare() {
        return objectSquare;
    }

    public void setObjectSquare(double objectSquare) {
        this.objectSquare = objectSquare;
    }

    public double getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(double meterPrice) {
        this.meterPrice = meterPrice;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }
}
