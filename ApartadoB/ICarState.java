import java.time.*;

interface ICarState {
    void takeOutOfService(Car car, LocalDate backToServiceDate);
}