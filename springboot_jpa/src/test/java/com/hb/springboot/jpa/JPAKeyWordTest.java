package com.hb.springboot.jpa;

import com.hb.springboot.dao.jpa1.Article;
import com.hb.springboot.dao.jpa1.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("黄阿博");
        System.out.println(article);
    }

}
