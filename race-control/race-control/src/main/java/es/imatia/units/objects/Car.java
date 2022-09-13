package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Car implements Serializable {

    @Serial
    private static final long serialVersionUID = -3027072382282082404L;
    private Integer carId;
    private String brand;
    private String model;
    private Garage garage;
    private int points;

    public Car(Integer carId, String brand, String model, Garage garage) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.garage = garage;
    }

    @Override
    public String toString() {
        return
                "Número=" + carId +
                        ", Marca='" + brand + '\'' +
                        ", Modelo='" + model + '\'';
    }
}
