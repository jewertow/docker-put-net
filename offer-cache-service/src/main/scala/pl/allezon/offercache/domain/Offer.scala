package pl.allezon.offercache.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "offers")
case class Offer(@Id id: String, name: String, description: String)