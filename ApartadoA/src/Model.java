import java.util.*;

public class Model{
    private String name;
    private Integer pricePerDay;

    private List<Car> cars;
    
    public Model (String name, Integer pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.cars = new LinkedList<>();
        System.out.println("El modelo de coche " + name + " se ha creado correctamente");
    }

    //-------------getters--------------
    
    private String getName(){
        return this.name;
    }

    private Integer getpricePerDay(){
        return this.pricePerDay;
    }

    private List<Car> getCar(){
        return this.cars;
    }


    //------------- setters --------------
    
     private void setName(String name) {
        this.name = name;
    }

    private void setgetpricePerDay(Integer pricePerDay){
        this.pricePerDay = pricePerDay;
    }

    private void setCars(List<Car> cars){
        this.cars = cars;
    }

}
