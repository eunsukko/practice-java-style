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
    public void Isbn을_10자리_숫자로_만들경우_13자리로_채워주어요() {
//        assertThat()

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

    }

    @Test
    public void Isbn은_한글을_포함할수_없어요() {

    }
}