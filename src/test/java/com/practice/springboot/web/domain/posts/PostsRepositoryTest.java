package com.practice.springboot.web.domain.posts;

import com.practice.springboot.domain.posts.Posts;
import com.practice.springboot.domain.posts.PostsRepository;
import javafx.geometry.Pos;
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

    @After //Junit에서 단위 테스트가 끝나면 수행되어야 하는 함수 -> 테스트 끝나면 DB를 비워야 하기 떄문
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글 제목";
        String content = "테스트 게시글 내용";

        postsRepository.save(Posts.builder() // post에 insert/update 쿼리 실행
                .title(title)
                .content(content)
                .author("ojun@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
