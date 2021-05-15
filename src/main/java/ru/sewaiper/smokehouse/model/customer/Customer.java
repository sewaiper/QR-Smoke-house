package ru.sewaiper.smokehouse.model.customer;


import ru.sewaiper.smokehouse.model.order.Order;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "first_name")
    protected String firstName;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "last_name")
    protected String lastName;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "phone", length = 10)
    protected String phone;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @Access(AccessType.PROPERTY)
    protected Collection<Order> orders;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
