package com.practice.springboot.web;

import com.practice.springboot.service.posts.PostsService;
import com.practice.springboot.web.dto.PostsResponseDto;
import com.practice.springboot.web.dto.PostsSaveRequestDto;
import com.practice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto){
        return postsService.save(postsSaveRequestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
        return postsService.update(id, postsUpdateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id ){
        return postsService.findById(id);
    }

}
