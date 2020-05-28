package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

// 이 페이지에서 컴파일 오류가날 경우 그레이들 버전5 문제이다.
// 그레이들 다운그레이드 필요
// terminal 에서 "gradlew wrapper --gradle-version 4.10.2" 적용
public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        // 1 assertThat
        // assertj 라는 테스트 검증 라이브러리의 검증 메소드입니다.
        // 검증하고 싶은 대상의 메소드 인자로 받습니다.
        // 메소드 체이닝이 지원되어 isEquialTo 와 같이 메소드를 이어서 사용할 수 있습니다.
        // 2 isEqualTo
        // assertj 의 동등비교 메소드입니다.
        // assertThat 에 있는 값과 isEqualTo 의 값을 비교하여 같을 때만 성공.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }
}
