package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
//1 entity
// 테이블과 링크될 클래스임을 나타낸다.
// 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
@Entity
public class Posts extends BaseTimeEntity {

    // 2 id - 해당 테이블의 Pk  필드를 나타낸다.
    @Id
    // 3 generatedvalue - pk 생성규칙을 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 4 테이블 칼럼을 나타내며, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}