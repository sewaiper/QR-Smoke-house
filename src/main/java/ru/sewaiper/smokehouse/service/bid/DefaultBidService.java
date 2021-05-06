package ru.sewaiper.smokehouse.service.bid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sewaiper.smokehouse.exception.bid.BidServiceException;
import ru.sewaiper.smokehouse.model.bid.Bid;
import ru.sewaiper.smokehouse.repository.bid.BidRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DefaultBidService implements BidService {
    private enum BidType {
        SHISHA,
        PRODUCT
    }

    private final BidRepository repository;

    @Autowired
    public DefaultBidService(BidRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerBid(Bid bid) throws BidServiceException {
        validateBid(bid);
        bid.setId(new ObjectId());
        repository.insert(bid);
    }

    @Override
    public void confirmBid(ObjectId bid, String type) throws BidServiceException {
        try {

        }
        catch (NoSuchElementException e) {
            throw new BidServiceException(1);
        }
    }

    @Override
    public void completeBid(ObjectId bid, String type) throws BidServiceException {

    }

    @Override
    public List<Bid> loadActiveBids() {
        return null;
    }

    @Override
    public List<Bid> loadAllBids() {
        return repository.findAll();
    }

    protected void validateBid(Bid bid) throws BidServiceException {

    }
}
