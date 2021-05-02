package ru.sewaiper.smokehouse.model.bid;

import org.bson.types.ObjectId;

public class Bid {
    protected ObjectId id;
    protected ShishaBid shishaBid;
    protected ProductBid productBid;
    protected Integer table;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ShishaBid getShishaBid() {
        return shishaBid;
    }

    public void setShishaBid(ShishaBid shishaBid) {
        this.shishaBid = shishaBid;
    }

    public ProductBid getProductBid() {
        return productBid;
    }

    public void setProductBid(ProductBid productBid) {
        this.productBid = productBid;
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Bid order on table " + table +
                shishaBid;
    }
}
