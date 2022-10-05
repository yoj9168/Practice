package com.practice.springboot.web;

import com.practice.springboot.service.posts.PostsService;
import com.practice.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllByDesc());
        return "index";
    }
    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "posts-update";
    }
}
