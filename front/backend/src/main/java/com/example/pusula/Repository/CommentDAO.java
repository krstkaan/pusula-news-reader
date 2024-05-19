package com.example.pusula.Repository;

import com.example.pusula.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Integer> {
    List<Comment> findByArticleId(int articleId);
}
