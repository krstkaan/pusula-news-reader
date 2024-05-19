package com.example.pusula.Service;

import com.example.pusula.DTO.CommentDTO;
import java.util.List;

public interface CommentService {
    void addComment(CommentDTO commentDTO, int articleId);
    List<CommentDTO> getCommentsByArticleId(int articleId);
}
