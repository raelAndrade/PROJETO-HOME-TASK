package br.inpe.embrace;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()            
          .apis(RequestHandlerSelectors.basePackage("br.inpe.embrace.application.resource"))
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(this.apiInfo());                                           
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Embrance Home Task REST API", 
          "Embrance Home Task REST API", 
          "0.0.1", 
          "Terms of service", 
          new Contact("Israel Andrade", "www.inpe.br", "israel.andrade@inpe.br"), 
          "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}