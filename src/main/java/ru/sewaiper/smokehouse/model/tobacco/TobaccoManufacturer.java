package ru.sewaiper.smokehouse.model.tobacco;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tobacco_manufacturer")
public class TobaccoManufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "name")
    protected String name;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Collection<Tobacco> tobaccos;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "manufacturer='" + name + "'";
    }
}
