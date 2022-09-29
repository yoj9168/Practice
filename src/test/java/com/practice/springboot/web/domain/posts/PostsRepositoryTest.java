package com.practice.springboot.web.domain.posts;

import com.practice.springboot.domain.posts.Posts;
import com.practice.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        String title = "제목";
        String content = "내용";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("작가").build());

        List<Posts> postsLists = postsRepository.findAll();

        Posts posts = postsLists.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
