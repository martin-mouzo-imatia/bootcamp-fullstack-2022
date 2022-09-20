package es.imatia.units.objects.interfaces;

import es.imatia.units.objects.Car;

import java.util.List;

public interface IRace {

    String getRaceName();

    List<Car> getParticipatingCars();

    void addCar(Car car);

}
