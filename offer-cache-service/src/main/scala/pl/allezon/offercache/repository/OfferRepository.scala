package pl.allezon.offercache.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import pl.allezon.offercache.domain.Offer

@Repository
trait OfferRepository extends MongoRepository[Offer, String] {
  def findById(id: String): Offer
}
