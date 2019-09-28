package com.hb.springboot.config;

/**
 * @Package com.leapmotor.app.api.manager.config
 * @ClassName: SwaggerConfig
 * @Description:
 * @author YangLong [11208@leapmotor.com]
 * @date 2019-04-09
 *
 * @version V1.0
 */
//@Configuration
//@EnableSwagger2
////@EnableSwaggerBootstrapUI
//@Profile({"dev"})
public class SwaggerConfig {
    //private Parameter token = new ParameterBuilder().name("Authorization")
    //        .description("API平台分配的token,必须使用Bearer 开头")
    //        .required(true)
    //        .parameterType("header")
    //        .defaultValue("Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6IuWWu-a7lCIsInN1YiI6ImxvZ2luVG9rZW4iLCJpc3MiOiJsZWFwbW90b3JfcG9ydGFsIiwiYXVkIjoiMiIsImlhdCI6MTU2NTY4NDY1NiwiZXhwIjo0NzE5Mjg0NjU2fQ.wJT_7-4xxVPT-twfvIds-EceTrMtJ7ZVJMbHY9FuqhVustnCY-kolooY3YTkX5D0Q6W_JWaIUvayyB9Ka9mXnA")
    //        .modelRef(new ModelRef("string"))
    //        .build();

    //@Bean
    //public Docket api() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .apiInfo(apiInfo())
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage("com.hb.springboot"))
    //            .paths(PathSelectors.regex("/.*"))
    //            .build();
    //}
    //
    //
    //private ApiInfo apiInfo() {
    //    //Contact contact = new Contact("YangLong", "http://www.yanglong.site", "410357434@163.com");
    //    return new ApiInfo("API接口", "API文档", "V1", "No terms service", null, "YangLong", "http://www.yanglong.site");
    //}
}
