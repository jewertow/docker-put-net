package pl.allezon.offersearch.domain

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "offer")
data class Offer(
        val id: Long,
        val name: String,
        val description: String
)