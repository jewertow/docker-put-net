package pl.allezon.offerstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.allezon.offerstore.domain.Offer;

@Repository
public interface OfferRepository extends MongoRepository<Offer, Long> {
}
