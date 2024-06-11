package net.salesianos.activity4.utils.menu;

import java.util.ArrayList;
import java.util.Scanner;

import net.salesianos.activity4.utils.manager.DataManagement;
import net.salesianos.activity4.utils.tables.Table;

public class Menu {
    private static ArrayList<Table> tables = new ArrayList<>();
    private static boolean isKeepAsking;
    private final static Scanner SC = new Scanner(System.in);

    public static void setKeepAsking(boolean keepAsking) {
        isKeepAsking = keepAsking;
    }

    public static boolean isKeepAsking() {
        return isKeepAsking;
    }

    public static void showMainMenu() {
        String menu = """
                \n*-----------------------------------------*
                |             Mesas latinas               |
                *-----------------------------------------*
                | 1.- Nueva Mesa                          |
                | 2.- Mostrar mesas almacenadas           |
                | 3.-Salir                                |
                *-----------------------------------------*
                """;
        System.out.println(menu);
    }

    public static void userSelection() {
        String tableColor;
        int tableFeet;
        String userText = SC.nextLine();
        switch (userText) {
            case "1":
                System.out.println("\nIntroduzca el color de la mesa:\n");
                tableColor = SC.nextLine();
                System.out.println("\nIntroduzca el numero de patas de la mesa:\n");
                tableFeet = SC.nextInt();
                SC.nextLine();
                tables.add(new Table(tableColor, tableFeet));
                DataManagement.saveTableOnFile(tables);
                break;
            case "2":
                DataManagement.getTablesFromFile();
                break;
            case "3":
                setKeepAsking(false);
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }

}
