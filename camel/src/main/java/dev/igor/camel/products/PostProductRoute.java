package dev.igor.camel.products;

import dev.igor.camel.dto.ProductDto;
import dev.igor.camel.dto.ProductRequestDto;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class PostProductRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:create-products")
                .removeHeader("*")
                .setHeader(Exchange.HTTP_METHOD, simple("POST"))
                .marshal().json(JsonLibrary.Jackson, ProductRequestDto.class)
                .to("http://localhost:8080/products?bridgeEndpoint=true")
                .unmarshal().json(JsonLibrary.Jackson, ProductDto.class)
                .end();
    }
}
