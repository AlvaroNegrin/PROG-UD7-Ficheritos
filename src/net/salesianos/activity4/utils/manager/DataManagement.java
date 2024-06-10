package net.salesianos.activity4.utils.manager;

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

import net.salesianos.activity4.utils.tables.Table;

public class DataManagement {
    public static void keepTableOnFile(ArrayList<Table> tables) {
        String fileRoute = "src/net/salesianos/files/hybrid/activity4.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileRoute)))) {

            objectOutputStream.writeObject(tables);

            System.out.println("Se ha escrito el fichero!");
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema de I/O");
        } 
    }

    @SuppressWarnings("unchecked")
    public static void getKeepedTablesFromFile() {
        String fileRoute = "src/net/salesianos/files/hybrid/activity4.txt";
        try (ObjectInputStream objectInputStream = new ObjectInputStream( new BufferedInputStream(new FileInputStream(fileRoute)))) {
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
