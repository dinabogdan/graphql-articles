package com.freesoft.graphqlarticlesdemo.repository;

import com.freesoft.graphqlarticlesdemo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List findByArticleId(Long id);
}
