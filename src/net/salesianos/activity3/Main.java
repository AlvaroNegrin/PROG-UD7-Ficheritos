package net.salesianos.activity3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String FILE_DESTINY = "src/net/salesianos/files/input/activity3.txt";
        final String FILE_ROUTE1 = "src/net/salesianos/files/input/savetext.txt";
        final String FILE_ROUTE2 = "src/net/salesianos/files/output/activity2.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_DESTINY));
                BufferedReader bufferedReader1 = new BufferedReader(new FileReader(FILE_ROUTE1));
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(FILE_ROUTE2))) {

            String line = bufferedReader1.readLine();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line = bufferedReader2.readLine();
            bufferedWriter.write(line);

            System.out.println("Contenido escrito en el archivo.");
        } catch (IOException e) {
            System.err.println("ERROR: Problema de I/O.");
        }
    }
}
