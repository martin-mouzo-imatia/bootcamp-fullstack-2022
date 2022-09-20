package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

@Data
public class Car implements Serializable {

    @Serial
    private static final long serialVersionUID = -3027072382282082404L;

    private static final int MAX_SPEED = 250;

    private int id;

    private String brand;

    private String model;

    private Garage garage;

    private float distance;

    private int speed;

    public Car(int id, String brand, String model, Garage garage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.garage = garage;
        this.distance = 0;
        this.speed = 0;
    }

    public void reset() {
        speed = 0;
        distance = 0;
    }

    public void randomSpeed() {
        Random random = new Random();
        speed += random.nextBoolean() ? 10 : -10;
        speed = Math.max(speed, 0);
        speed = Math.max(speed, MAX_SPEED);

        distance += speed / 60f;
    }

}