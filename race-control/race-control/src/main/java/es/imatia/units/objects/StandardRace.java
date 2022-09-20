package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.util.function.Function;
import java.util.stream.IntStream;

@Data
public class StandardRace extends Race {

    private static final int STANDARD_DURATION = 3;

    @Serial
    private static final long serialVersionUID = -4741161257655362511L;

    private int duration;

    public StandardRace(int id, String raceName, int duration) {
        super(id, raceName);
        this.duration = duration;
    }

    public StandardRace(int id, String raceName) {
        super(id, raceName);
        this.duration = STANDARD_DURATION;
    }

    @Override
    protected void simulate() {
        super.simulate();
        IntStream.range(0, duration)
                .mapToObj(i -> carList.stream())
                .flatMap(Function.identity()).forEach(Car::randomSpeed);

        carList.forEach(c -> {
            if (first == null || first.getDistance() < c.getDistance()) {
                first = c;
            }

            if (second == null || (second != first && second.getDistance() < c.getDistance()
                    && second.getDistance() <= first.getDistance())) {
                second = c;
            }

            if (third == null || (third != second && third != first
                    && third.getDistance() < c.getDistance()
                    && third.getDistance() <= second.getDistance())) {
                third = c;
            }
        });

    }
}
