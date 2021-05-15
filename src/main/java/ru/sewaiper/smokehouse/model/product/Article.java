package ru.sewaiper.smokehouse.model.product;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "flavor")
    protected String flavor;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "amount")
    protected int amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected ArticleCategory category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected ArticleManufacturer manufacturer;

    public long getId() {
        return id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArticleCategory getCategory() {
        return category;
    }

    public void setCategory(ArticleCategory category) {
        this.category = category;
    }

    public ArticleManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ArticleManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Article{" +
                "flavor='" + flavor + '\'' +
                ", amount=" + amount +
                ", category=" + category +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
