package pl.allezon.offersearch.service

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.allezon.offersearch.domain.Offer
import pl.allezon.offersearch.repository.OfferRepository

@RestController
@RequestMapping("/offers")
class OfferEndpoint(
        private val offerRepository: OfferRepository
) {
    @GetMapping
    fun getOffers(@RequestParam(name = "q", required = false) query: String): List<Offer> {
        return offerRepository.findByNameOrDescription(query, query)
    }
}
