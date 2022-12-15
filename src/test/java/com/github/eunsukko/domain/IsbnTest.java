package com.github.eunsukko.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class IsbnTest {

    @Test
    public void Isbn은_13자리_숫자로_만들수있어요() {
        String 숫자_13자리 = "9791187506072";

        var isbn = Isbn.from(숫자_13자리);

        assertThat(isbn.toString())
                .isEqualTo(숫자_13자리);
    }

    @Test
    public void Isbn을_10자리_숫자로_만들수있어요() {
//        assertThat()
        // 정상적으로 생성되는지
        // 13자리로 기대하는 값이 나오는지
    }

    @Test
    public void Isbn의_글자수는_10자리_혹은_13자리만_가능해요() {
        String isbn_이_될수없는_글자수 = "1";

        assertThatThrownBy(() -> Isbn.from(isbn_이_될수없는_글자수))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Isbn은_영문을_포함할수_없어요() {
        String 영문을_포함한_문자열 = "aaa1234567890";

        assertThatThrownBy(() -> Isbn.from(영문을_포함한_문자열))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Isbn은_특수문자를_포함할수_없어요() {
        String 특수문자를_포함한_문자열 = "!001234567890";

        assertThatThrownBy(() -> Isbn.from(특수문자를_포함한_문자열))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Isbn은_한글을_포함할수_없어요() {
        String 한글을_포함한_문자열 = "가001234567890";

        assertThatThrownBy(() -> Isbn.from(한글을_포함한_문자열))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 출처: 나무위키
    // 1. 10 자리 ISBN을 (A,B,C,D,E,F,G,H,I,J) 라 하고, 마지막 J를 제외한 (A,B,C,D,E,F,G,H,I) 벡터를 만든다. 이 벡터를 b 라 한다.
    // 2. a = (1,2,3,4,5,6,7,8,9) 라 한다.
    // 3. ( a · b ) % 11 의 값을 J 로 정하되, 이 값이 10일 경우는 X로 표기한다. 점곱은 유클리드 내적이다. A*1+B*2+C*3+.....9*I
    @Test
    public void Isbn10이_유효한지를_체크번호를_통해_확인해요() {

    }

    // 출처: 나무위키
    // 1. 13 자리 ISBN을 (A,B,C,D,E,F,G,H,I,J,K,L,M) 라 하고, 이 벡터를 b 라 한다.
    // 2. a = (1,3,1,3,1,3,1,3,1,3,1,3,1) 라 한다.
    // 3. ( a · b ) % 10 의 값이 0이 되어야 한다.
    @Test
    public void Isbn13이_유효한지를_체크번호를_통해_확인해요() {

    }

}