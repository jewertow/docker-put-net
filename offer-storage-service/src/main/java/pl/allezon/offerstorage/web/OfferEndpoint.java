package pl.allezon.offerstorage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.allezon.offerstorage.domain.Offer;
import pl.allezon.offerstorage.service.OfferService;

@RestController
public class OfferEndpoint {

    private final OfferService offerService;

    @Autowired
    public OfferEndpoint(OfferService offerService) {
        this.offerService = offerService;
    }

    @PutMapping("/offer")
    public void createOffer(@RequestBody Offer offer) {
        this.offerService.createOffer(offer);
    }
}
