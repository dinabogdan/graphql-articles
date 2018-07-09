package com.freesoft.graphqlarticlesdemo.repository;

import com.freesoft.graphqlarticlesdemo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
