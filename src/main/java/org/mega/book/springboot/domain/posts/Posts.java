package org.mega.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mega.book.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    /*
    * @Builder
    * 해당 클래스의 빌더 패턴 클래스 생성, 클래스 안에 클래스 만드는 것 = 내부 클래스 = 빌더패턴 (보안 향상을 위해서)
    * 생성자 상단에 선언 시 생성자에 포한된 필드만 빌더에 포함
    * 객체를 생성하는 클래스와 표현하는 클래스를 분리/ 서로 다른 표현으로 제공
    */
    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
