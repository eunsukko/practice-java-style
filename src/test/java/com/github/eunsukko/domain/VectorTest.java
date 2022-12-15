package com.github.eunsukko.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VectorTest {

    @Test
    public void 숫자로만_이루어진_문자열로_만들수있어요() {
        var vector_문자열로_생성 = Vector.fromNumberString("123");

        assertThat(vector_문자열로_생성)
                .isEqualTo(Vector.from(
                        asList(1, 2, 2)));
    }

    @Test
    public void fromNumberString은_숫자_이외의_글자를_포함할수없어요() {
        assertThatThrownBy(() -> Vector.fromNumberString("12x"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 내적을_구할수_있어요() {
        var a = Vector.from(asList(
                1, 3, 5
        ));

        var b = Vector.from(asList(
                2, 1, 3
        ));

        assertThat(a.dotProduct(b))
                .as("(1*2 + 3*1 + 5*3) == (2 + 3 + 15) == 20")
                .isEqualTo(20);
    }

    @Test
    public void 길이가_서로다른_벡터는_내적을_구할수_없어요() {
        var a = Vector.from(asList(
                1, 3, 5
        ));

        var b = Vector.from(asList(
                2, 1, 3, 4
        ));

        assertThatThrownBy(() -> a.dotProduct(b))
                .isInstanceOf(IllegalArgumentException.class);
    }
}