package src;
import java.time.*;

public abstract class CarState {
    Car car;

    public CarState(Car car) {
        assert(car != null);
        this.car = null;
    }
}