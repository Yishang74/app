package com.mayikt.config;
 
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/**
* Swagger2 相关配置
*/
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfig {
     
    /**
    * 创建api
    * @return
    */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            // api接口扫包范围
            .apis(RequestHandlerSelectors.basePackage("com.mayikt.service"))
            .paths(PathSelectors.any())
            .build();
         
    }
     
    /**
    * 配置api信息
    *
    * @return
    */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .description("javaApi接口文档")
            .contact(new Contact("王深沪京", "https://www.mayikt.com", "804205093@qq.com"))
            .version("v1.1.0")
            .title("API测试文档")
            .build();
    }
     
}