package es.imatia.units.utils;

import es.imatia.units.objects.Car;
import es.imatia.units.objects.Garage;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Log
public class FileControl {

    public static void loadCars(List<Car> cars, List<Garage> garages) throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/cars.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                cars.add(new Car(Integer.parseInt(data[0]), data[1], data[2], new Garage(data[3])));
                garages.add(new Garage(data[3]));
                garages = garages.stream().distinct().collect(Collectors.toList());
                int cantidade = cars.size();
                int numGaraxes = garages.size();
                log.info("Cantidade de coches: " + cantidade + "\n" + "Número de garaxes: " + numGaraxes);
            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

}