package com.hb.springboot.service;

import com.hb.springboot.dao.Article;
import com.hb.springboot.dao.ArticleRepository;
import com.hb.springboot.model.ArticleVO;
import com.hb.springboot.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ArticleRestJPAServiceImpl implements ArticleRestService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    public ArticleVO saveArticle(ArticleVO article) {

        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);

        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        //把读者查出来
        ArticleVO articleVO = dozerMapper.map(article.get(),ArticleVO.class);
        //articleVO.setReader();
        return articleVO;
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleLis = articleRepository.findAll();

        return DozerUtils.mapList(articleLis,ArticleVO.class);

    }
}
