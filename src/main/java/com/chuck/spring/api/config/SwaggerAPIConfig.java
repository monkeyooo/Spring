package com.chuck.spring.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerAPIConfig {
    static final String signControllerTag = "登入";
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .tags(new Tag(signControllerTag, "登入登出...等"))
                .select()//選擇哪些路徑和api會生成document
                .apis(RequestHandlerSelectors.any())//對所有Api進行監控
                .paths(PathSelectors.any())//對所有路徑進行掃描
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
    }

    private List<SecurityReference> defaultAuth() {
        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer", "Authorization", "header");
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 文件")
                .description("Swagger建立，Authorize請填Bearer {auth_token}" +
                        "\n ex: Bearer a252675781ab0df0dfcece305c91cc342400271409381f9b58ffc96fe5b78203df6f5751061ff9456d6eab502eb7eb80" +
                        "\n auth_token : Login後取得的token")
                .termsOfServiceUrl("http://com.rockmobile.qportdashboard")
                .license("Chuck")
                .licenseUrl("http://com.rockmobile.qportdashboard")
                .version("1.0.1")
                .build();
    }
}
