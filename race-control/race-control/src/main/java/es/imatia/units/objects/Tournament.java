package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Data
public class Tournament implements Serializable {

    @Serial
    private static final long serialVersionUID = 4480465865312924548L;

    private List<Race> races;

    private HashMap<Car, Integer> ranking;

    private List<Car> participantes;

    private int id;

    private String tName;

    private int numRaces;

    private boolean finished;


    public void addCarsByGarage(Garage garage) {
        participantes.addAll(garage.getCarList());
    }

    public void addCarsByListGarages(List<Garage> garages) {
        if (garages.size() == 1) {
            addCarsByGarage(garages.get(0));
        } else {
            for (Garage g : garages) {
                Random r = new Random();
                Car c = g.getCarList().get(r.nextInt(garages.size()));
                participantes.add(c);
            }
        }

    }

}