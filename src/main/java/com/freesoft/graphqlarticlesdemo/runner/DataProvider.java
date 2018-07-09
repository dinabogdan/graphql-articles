package com.freesoft.graphqlarticlesdemo.runner;

import com.freesoft.graphqlarticlesdemo.model.Article;
import com.freesoft.graphqlarticlesdemo.model.Comment;
import com.freesoft.graphqlarticlesdemo.model.Profile;
import com.freesoft.graphqlarticlesdemo.repository.ArticleRepository;
import com.freesoft.graphqlarticlesdemo.repository.CommentRepository;
import com.freesoft.graphqlarticlesdemo.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataProvider implements CommandLineRunner {

    private final ProfileRepository profileRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        Profile author = Profile.builder()
                .username("JohnDoe")
                .bio("The author")
                .build();

        Profile admin = Profile.builder()
                .username("admin")
                .bio("The admin")
                .build();

        profileRepository.save(author);
        profileRepository.save(admin);

        Article firstArticle = Article.builder()
                .title("Hello World")
                .text("This is a hello world post")
                .authorId(author.getId())
                .build();

        Article secondArticle = Article.builder()
                .title("Foo")
                .text("FooBar")
                .authorId(author.getId())
                .build();

        Article adminArticle = Article.builder()
                .title("Admin article")
                .text("How to admin a blog")
                .authorId(admin.getId())
                .build();

        articleRepository.save(firstArticle);
        articleRepository.save(secondArticle);
        articleRepository.save(adminArticle);

        Comment firstComment = Comment.builder()
                .authorId(author.getId())
                .articleId(firstArticle.getId())
                .text("Do you like my article?")
                .build();

        Comment secondComment = Comment.builder()
                .authorId(admin.getId())
                .articleId(firstArticle.getId())
                .text("Yes, I like you article!")
                .build();

        Comment thirdComment = Comment.builder()
                .authorId(admin.getId())
                .articleId(adminArticle.getId())
                .text("This is an admin comm")
                .build();

        commentRepository.save(firstComment);
        commentRepository.save(secondComment);
        commentRepository.save(thirdComment);

    }
}
