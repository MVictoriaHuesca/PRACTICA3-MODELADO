import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main_ej2 {
    public static void main(String[] args) {
        Model ferrari = new Model("Ferrari", 50);
        System.out.println("El modelo de coche Ferrari se ha creado correctamente");

        RentalOffice oficina1 = new RentalOffice("Av. Plutarco, 75", 20);
        System.out.println("La oficina situada en Av. Plutarco, 75 se ha creado correctamente");

        Car car = new Car("2587MDN", ferrari, oficina1);

        LocalDate returnDate = LocalDate.of(2023, 12, 31);

        // Poner el coche fuera de servicio
        car.takeOutOfService(returnDate);

        // Intentar ponerlo fuera de servicio nuevamente
        car.takeOutOfService(LocalDate.of(2024, 1, 15));
    }
}

