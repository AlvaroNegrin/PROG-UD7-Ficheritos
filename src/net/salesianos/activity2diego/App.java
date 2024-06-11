package net.salesianos.activity2diego;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        String fileRoute = "src/net/salesianos/files/output/activity2.txt";

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(fileRoute))) {
            String textContent = "";
            char asciLetters = (char) bufferReader.read();
            while ((int) asciLetters != 65535) {

                textContent = asciLetters + "_" + (int) asciLetters + ", ";
                System.out.print(textContent);

                asciLetters = (char) bufferReader.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema de I/O");
        }
    }
}
