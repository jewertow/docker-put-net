package pl.allezon.offersearch.domain

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "offer")
open class Offer {
    var id: Long? = null
    var name: String? = null
    var description: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Offer

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Offer(id=$id, name=$name, description=$description)"
    }

}