package com.example.pusula.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private int id;
    private String body;
    private LocalDateTime createdAt;
}
