package es.imatia.units.objects.interfaces;

import es.imatia.units.objects.Car;

import java.util.List;

public interface IRace {

  public  String getRaceName();

  public  List<Car> getParticipatingCars();

  public  void addCar(Car car);

}
