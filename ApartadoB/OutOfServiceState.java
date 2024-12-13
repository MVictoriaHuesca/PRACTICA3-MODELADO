import java.time.*;


class OutOfServiceState extends CarState{
    private LocalDateTime backToServiceDate;
    private Car car;

    public OutOfServiceState(Car car, LocalDateTime backToServiceDate) {
        super(car);
        this.backToServiceDate = backToServiceDate;
    }

}