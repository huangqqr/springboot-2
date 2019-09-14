package com.hb.springboot.controller;

import com.hb.springboot.model.Article;
import com.hb.springboot.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "文章信息API")
@Slf4j
@RestController //(@Controller + @ResponseBody)
@RequestMapping("/rest")
public class ArticleRestController {


    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=Result.class),
            @ApiResponse(code=400,message="用户输入错误",response=Result.class),
            @ApiResponse(code=500,message="系统内部错误",response=Result.class)
    })
    @PostMapping("/article")
    public Result saveArticle(@RequestBody Article article) {
        log.info("saveArticle：{}",article);
        return  Result.success(article);
    }

    @ApiOperation(value = "删除文章", notes = "删除新的文章", tags = "id",httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=Result.class),
            @ApiResponse(code=400,message="用户输入错误",response=Result.class),
            @ApiResponse(code=500,message="系统内部错误",response=Result.class)
    })
    @DeleteMapping("/article/{id}")
    public Result deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}",id);
        return Result.success(id);
    }

    @ApiOperation(value = "修改文章", notes = "修改的文章", tags = "Article",httpMethod = "PUT")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=Result.class),
            @ApiResponse(code=400,message="用户输入错误",response=Result.class),
            @ApiResponse(code=500,message="系统内部错误",response=Result.class)
    })
    @PutMapping("/article/{id}")
    public Result updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}",article);
        return Result.success(article);
    }

    @ApiOperation(value = "查看文章", notes = "查看的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=Result.class),
            @ApiResponse(code=400,message="用户输入错误",response=Result.class),
            @ApiResponse(code=500,message="系统内部错误",response=Result.class)
    })
    @GetMapping( "/article/{id}")
    public Result getArticle(@PathVariable Long id) {
        Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").title("t1").build();
        return Result.success(article1);
    }
}