package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RaceCar implements Serializable {

    @Serial
    private static final long serialVersionUID = -2690221786522189496L;

    private Car car;

    private int carPoints = 0;

    private double carDistance = 0;

    public RaceCar(Car car) {
        this.setCar(car);
    }

    public void resetDistance() {
        this.carDistance = 0;
    }

    public void addCarPoints(int points) {
        this.carPoints += points;
    }

}
