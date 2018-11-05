package pl.allezon.offerstore.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import pl.allezon.offerstore.domain.Offer

@Repository
trait OfferRepository extends MongoRepository[Offer, String] {
  def findById(id: String): Offer
}
