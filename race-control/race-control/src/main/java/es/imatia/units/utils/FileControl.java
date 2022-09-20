package es.imatia.units.utils;

import lombok.extern.java.Log;

@Log
public class FileControl {

  /*  public static void loadCars(List<Car> cars, List<Garage> garages) throws FileNotFoundException {
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

    }*/

}