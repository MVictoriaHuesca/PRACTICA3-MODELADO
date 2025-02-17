package src;
import java.util.*;

public class Model{
    private String name;
    private Integer pricePerDay;

    private List<Car> cars;
    
    public Model (String name, Integer pricePerDay) {
        assert(name != null && pricePerDay != null);
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.cars = new LinkedList<>();
        System.out.println("El modelo de coche " + name + " se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------
    
    private String getName(){
        return this.name;
    }

    private Integer getpricePerDay(){
        return this.pricePerDay;
    }

    protected Enumeration<Car> getCars(){
        return Collections.enumeration(this.cars);
    }

//-------------------- SETTERS --------------------------
    
    private void setName(String name) {
        assert(name != null);
        this.name = name;
    }

    private void setpricePerDay(Integer pricePerDay){
        assert(pricePerDay != null);
        this.pricePerDay = pricePerDay;
    }


    protected void addCar(Car car){
        assert(cars != null && !cars.contains(car));
        this.cars.add(car);
    }

    protected void removeCar(Car car){
        assert(cars != null && cars.contains(car));
        this.cars.remove(car);
    }
}
