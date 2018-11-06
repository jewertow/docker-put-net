package pl.allezon.offercache.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping, RestController}
import pl.allezon.offercache.domain.Offer
import pl.allezon.offercache.repository.OfferRepository

@RestController
@RequestMapping(Array("/offers"))
class OfferEndpoint @Autowired()(val offerRepository: OfferRepository) {

  @GetMapping(Array("/{id}"))
  def getOffer(@PathVariable id: String): Offer = offerRepository.findById(id)
}
