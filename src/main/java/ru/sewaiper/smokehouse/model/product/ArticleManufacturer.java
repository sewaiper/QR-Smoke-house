package ru.sewaiper.smokehouse.model.product;

import javax.persistence.*;

@Entity
@Table(name = "article_manufacturer")
public class ArticleManufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "name")
    protected String name;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "country")
    protected String country;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ArticleManufacturer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
