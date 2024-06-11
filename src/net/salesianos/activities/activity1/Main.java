package net.salesianos.activities.activity1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner SC = new Scanner(System.in);

        System.out.println("Dame un texto de 30 caracteres o mas");
        String userText = SC.nextLine();

        while (userText.length() < 30) {
            System.out.println("Te faltan " + (30 - userText.length())
                    + " caracteres para llegar al minimo de 30\n Escribe el texto de nuevo");
            userText = SC.nextLine();
        }

        userText = userText.toUpperCase().replaceAll(" ", "_");

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/net/salesianos/files/input/savetext.txt"))) {

            bufferedWriter.write(userText);

            System.out.println("Escrito con exito");
        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O.");
        }

        SC.close();
    }

}
