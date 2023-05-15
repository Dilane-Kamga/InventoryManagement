package com.kamtech.inventorymanagement.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("API for Inventory Management")
                                .title("Inventory Management API")
                                .build()
                )
                .groupName("Inventory Management REST API V1.0.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kamtech.inventorymanagement"))
                .paths(PathSelectors.ant(APP_ROOT + "/**"))
                .build();
    }
}
