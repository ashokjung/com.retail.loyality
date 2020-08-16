package com.retail.loyality.config;


import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerClubcard;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.response.CustomerResponse;
import com.retail.loyality.security.request.JwtRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docketapi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.retail.loyality.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey())).protocols(Collections.singleton("HTTP"))
                .ignoredParameterTypes(Customer.class, CustomerAddress.class, CustomerContactDetails.class, CustomerClubcard.class, JwtRequest.class, CustomerResponse.class);

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Customer loyalty API")
                .description("API to work with Customer Profile and Transaction Data")
                .termsOfServiceUrl("http://localhost:8081/swagger-ui.html")
                .version("1.0")
                .contact(new Contact("Ashok Jung Bahadur", "https://github.com/ashokjung", "ashokjung@gmail.com"))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}
