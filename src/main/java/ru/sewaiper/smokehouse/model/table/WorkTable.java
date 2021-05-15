package ru.sewaiper.smokehouse.model.table;

import ru.sewaiper.smokehouse.model.order.Order;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "list_tables")
public class WorkTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Column(name = "code", length = 100)
    protected String code;

    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @Access(AccessType.PROPERTY)
    protected Collection<Order> orders;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "WorkTable{" +
                "code='" + code + '\'' +
                '}';
    }
}
