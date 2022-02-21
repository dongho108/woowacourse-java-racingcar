package racingcar.utils.generator;

public class NonMovableForwardGenerator implements ForwardGenerator {
    @Override
    public boolean canForward() {
        return false;
    }
}
