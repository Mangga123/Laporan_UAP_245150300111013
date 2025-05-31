package uap.models;

import uap.bases.Shape;
import uap.interfaces.*;

public class Torus extends Shape implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {
    private double majorRadius;
    private double minorRadius;
    
    public Torus() {
        this(0, 0);
    }
    
    public Torus(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
        setName("Donat dengan lubang");
    }
    
    @Override
    public double getVolume() {
        return 2 * PI * PI * majorRadius * minorRadius * minorRadius;
    }
    
    @Override
    public double getSurfaceArea() {
        return 4 * PI * PI * majorRadius * minorRadius;
    }
    
    @Override
    public double getMass() {
        return getSurfaceArea() * THICKNESS * DENSITY;
    }
    
    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }
    
    @Override
    public double calculateCost() {
        return Math.ceil(gramToKilogram()) * PRICE_PER_KG;
    }
    
    @Override
    public void printInfo() {

        System.out.printf("Volume: %.2f cm³\n", getVolume());
        System.out.printf("Luas permukaan: %.2f cm²\n", getSurfaceArea());
        System.out.printf("Massa: %.2f g\n", getMass());
        System.out.printf("Massa dalam kg: %.2f kg\n", gramToKilogram());
        System.out.printf("Biaya kirim: Rp%.2f\n", calculateCost());
    }
}