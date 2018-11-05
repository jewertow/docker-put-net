package pl.allezon.offersearch.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "offer")
public class Offer {

    private Long id;
    private String name;
    private String description;
}