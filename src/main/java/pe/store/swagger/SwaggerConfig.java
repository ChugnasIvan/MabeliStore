package pe.store.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select().apis(
                        RequestHandlerSelectors.any()).paths(PathSelectors.any()).
                build().apiInfo(getApiInfo()).produces(formatosValidos()).consumes(formatosValidos());
    }
    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "MabeliStore API",
                "API que brinda acceso a los productos, ventas, clientes, etc de la empresa textil",
                "V.1.0",
                "Uso para la clase de Desarrollo de Servicios Web 2",
                new Contact("Christian Castillo", "www.idat.edu.pe", "D18361@idat.edu.pe"),
                "License of API", "API license URL", Collections.emptyList());
    }
    private Set<String> formatosValidos(){
        return new HashSet<String>(Arrays.asList("application/json","application/xml"));
    }

}