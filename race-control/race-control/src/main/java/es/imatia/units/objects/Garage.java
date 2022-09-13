package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Garage implements Serializable {

    @Serial
    private static final long serialVersionUID = -3018470697289643324L;
    private String garageName;

    public Garage(String garageName) {
        this.garageName = garageName;
    }
}