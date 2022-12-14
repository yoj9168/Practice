package com.practice.springboot.service.posts;

import com.practice.springboot.domain.posts.Posts;
import com.practice.springboot.domain.posts.PostsRepository;
import com.practice.springboot.web.dto.PostsListsResponseDto;
import com.practice.springboot.web.dto.PostsResponseDto;
import com.practice.springboot.web.dto.PostsSaveRequestDto;
import com.practice.springboot.web.dto.PostsUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateDto updateDto) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id = "+ id));
        entity.update(updateDto.getTitle(), updateDto.getContent());
        return id;
    }
    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id = "+ id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListsResponseDto> findAllByDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListsResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id = "+id));
        postsRepository.delete(entity);
    }
}
