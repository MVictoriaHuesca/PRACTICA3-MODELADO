import java.time.*;


class OutOfServiceState extends CarState{
    private LocalDateTime backToServiceDate;

    public OutOfServiceState(Car car, LocalDateTime backToServiceDate) {
        super(car);
        assert(backToServiceDate != null);
        this.backToServiceDate = backToServiceDate;
    }
}