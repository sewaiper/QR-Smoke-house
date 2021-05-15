package ru.sewaiper.smokehouse.model.order;

import ru.sewaiper.smokehouse.model.customer.Customer;
import ru.sewaiper.smokehouse.model.employee.Employee;
import ru.sewaiper.smokehouse.model.product.ProductConsumption;
import ru.sewaiper.smokehouse.model.table.WorkTable;
import ru.sewaiper.smokehouse.model.tobacco.TobaccoConsumption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "rating")
    protected int rating;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "comment")
    protected String comment;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "value")
    protected int value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "employee_id")
    @Access(AccessType.PROPERTY)
    protected Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    @Access(AccessType.PROPERTY)
    protected Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "table_id")
    @Access(AccessType.PROPERTY)
    protected WorkTable table;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected List<TobaccoConsumption> tobaccoConsumptions;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    protected List<ProductConsumption> productConsumptions;

    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public WorkTable getTable() {
        return table;
    }

    public void setTable(WorkTable table) {
        this.table = table;
    }

    public List<TobaccoConsumption> getTobaccoConsumptions() {
        return tobaccoConsumptions;
    }

    public void setTobaccoConsumptions(List<TobaccoConsumption> tobaccoConsumptions) {
        this.tobaccoConsumptions = tobaccoConsumptions;
    }

    public List<ProductConsumption> getProductConsumptions() {
        return productConsumptions;
    }

    public void setProductConsumptions(List<ProductConsumption> productConsumptions) {
        this.productConsumptions = productConsumptions;
    }

    @Override
    public String toString() {
        return "Order{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", value=" + value +
                ", employee=" + employee +
                ", customer=" + customer +
                ", table=" + table +
                '}';
    }
}
