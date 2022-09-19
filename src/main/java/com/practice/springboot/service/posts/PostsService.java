package com.practice.springboot.service.posts;

import com.practice.springboot.domain.posts.Posts;
import com.practice.springboot.domain.posts.PostsRepository;
import com.practice.springboot.web.dto.PostsResponseDto;
import com.practice.springboot.web.dto.PostsSaveRequestDto;
import com.practice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물이 없습니다. id"+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물이 없습니다. id"+id));
        return new PostsResponseDto(entity);
    }
}
