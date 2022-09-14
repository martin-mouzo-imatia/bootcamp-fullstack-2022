package es.imatia.units.control;

import es.imatia.units.objects.Car;
import es.imatia.units.objects.Race;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Log
public class RaceControl {


    public static void startRace(Scanner sc, List<Car> cars, List<Race> races) {
        System.out.println("Nome da carreira:\n");
        String raceName = sc.nextLine();
        System.out.println("Tipo de carreira: ELIMINACIÓN|ESTÁNDAR\n");
        String tipo = sc.nextLine();
        System.out.println("Nome da escudería");
        String garaxe = sc.nextLine();

        createRace(cars, races, raceName, tipo, garaxe);
    }

    private static void createRace(List<Car> cars, List<Race> races, String raceName, String tipo, String garaxe) {
        List<Car> participants = new ArrayList<>();
        Race race = new Race();
        race.setRName(raceName);

        if (tipo.equals("ESTÁNDAR")) {
            race.standadRace();
        } else if (tipo.equals("ELIMINACIÓN")) {
            race.removalRace();
        }

        if (cars.stream().anyMatch(c -> c.getGarage().getGarageName().equals(garaxe))) {
            participants.addAll(cars);
        } else {
            log.warning("Erro ó engadir o vehículo");
        }

        if (!participants.isEmpty()) {
            race.setCars(participants);
        } else {
            race.setCars(Collections.emptyList());
        }
        races.add(race);
        log.info("Carreira engadida.");
    }


    private static void showRaces(List<Race> races) {
        races.forEach(r -> {

            System.out.println("Nome da carreira : " + r.getRName() + "\n");
            System.out.println("Tipo de carreira : " + r.getType() + "\n");
            Car[] podium = r.getPodium();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Primero posto : " + podium[0].getBrand() + " " + podium[0].getModel());
            System.out.println("Segundo posto : " + podium[1].getBrand() + " " + podium[1].getModel());
            System.out.println("Terceiro posto : " + podium[2].getBrand() + " " + podium[2].getModel());

        });
    }


}