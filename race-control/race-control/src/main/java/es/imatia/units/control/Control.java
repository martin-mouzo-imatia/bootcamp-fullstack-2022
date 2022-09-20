package es.imatia.units.control;

import es.imatia.units.objects.Car;
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

    private void manageTournaments() {

        int option = 8;
        boolean finishOption = false;
        while (!finishOption) {
            tournamentList.forEach(t -> System.out.println(t.getTName().toUpperCase()));
            System.out.println("---------------------------------------------------------------------------------");
            do {
                System.out.println("0 - Volver atrás");
                System.out.println("1 - Crear un torneo");
                System.out.println("2 - Executar un torneo");
                try {
                    option = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    log.warning("Teclea unha opción válida");
                }
            } while (option < 0 || option > 3);
            if (option == 0) {
                finishOption = true;
                // case 1 -> createTournament();
                //  case 2 -> runTournaments();
            } else {
                throw new IllegalStateException("Unexpected value: " + option);
            }

        }
    }

    private void manageGarages() {
        int opcion;
        garageList.forEach(g -> System.out.println(g.getGarageName().toUpperCase()));
        System.out.println("---------------------------------------------------------------------------------");

        do {
            System.out.println("0 - Volver atrás");
            System.out.println("1 - Crear un garaxe");
            System.out.println("2 - Engadir un coche a un garaxe");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                log.warning("Teclea unha opción válida");
                opcion = 8;
            }
        } while (opcion < 0 || opcion > 2);
        switch (opcion) {
            case 0:
                break;
            case 1:
                int id;
                String team;
                System.out.println("Escribe o identificador do teu novo garaxe");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Escribe o nome do garaxe");
                team = scanner.nextLine();
                garageList.add(new Garage(id, team));
                break;
            case 2:
                int idCar;
                String model;
                String brand;
                int idGaraxe;
                System.out.println("Identificación do coche");
                idCar = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Escribe o teu modelo");
                model = scanner.nextLine();
                System.out.println("Escribe a túa marca");
                brand = scanner.nextLine();
                System.out.println("Escriba o ID do garaxe ao que pertence");
                idGaraxe = scanner.nextInt();
                scanner.nextLine();
                Garage garage = null;

                garage = garageList.stream().filter(g -> g.getId() == idGaraxe)
                        .findAny().orElse(null);

                if (garage == null) {
                    log.warning("O garaxe co identificador " + idGaraxe + " non exite.");
                    break;
                }

                Car coche = new Car(idCar, model, brand, garage);
                garage.addCar(coche);
                garage.getCarList().forEach(System.out::println);
                break;

        }
    }
}