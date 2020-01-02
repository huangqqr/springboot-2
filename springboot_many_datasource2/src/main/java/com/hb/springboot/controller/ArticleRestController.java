package com.hb.springboot.controller;

import com.hb.springboot.model.Article;
import com.hb.springboot.model.Result;
import com.hb.springboot.service.ArticleRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Slf4j
@Controller
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "articleRestJDBCServiceImpl")
    ArticleRestService articleRestService;


    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = Result.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = Result.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = Result.class)
    })
    //@RequestMapping(value = "/article", method = POST, produces = "application/json")
    @PostMapping("/article")
    public @ResponseBody
    Result saveArticle(@RequestBody Article article) {
    /*public @ResponseBody  Result saveArticle(@RequestParam String  id,
                                                   @RequestParam String  author) {*/


        log.info("articleRestService return :" + articleRestService.saveArticle(article));

        return Result.success(article);
    }

    //@RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public @ResponseBody
    Result deleteArticle(@PathVariable Long id) {

        articleRestService.deleteArticle(id);

        return Result.success(id);
    }

    //@RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public @ResponseBody
    Result updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        articleRestService.updateArticle(article);

        return Result.success(article);
    }

    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public @ResponseBody
    Result getArticle(@PathVariable Long id) {

        return Result.success(articleRestService.getArticle(id));
    }


    //@RequestMapping(value = "/article", method = GET, produces = "application/json")
    @GetMapping("/article")
    public @ResponseBody
    Result getAllArticle() {

        return Result.success(articleRestService.getAll());
    }
}