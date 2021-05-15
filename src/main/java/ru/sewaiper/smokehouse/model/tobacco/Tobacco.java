package ru.sewaiper.smokehouse.model.tobacco;

import javax.persistence.*;

@Entity
@Table(name = "tobacco")
public class Tobacco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "flavor", length = 500, nullable = false)
    protected String flavor;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "strength")
    protected int strength;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "smokiness")
    protected int smokiness;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    protected TobaccoManufacturer manufacturer;

    public long getId() {
        return id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

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

    public TobaccoManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(TobaccoManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Tobacco{" +
                "flavor='" + flavor + '\'' +
                ", strength=" + strength +
                ", smokiness=" + smokiness +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
