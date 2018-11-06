package pl.allezon.offerstorage.persistence;

import pl.allezon.offerstorage.domain.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
