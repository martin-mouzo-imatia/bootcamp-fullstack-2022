package es.imatia.units.objects;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Race implements Serializable {

    @Serial
    private static final long serialVersionUID = -4660634946405455853L;

    private String rName;
    private RaceType type;
    private List<Car> cars = new ArrayList<>();
    private Car[] podium;

    public Race(String rName, RaceType type, List<Car> cars, Car[] podium) {
        this.rName = rName;
        this.type = type;
        this.cars = cars;
        this.podium = podium;
    }

    public String getType() {
        if (type.equals(RaceType.ESTANDAR)) {
            return "Estándar";
        } else if (type.equals(RaceType.ELIMINACION)) {
            return "Eliminación";
        }
        return StringUtils.EMPTY;
    }

    public void standadRace() {
        type = RaceType.ESTANDAR;
    }

    public void removalRace() {
        type = RaceType.ELIMINACION;
    }
}