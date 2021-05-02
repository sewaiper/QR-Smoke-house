package ru.sewaiper.smokehouse.repository.bid;

import org.bson.types.ObjectId;
import ru.sewaiper.smokehouse.model.bid.Bid;

import java.util.List;
import java.util.Optional;

public interface BidRepository {
    void insert(Bid bid);
    Optional<Bid> findById(ObjectId id);
    List<Bid> findAll();
}
