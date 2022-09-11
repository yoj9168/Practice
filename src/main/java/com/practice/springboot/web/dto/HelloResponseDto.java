package com.practice.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //getter역할, 필드의 게터 생성
@RequiredArgsConstructor // final이 붙은 필드 생정자 모두 만들어줌(final 없으면 생성자 안만듬)
public class HelloResponseDto {
    final private String name;
    final private int amount;
}
