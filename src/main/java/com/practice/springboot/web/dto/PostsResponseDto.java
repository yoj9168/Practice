package com.practice.springboot.web.dto;

import com.practice.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsResponseDto {
    private Long id;
    private String content;
    private String title;
    private String author;

    public PostsResponseDto(Posts posts){
        this.id = posts.getId();
        this.content = posts.getContent();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
    }
}
