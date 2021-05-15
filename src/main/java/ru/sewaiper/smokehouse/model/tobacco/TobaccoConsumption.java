package ru.sewaiper.smokehouse.model.tobacco;

import ru.sewaiper.smokehouse.model.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "tobacco_consumption")
public class TobaccoConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "amount")
    protected int amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    protected Order order;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tobacco_id")
    protected Tobacco tobacco;

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tobacco getTobacco() {
        return tobacco;
    }

    public void setTobacco(Tobacco tobacco) {
        this.tobacco = tobacco;
    }
}
