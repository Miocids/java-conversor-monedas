package api.conversor;

public class ConversorClass {
    protected float conversionNumber;
    protected float conversionRate;

    public ConversorClass(float conversionNumber, float conversionRate) {
        this.conversionNumber = conversionNumber;
        this.conversionRate = conversionRate;
    }

    public float calculateConversion(){
        return this.conversionNumber * this.conversionRate;
    }
}
