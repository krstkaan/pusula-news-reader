package com.example.pusula.Service;

import com.example.pusula.DTO.CommentDTO;
import com.example.pusula.Entity.Article;
import com.example.pusula.Entity.Comment;
import com.example.pusula.Repository.ArticleDAO;
import com.example.pusula.Repository.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;
    private final ArticleDAO articleDAO;

    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO, ArticleDAO articleDAO) {
        this.commentDAO = commentDAO;
        this.articleDAO = articleDAO;
    }

    @Override
    public void addComment(CommentDTO commentDTO, int articleId) {
        Comment comment = new Comment();
        comment.setBody(commentDTO.getBody());
        comment.setCommentedAt(LocalDateTime.now());
        Article article = articleDAO.(articleId).orElseThrow(() -> new RuntimeException("Article not found"));
        comment.setArticle(article);
        commentDAO.save(comment);
    }

    @Override
    public List<CommentDTO> getCommentsByArticleId(int articleId) {
        List<Comment> comments = commentDAO.findByArticleId(articleId);
        return comments.stream().map(comment -> {
            CommentDTO dto = new CommentDTO();
            dto.setId(comment.getId());
            dto.setBody(comment.getBody());
            dto.setCreatedAt(comment.getCommentedAt());
            return dto;
        }).collect(Collectors.toList());
    }
}
