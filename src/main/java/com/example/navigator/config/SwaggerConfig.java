package com.example.navigator.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final String API_V1 = "/api/v1/navigator";

    @Value("${catalog.swagger.enable:true}")
    private boolean enable;

    @Bean
    public Docket retrievalWebDocs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .groupName("catalog")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.navigator.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Data Manager Catalog RESTful API Document")
                .description("REST API powered by Swagger2")
                .version("1.0.0")
                .build();
    }
}
