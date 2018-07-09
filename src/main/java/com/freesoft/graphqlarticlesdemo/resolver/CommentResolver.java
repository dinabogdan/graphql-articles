package com.freesoft.graphqlarticlesdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.freesoft.graphqlarticlesdemo.model.Comment;
import com.freesoft.graphqlarticlesdemo.model.Profile;
import com.freesoft.graphqlarticlesdemo.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {

    private final ProfileRepository profileRepository;

    public Profile getAuthor(Comment comment) {
        return profileRepository.findById(comment.getId()).get();
    }
}
