package net.salesianos.activities.activity4.utils.manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import net.salesianos.activities.activity4.utils.tables.Table;

public class DataManagement {
    private final static String FILE_ROUTE = "src/net/salesianos/activities/files/hybrid/activity4.txt";

    public static void saveTableOnFile(ArrayList<Table> tables) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(FILE_ROUTE)))) {

            objectOutputStream.writeObject(tables);

            System.out.println("Se ha escrito el fichero!");
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema de I/O");
        }
    }

    @SuppressWarnings("unchecked")
    public static void getTablesFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(FILE_ROUTE)))) {
            ArrayList<Table> tableList = new ArrayList<>();
            while (true) {
                tableList = (ArrayList<Table>) objectInputStream.readObject();
                System.out.println(tableList);
            }
        } catch (EOFException e) {
            System.out.println("Fin del arcivho");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase.");
        } catch (IOException e) {
            System.out.println("Se ha producido un error al leer el objeto");
        }
    }

}
