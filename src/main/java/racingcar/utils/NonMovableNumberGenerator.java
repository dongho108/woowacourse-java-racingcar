package racingcar.utils;

public class NonMovableNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 1;
    }
}