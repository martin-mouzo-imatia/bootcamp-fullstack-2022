package es.imatia.units.control;

import es.imatia.units.objects.Garage;
import es.imatia.units.objects.Tournament;
import lombok.extern.java.Log;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log
public class Control implements Serializable {

    @Serial
    private static final long serialVersionUID = -1764976832469209140L;

    private static final Scanner scanner = new Scanner(System.in);

    private final List<Garage> garageList;

    private final List<Tournament> tournamentList;

    public Control() {
        garageList = new ArrayList<>();
        tournamentList = new ArrayList<>();
    }

    public void showMainMenu() {
        int option = 0;
        boolean finish = false;
        while (!finish) {
            do {
                System.out.println("0 - Saír");
                System.out.println("1 - Xestionar un torneo");
                System.out.println("2 - Xestionar garaxes");
                try {
                    option = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                   log.warning("Teclea unha opción válida");
                }

            } while (option < 0 || option > 2);
            switch (option) {
                case 0 -> finish = true;
                case 1 -> manageTournaments();
                case 2 -> manageGarages();
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }

    private void manageGarages() {

        int opcion;
        boolean finishOption = false;
        while (!finishOption) {
           tournamentList.forEach(t -> System.out.println(t.getTName().toUpperCase()));
            System.out.println("---------------------------------------------------------------------------------");
            do {
                System.out.println("0 - Volver atrás");
                System.out.println("1 - Crear un torneo");
                System.out.println("2 - Executar un torneo");
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    log.warning("Teclea unha opción válida");
                    opcion = 15;
                }
            } while (opcion < 0 || opcion > 3);
            switch (opcion) {
                case 0 -> finishOption = true;
               // case 1 -> createTournament();
              //  case 2 -> runTournaments();
                default -> throw new IllegalStateException("Unexpected value: " + opcion);
            }

        }
    }

    private void manageTournaments() {
    }

}
