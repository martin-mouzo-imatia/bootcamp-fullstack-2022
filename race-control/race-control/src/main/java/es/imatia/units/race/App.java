package es.imatia.units.race;

import es.imatia.units.control.CarControl;
import es.imatia.units.objects.Car;
import es.imatia.units.objects.Garage;
import es.imatia.units.objects.Race;
import es.imatia.units.objects.Tournament;
import es.imatia.units.utils.FileControl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        List<Garage> garages = new ArrayList<>();
        List<Race> races;
        List<Tournament> tournaments;


        FileControl.loadCars(cars, garages);
        cars.forEach(System.out::println);
        garages.forEach(System.out::println);


    }
}
