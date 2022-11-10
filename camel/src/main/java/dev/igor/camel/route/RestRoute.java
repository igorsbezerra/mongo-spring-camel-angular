package dev.igor.camel.route;

import dev.igor.camel.dto.ProductDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {
    @Value("${server.port}")
    String serverPort;

    @Value("${baeldung.api.path}")
    String contextPath;

    @Override
    public void configure() throws Exception {
        restConfiguration().contextPath(contextPath) //
                .port(serverPort)
                .enableCORS(true)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Test REST API")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true") // cross-site
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true");

        rest("/products")
                .consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
                .get().outType(ProductDto[].class).to("direct:list-products")
                .post().to("direct:create-products");
    }
}
