package src;
import java.time.*;

class InServiceState extends CarState {
    public InServiceState(Car car) {
        super(car);
    }

    public String toString() {
        return "In Service";
    }
}