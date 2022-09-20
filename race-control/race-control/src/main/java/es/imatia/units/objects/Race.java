package es.imatia.units.objects;

import es.imatia.units.objects.interfaces.IRace;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Log
@NoArgsConstructor
public class Race implements IRace, Serializable {

    @Serial
    private static final long serialVersionUID = -4660634946405455853L;

    protected int id;

    protected String raceName;

    protected List<Garage> garageList = new ArrayList<>();

    protected List<Car> carList = new ArrayList<>();

    protected Car first;

    protected Car second;

    protected Car third;

    public Race(int id, String raceName) {
        this.id = id;
        this.raceName = raceName;
        this.garageList = new ArrayList<>();
        this.carList = new ArrayList<>();
        this.first = null;
        this.second = null;
        this.third = null;
    }


    @Override
    public List<Car> getParticipatingCars() {
        return carList;
    }

    @Override
    public void addCar(Car car) {
        carList.add(car);
        garageList.add(car.getGarage());
    }

    protected void simulate() {
        carList.forEach(Car::reset);
    }
}