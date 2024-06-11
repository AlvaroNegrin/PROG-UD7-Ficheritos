package net.salesianos.activities.activity2alvaro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader lector = new BufferedReader(
                new FileReader("src/net/salesianos/activities/activity2alvaro/texto.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                for (char caracter : linea.toCharArray()) {
                    int valorAscii = (int) caracter;
                    System.out.print(caracter + "_" + valorAscii + ", ");
                }
            }
        } catch (IOException e) {
            System.err.println("ERROR: Problema de I/O.");
        }
    }
}
