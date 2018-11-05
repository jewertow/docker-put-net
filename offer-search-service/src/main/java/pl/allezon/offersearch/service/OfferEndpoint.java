package pl.allezon.offersearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.allezon.offersearch.domain.Offer;
import pl.allezon.offersearch.repository.OfferRepository;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferEndpoint {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferEndpoint(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping
    public List<Offer> getOffers(@RequestParam(name = "q", required = false) String query) {
        return offerRepository.findByNameOrDescription(query, query);
    }
}
