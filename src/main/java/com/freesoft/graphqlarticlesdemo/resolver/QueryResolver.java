package com.freesoft.graphqlarticlesdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.freesoft.graphqlarticlesdemo.model.Article;
import com.freesoft.graphqlarticlesdemo.model.Comment;
import com.freesoft.graphqlarticlesdemo.model.Profile;
import com.freesoft.graphqlarticlesdemo.repository.ArticleRepository;
import com.freesoft.graphqlarticlesdemo.repository.CommentRepository;
import com.freesoft.graphqlarticlesdemo.repository.ProfileRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QueryResolver implements GraphQLQueryResolver {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final ProfileRepository profileRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public Article getArticle(Long id) {
        return articleRepository.findById(id).get();
    }
}
