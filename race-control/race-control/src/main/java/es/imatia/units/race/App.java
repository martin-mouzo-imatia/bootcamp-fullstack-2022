package es.imatia.units.race;

import es.imatia.units.control.CarControl;
import es.imatia.units.objects.Car;
import es.imatia.units.objects.Garage;
import es.imatia.units.objects.Race;
import es.imatia.units.objects.Tournament;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Garage> garages = new ArrayList<>();
        ArrayList<Race> races;
        ArrayList<Tournament> tournaments;

        garages.add(new Garage("Ferrari"));

        CarControl.addCar(sc,cars, garages);
    }
}
