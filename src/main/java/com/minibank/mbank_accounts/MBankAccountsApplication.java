package com.minibank.mbank_accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class MBankAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MBankAccountsApplication.class, args);
    }
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/bank/*"))
                .apis(RequestHandlerSelectors.basePackage("com.bank.demo"))
                .build()
                .apiInfo(apiCustomData());
    }

    private ApiInfo apiCustomData(){
        return new ApiInfo(
                "Bank API Application",
                "Bank Documentation",
                "1.0",
                "Bank Service Terms",
                new Contact("xxx", "http://bank.com",
                        "contact@bank.com"),
                "",
                "http://bank.com",
                Collections.emptyList()
        );
    }
}
