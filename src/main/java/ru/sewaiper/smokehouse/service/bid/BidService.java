package ru.sewaiper.smokehouse.service.bid;

import org.bson.types.ObjectId;
import ru.sewaiper.smokehouse.exception.bid.BidServiceException;
import ru.sewaiper.smokehouse.model.bid.Bid;

import java.util.List;

public interface BidService {
    void registerBid(Bid bid) throws BidServiceException;
    void confirmBid(ObjectId bid, String type) throws BidServiceException;
    void completeBid(ObjectId bid, String type) throws BidServiceException;
    List<Bid> loadActiveBids();
    List<Bid> loadAllBids();
}
