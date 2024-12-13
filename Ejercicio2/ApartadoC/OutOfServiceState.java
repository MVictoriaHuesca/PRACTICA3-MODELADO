package src;
import java.time.*;


class OutOfServiceState extends CarState{
    private LocalDateTime backToServiceDate;

    public OutOfServiceState(Car car, LocalDateTime backToServiceDate) {
        super(car);
        assert(backToServiceDate != null);
        this.backToServiceDate = backToServiceDate;
    }

    public String toString() {
        return "Out of service until " + this.backToServiceDate;
    }
}