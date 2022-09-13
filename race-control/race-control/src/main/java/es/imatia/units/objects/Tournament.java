package es.imatia.units.objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Tournament implements Serializable {

    @Serial
    private static final long serialVersionUID = 4480465865312924548L;

    private String tName;
    private ArrayList<Race> races;
    private Car[] reult;

    public Tournament(String tName, ArrayList<Race> races, Car[] reult) {
        this.tName = tName;
        this.races = races;
        this.reult = reult;
    }
}