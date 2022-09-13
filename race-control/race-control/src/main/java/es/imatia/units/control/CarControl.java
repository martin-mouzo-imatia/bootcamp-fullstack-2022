package es.imatia.units.control;

import es.imatia.units.objects.Car;
import es.imatia.units.objects.Garage;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Scanner;

@Log
public class CarControl {

    public static void addCar(Scanner sc, List<Car> cars, List<Garage> garages) {

        Garage garage = null;
        boolean verified = false;
        int num = 0;

        do {
            verified = true;
            System.out.println("Número do vehículo:\n");
            num = sc.nextInt();
            sc.nextLine();

            for (Car car : cars) {

                if (car.getCarId().equals(num)) {
                    verified = false;
                    break;
                }
            }


            if (!verified) {
                log.warning("Xa existe un coche co número " + num);
            }

        } while (!verified && num > 0);

        add(sc, cars, garages, garage, num);

    }
    private static void add(Scanner sc, List<Car> cars, List<Garage> garages, Garage garage, int num) {
        if (num != 0) {
            System.out.println("Marca do vehículo:\n");
            String marca = sc.nextLine();
            System.out.println("Modelo:\n");
            String modelo = sc.nextLine();
            System.out.println("Nome do garaxe:\n");
            if (garages.isEmpty()) {
                log.warning("Non hai garaxes rexistrados");
            } else {
                garages.forEach(gar -> System.out.println(gar.getGarageName()));
            }


            String gName = sc.nextLine();
            for (Garage value : garages) {

                if (value.getGarageName().equalsIgnoreCase(gName)) {
                    garage = value;
                }
            }
            cars.add(new Car(num, marca, modelo, garage));
        } else {
            log.warning("Erro ó rexistrar");
        }
    }

    public static void deleteCar(Scanner sc, List<Car> cars) {
        System.out.println("Número do vehículo que desexa borrar:\n");
        int num = sc.nextInt();
        Car deleteCar = cars.stream().filter(car -> car.getCarId().equals(num)).findAny().orElse(null);
        cars.remove(deleteCar);
        log.info("Eliminado correctamente");
    }

    public static void showCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }

}