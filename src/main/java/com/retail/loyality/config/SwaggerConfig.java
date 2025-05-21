package com.retail.loyality.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Customer loyalty API")
                        .description("API to work with Customer Profile and Transaction Data")
                        .version("1.0")
                        .contact(new Contact().name("Ashok Jung Bahadur").email("ashokjung@gmail.com").url("https://github.com/ashokjung"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .protocols(Collections.singleton("http"))
                .forCodeGeneration(true);
    }

}
