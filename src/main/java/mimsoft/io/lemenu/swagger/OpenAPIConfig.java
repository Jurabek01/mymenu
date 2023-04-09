package mimsoft.io.lemenu.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class OpenAPIConfig {

    @Value("${lamenu.openapi.dev-url}")
    private String devUrl;

    @Value("${lamenu.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI LamenuOpenApi() {
        Server devServer = new io.swagger.v3.oas.models.servers.Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("jurabek.rustamov1999@gmail.com");
        contact.setName("Jurabek Rustamov");
        contact.setUrl("https://mimsoft.io");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://mimsoft.io/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }

}
