package com.github.eunsukko.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VectorTest {

    @Test
    public void 숫자로만_이루어진_문자열로_만들수있어요() {
        var vector_문자열로_생성 = Vector.fromNumberString("123");

        assertThat(vector_문자열로_생성)
                .isEqualTo(Vector.from(
                        Arrays.asList(1, 2, 2)));
    }

    @Test
    public void fromNumberString은_숫자_이외의_글자를_포함할수없어요() {
        assertThatThrownBy(() -> Vector.fromNumberString("12x"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}