package pl.allezon.offersearch.repository

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository
import pl.allezon.offersearch.domain.Offer

@Repository
interface OfferRepository : ElasticsearchRepository<Offer, Long> {

    fun findByNameOrDescription(name: String, description: String): List<Offer>

}
