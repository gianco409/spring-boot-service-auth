package pe.com.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	@Value("${server.openapi.url}")
	private String url;

	@Bean
	public OpenAPI myOpenAPI() {
		Server server = new Server();
		server.setUrl(url);
		server.setDescription("Server URL");

		Contact contact = new Contact();
		contact.setEmail("gianco@gmail.com");
		contact.setName("Gianmarcos Perez");

		License mitLicense = new License().name("NN").url("https://nn.com/licenses/mit/");

		Info info = new Info()
				.title("Prueba Tecnica Service API")
				.version("1.0")
				.contact(contact)
				.description("Prueba tecnica: Api de Notas implementado usando Spring Security + JWT")
				.license(mitLicense);

		return new OpenAPI().info(info).servers(List.of(server));
	}
}
