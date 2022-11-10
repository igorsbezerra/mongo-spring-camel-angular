package dev.igor.camel.products;

import dev.igor.camel.dto.ProductDto;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class GetProductsRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:list-products")
                .removeHeaders("*")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8080/products")
                .unmarshal().json(JsonLibrary.Jackson, ProductDto[].class)
                .end();
    }
}
