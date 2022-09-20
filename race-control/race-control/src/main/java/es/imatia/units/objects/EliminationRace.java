package es.imatia.units.objects;


import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class EliminationRace extends Race {

    static final int heating = 3;
    @Serial
    private static final long serialVersionUID = 3740140040559771804L;

    public EliminationRace(int id, String raceName) {
        super(id, raceName);
    }

    public int getLaps() {
        return carList.size() - 1;
    }

    @Override
    protected void simulate() {
        super.simulate();
        for (int i = 0; i < heating; i++) {
            for (Car c : carList) {
                c.randomSpeed();
            }
        }

        int numLaps = getLaps();
        List<Car> cars = new ArrayList<>();
        cars.addAll(carList);

        for (int l = 0; l < numLaps; l++) {
            cars.forEach(Car::randomSpeed);
            Car lastCar = null;
            for (Car c : cars) {
                if (lastCar == null || c.getDistance() < lastCar.getDistance()) {
                    lastCar = c;
                }
            }
            if (cars.size() == 3) {
                this.third = lastCar;
            }

            if (cars.size() == 2) {
                this.second = lastCar;
            }

            cars.remove(lastCar);
        }
        this.first = cars.get(0);
    }
}
