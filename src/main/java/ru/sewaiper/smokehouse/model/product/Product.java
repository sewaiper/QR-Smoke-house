package ru.sewaiper.smokehouse.model.product;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "name")
    protected String name;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "type")
    protected String type;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "amount")
    protected int amount;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
