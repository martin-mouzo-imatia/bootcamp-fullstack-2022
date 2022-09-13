package es.imatia.units.control;

import es.imatia.units.objects.Garage;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Scanner;

@Log
public class GarageControl {

    public static void addGarage(Scanner sc, List<Garage> garages) {
        System.out.println("Nome do garaxe:\n");
        String gName = sc.nextLine();

        if (garages.isEmpty()) {
            garages.add(new Garage(gName));
            log.info("Garaxe engadido correctamente");
        } else {
            boolean b = garages.stream().anyMatch(garage -> garage.getGarageName().equals(gName));

            if (b==true) {
                log.warning("Xa existe un garaxe co nome " + gName);
            } else {
                garages.add(new Garage(gName));
            }
        }

    }

}