package ru.sewaiper.smokehouse.controller.bid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sewaiper.smokehouse.exception.bid.BidServiceException;
import ru.sewaiper.smokehouse.model.bid.Bid;
import ru.sewaiper.smokehouse.service.bid.BidService;

import java.util.List;

@RestController
public class BidController {
    private final BidService service;

    @Autowired
    public BidController(BidService service) {
        this.service = service;
    }

    @PostMapping("/bid/register")
    public void registerBid(@RequestBody Bid bid) {
        try {
            service.registerBid(bid);
        } catch (BidServiceException e) {

        }
    }

    @PostMapping(value = "/bid/{type}/confirm", consumes = "application/json")
    public void confirmBid(@RequestBody ObjectId id, @PathVariable("type") String type) {
        try {
            service.confirmBid(id, type);
        } catch (BidServiceException e) {

        }
    }

    @PostMapping(value = "/bid/{type}/complete", consumes = "application/json")
    public void completeBid(@RequestBody ObjectId id, @PathVariable("type") String type) {
        try {
            service.completeBid(id, type);
        } catch (BidServiceException e) {

        }
    }

    @GetMapping(value = "/bid/load/active", produces = "application/json")
    public List<Bid> loadActiveBids() {
        return service.loadActiveBids();
    }

    @GetMapping(value = "/bid/load/all", produces = "application/json")
    public List<Bid> loadAllBids() {
        return service.loadAllBids();
    }
}
