package racingcar.model;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.utils.generator.ForwardGenerator;
import racingcar.utils.generator.MovableForwardGenerator;

class CarsTest {
    private final Cars cars = new Cars();
    private Car car1;
    private Car car2;
    private final ForwardGenerator movableForwardGenerator = new MovableForwardGenerator();

    @BeforeEach
    void initialize() {
        cars.add(Arrays.asList("pobi", "crong", "honux"));
        List<Car> carList = this.cars.getCars();
        car1 = carList.get(0);
        car2 = carList.get(1);
    }

    @Test
    void 단독_우승자() {
        car1.forward(movableForwardGenerator);
        Assertions.assertThat(cars.findWinnerNames()).containsExactly(car1.getName());
    }

    @Test
    void 공동_우승자() {
        car1.forward(movableForwardGenerator);
        car2.forward(movableForwardGenerator);
        Assertions.assertThat(cars.findWinnerNames()).containsExactly(car1.getName(), car2.getName());
    }
}