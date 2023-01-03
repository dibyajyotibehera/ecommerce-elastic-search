package com.ecommerce.elasticsearch.Service;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.ecommerce.elasticsearch.Domain.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final ElasticsearchClient elasticsearchClient;

    public SearchService(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public ArrayList<Product> search(String query) throws IOException {
        ArrayList<Product> productSearchResults = new ArrayList();
        SearchResponse<Product> productSearchResponse = elasticsearchClient.search(s -> s
                .index("ecommerce-products-index")
                .query(q -> q
                        .bool(b -> b
                                .should(sh -> sh.term(t -> t.field("title").value(query)))
                                .should(sh -> sh.term(t -> t.field("description").value(query)))
                        )
                ), Product.class);
        List<Hit<Product>> hits = productSearchResponse.hits().hits();
        for (Hit<Product> hit : hits) {
            Product product = hit.source();
            product._score = hit.score();
            productSearchResults.add(product);
        }
        return productSearchResults;
    }
}
