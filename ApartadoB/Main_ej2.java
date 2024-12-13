import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main_ej2 {
    public static void main(String[] args) {
        Model ferrari = new Model("Ferrari", 50);

        RentalOffice oficina1 = new RentalOffice("Av. Plutarco, 75", 20);

        Car car = new Car("2587MDN", ferrari, oficina1);

        LocalDate returnDate = LocalDate.of(2023, 12, 31);

        // Poner el coche fuera de servicio
        car.takeOutOfService(returnDate);

        // Intentar ponerlo fuera de servicio nuevamente
        car.takeOutOfService(LocalDate.of(2024, 1, 15));
    }
}

