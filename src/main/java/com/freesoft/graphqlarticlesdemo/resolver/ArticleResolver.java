package com.freesoft.graphqlarticlesdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.freesoft.graphqlarticlesdemo.model.Article;
import com.freesoft.graphqlarticlesdemo.model.Comment;
import com.freesoft.graphqlarticlesdemo.model.Profile;
import com.freesoft.graphqlarticlesdemo.repository.CommentRepository;
import com.freesoft.graphqlarticlesdemo.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ArticleResolver implements GraphQLResolver<Article> {

    private final CommentRepository commentRepository;
    private final ProfileRepository profileRepository;

    public Profile getAuthor(Article article) {
        return profileRepository.findById(article.getId()).get();
    }

    public List<Comment> getComments(Article article) {
        return commentRepository.findByArticleId(article.getId());
    }
}
