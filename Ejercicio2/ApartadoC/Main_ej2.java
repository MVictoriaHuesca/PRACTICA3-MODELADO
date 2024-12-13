package src;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main_ej2 {
    public static void main(String[] args) {
        LocalDateTime fecha1 = LocalDateTime.of(LocalDate.of(2021,12,8), LocalTime.of(10,28));


        Model ferrari = new Model("Ferrari", 50);

        RentalOffice oficina1 = new RentalOffice("Av. Plutarco, 75", 20);

        Car coche1 = new Car("2587MDN", ferrari, oficina1);
        Car coche2 = new Car("7856BPM", ferrari, oficina1);
        Car coche3 = new Car("1234ABC", ferrari, oficina1);

        System.out.println("\nEl estado del coche 1 antes de la operación es: " + coche1.getState().toString());
        System.out.println("El estado del coche 2 antes de la operación es: " + coche2.getState().toString());
        System.out.println("El estado del coche 3 antes de la operación es: " + coche3.getState().toString() + "\n");

        System.out.println("CASO 1: El coche 1 se pone fuera de servicio y hay un coche sustituto disponible");
        coche1.takeOutOfService(fecha1);
        System.out.println("El estado del coche 1 tras la operación es: " + coche1.getState().toString());
        System.out.println("El estado del coche 2 tras la operación es: " + coche2.getState().toString());
        System.out.println("El estado del coche 3 tras la operación es: " + coche3.getState().toString() + "\n");
        
        System.out.println("CASO 2: Se intenta poner fuera de servicio un coche que es sustituto");
        coche2.takeOutOfService(fecha1);
        System.out.println("El estado del coche 1 tras la operación es: " + coche1.getState().toString());
        System.out.println("El estado del coche 2 tras la operación es: " + coche2.getState().toString());
        System.out.println("El estado del coche 3 tras la operación es: " + coche3.getState().toString() + "\n");

        System.out.println("CASO 3: Se pone fuera de servicio un coche que ya está fuera de servicio");
        coche1.takeOutOfService(fecha1);
        System.out.println("El estado del coche 1 tras la operación es: " + coche1.getState().toString());
        System.out.println("El estado del coche 2 tras la operación es: " + coche2.getState().toString());
        System.out.println("El estado del coche 3 tras la operación es: " + coche3.getState().toString() + "\n");

        System.out.println("CASO 4: Se pone fuera de servicio un coche pero no hay coche sustituto disponible");
        coche3.takeOutOfService(fecha1);
        System.out.println("El estado del coche 1 tras la operación es: " + coche1.getState().toString());
        System.out.println("El estado del coche 2 tras la operación es: " + coche2.getState().toString());
        System.out.println("El estado del coche 3 tras la operación es: " + coche3.getState().toString() + "\n");
        
    }
}

