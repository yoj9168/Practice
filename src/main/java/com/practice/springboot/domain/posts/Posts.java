package com.practice.springboot.domain.posts;

import javafx.geometry.Pos;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //게터
@NoArgsConstructor //생성자 알아서 만들어줌
@Entity //테이블과 링크될 클래스 -> table 이름을 기본값으로 UserFind.java면 user_find 로 함
public class Posts {
    @Id //PK-> id 필드가 PK임을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙을 말함 -> 이 코드를 써야 auto_increment 가 됨
    //지금과 같은 경우에는 id가 PK 이기 때문에 id로 식별한다. 그러므로, ID는 같으면 안된다.
    //auto_increment 를 하면 알아서 id는 하나씩 증가한다. INSERT로 다른 필드를 삽입하면 id 값은 자동으로 1,2,3,,,, 으로 들어간다 이 말이다.
    private Long id;

    @Column(length = 500, nullable = false) // 굳이 이 column을 적지 않더라도 필드는 column이 된다.
    // 하지만 @Column을 통해 attribute 설정을 할 수 있다. 지금과 같은 경우는 최대 길이를 500으로 하고, NULL값을 허용하지 않게 한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //PK 는 Long type의 auto_increment 를 추천, 주민번호 등은 유니크 키로 사용
    //Entity class는 절대로 Setter Method 사용 X
    //생성자를 통해 최종값을 채우고, DB에 삽입하자 && 값 변경이 필요하면 해당 이벤트에 맞는 public method를 호출하자

    public void update(String title, String content){
        this.content = content;
        this.title = title;
    }
}
