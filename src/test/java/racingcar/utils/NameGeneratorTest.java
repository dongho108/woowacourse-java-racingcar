package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.utils.generator.NameGenerator;

class NameGeneratorTest {

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidParameters")
    @DisplayName("car 이름 생성 유효성 검사")
    void invalidCreate(String carNames, String testName) {
        assertThatThrownBy(() -> NameGenerator.generateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
            Arguments.of("", "빈 문자 입력"),
            Arguments.of(null, "널 입력"),
            Arguments.of("pobi,", "이름길이 0"),
            Arguments.of("pobi,pobi", "자동차이름 중복")
        );
    }

    @Test
    void 정상입력() {
        assertThat(NameGenerator.generateCarNames("pobi,crong,honux"))
                .contains("pobi", "crong", "honux");
    }
}
