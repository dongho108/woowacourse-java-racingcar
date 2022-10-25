package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.utils.generator.ForwardGenerator;
import racingcar.utils.generator.MovableForwardGenerator;
import racingcar.utils.generator.NonMovableForwardGenerator;

class CarTest {
    private final ForwardGenerator movableForwardGenerator = new MovableForwardGenerator();
    private final ForwardGenerator nonMovableForwardGenerator = new NonMovableForwardGenerator();
    private final Car car = new Car("pobi");

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidParameters")
    @DisplayName("car 이름 생성 유효성 검사")
    void invalidCreate(String carName, String testName) {
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
            Arguments.of("", "한글자 미만"),
            Arguments.of(null, "널 입력"),
            Arguments.of("pobi,,crong", "이름길이 0"),
            Arguments.of("donghok", "5글자 초과")
        );
    }

    @Test
    void 자동차_전진() {
        int position = car.getPosition();
        car.forward(movableForwardGenerator);
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    void 자동차_정지() {
        int position = car.getPosition();
        car.forward(nonMovableForwardGenerator);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    void 자동차_생성_정상() {
        assertThatCode(() -> new Car("pobi"))
            .doesNotThrowAnyException();
    }
}