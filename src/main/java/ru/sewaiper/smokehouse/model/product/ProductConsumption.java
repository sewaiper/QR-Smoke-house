package ru.sewaiper.smokehouse.model.product;

import ru.sewaiper.smokehouse.model.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "product_consumption")
public class ProductConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "amount", nullable = false)
    protected int amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected Order order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected Article article;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected Product product;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductConsumption{" +
                "amount=" + amount +
                ", order=" + order +
                ", article=" + article +
                ", product=" + product +
                '}';
    }
}
