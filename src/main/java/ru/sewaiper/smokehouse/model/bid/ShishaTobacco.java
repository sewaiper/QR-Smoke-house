package ru.sewaiper.smokehouse.model.bid;

public class ShishaTobacco {
    protected Integer id;
    protected String brand;
    protected String flavour;
    protected Integer percent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Tobacco { ");
        if(brand != null) builder.append("Brand: ").append(brand).append(" ");
        if(flavour != null) builder.append("Flavour: ").append(flavour).append(" ");
        if(percent != null) builder.append("Percent: ").append(percent).append(" ");
        builder.append("}");

        return builder.toString();
    }
}
