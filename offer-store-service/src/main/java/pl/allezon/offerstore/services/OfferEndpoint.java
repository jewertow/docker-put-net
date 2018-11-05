package pl.allezon.offerstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allezon.offerstore.domain.Offer;
import pl.allezon.offerstore.repository.OfferRepository;

@RestController
@RequestMapping("/offers")
public class OfferEndpoint {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferEndpoint(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/{id}")
    public Offer getOffer(@PathVariable Long id) {
        return offerRepository.findOne(id);
    }
}
