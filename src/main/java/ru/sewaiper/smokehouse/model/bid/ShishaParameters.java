package ru.sewaiper.smokehouse.model.bid;

public class ShishaParameters {
    protected int strength;
    protected int smokiness;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSmokiness() {
        return smokiness;
    }

    public void setSmokiness(int smokiness) {
        this.smokiness = smokiness;
    }

    @Override
    public String toString() {
        return  "Strength: " + strength + "\n" +
                "Smokiness: " + smokiness;
    }
}
