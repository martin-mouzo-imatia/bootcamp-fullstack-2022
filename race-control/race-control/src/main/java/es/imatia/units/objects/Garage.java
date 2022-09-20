package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Garage implements Serializable {

    @Serial
    private static final long serialVersionUID = -3018470697289643324L;

    private int id;

    private String garageName;

    private List<Car> carList;

    public Garage(int id, String garageName) {
        this.id = id;
        this.garageName = garageName;
        this.setCarList(new ArrayList<>());
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    @Override
    public String toString() {
        return garageName;
    }
}