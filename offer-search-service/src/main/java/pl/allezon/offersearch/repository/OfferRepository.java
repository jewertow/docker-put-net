package pl.allezon.offersearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import pl.allezon.offersearch.domain.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends ElasticsearchRepository<Offer, Long> {

    List<Offer> findByNameOrDescription(String name, String description);
}
